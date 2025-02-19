package com.fiap.g5.msproduct.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/batch")
public class BatchController {

    private final JobLauncher jobLauncher;
    private final Job importProductJob;

    public BatchController(JobLauncher jobLauncher, Job importProductJob) {
        this.jobLauncher = jobLauncher;
        this.importProductJob = importProductJob;
    }

    @PostMapping(value = "/upload-csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            Path tempFile = Files.createTempFile("products-", ".csv");
            Files.write(tempFile, file.getBytes());

            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("file.path", tempFile.toString())
                    .addLong("timestamp", System.currentTimeMillis())
                    .toJobParameters();

            jobLauncher.run(importProductJob, jobParameters);

            return ResponseEntity.ok("CSV uploaded and batch job started successfully!");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing CSV file: " + e.getMessage());
        }
    }
}
