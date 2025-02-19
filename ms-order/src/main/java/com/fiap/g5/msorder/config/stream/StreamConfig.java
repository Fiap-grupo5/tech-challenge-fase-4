package com.fiap.g5.msorder.config.stream;

import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamConfig {

    public record StockUpdateEvent(Long productId, int quantity, boolean increment) {}

}
