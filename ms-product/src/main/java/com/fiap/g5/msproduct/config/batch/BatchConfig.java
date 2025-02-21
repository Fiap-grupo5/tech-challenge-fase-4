package com.fiap.g5.msproduct.config.batch;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.gateway.ProductGateway;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.LocalDateTime;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Product> productItemReader(
            @Value("#{jobParameters['file.path']}") String filePath
    ) {
        FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
        Resource resource = new FileSystemResource(filePath);
        reader.setResource(resource);
        reader.setLinesToSkip(1);

        DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("name", "description", "category", "price", "stock");
        lineMapper.setLineTokenizer(tokenizer);

        BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Product.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public ItemProcessor<Product, Product> productItemProcessor() {
        return product -> {
            if (product.getCreatedAt() == null) {
                product.setCreatedAt(LocalDateTime.now());
            }
            product.setUpdatedAt(LocalDateTime.now());
            return product;
        };
    }

    @Bean
    public ItemWriter<Product> productItemWriter(ProductGateway productGateway) {
        // Para cada produto lido, utiliza o gateway para criar o registro (o gateway fará a conversão e persistência)
        return items -> items.forEach(productGateway::create);
    }

    @Bean
    public Step importProductStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<Product> productItemReader,
            ItemProcessor<Product, Product> productItemProcessor,
            ItemWriter<Product> productItemWriter
    ) {
        return new StepBuilder("importProductStep", jobRepository)
                .<Product, Product>chunk(10, transactionManager)
                .reader(productItemReader)
                .processor(productItemProcessor)
                .writer(productItemWriter)
                .build();
    }

    @Bean
    public Job importProductJob(
            JobRepository jobRepository,
            Step importProductStep
    ) {
        return new JobBuilder("importProductJob", jobRepository)
                .start(importProductStep)
                .build();
    }
}
