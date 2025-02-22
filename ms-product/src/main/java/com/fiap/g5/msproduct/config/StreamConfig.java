package com.fiap.g5.msproduct.config;

import com.fiap.g5.msproduct.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class StreamConfig {

    public record StockUpdateEvent(Long productId, int quantity, boolean increment) {}

    @Bean
    public Consumer<StockUpdateEvent> stockUpdateConsumer(ProductService productService) {
        return event -> {
            if (event.increment()) {
                productService.incrementStock(event.productId(), event.quantity());
            } else {
                productService.decrementStock(event.productId(), event.quantity());
            }
        };
    }    
}
