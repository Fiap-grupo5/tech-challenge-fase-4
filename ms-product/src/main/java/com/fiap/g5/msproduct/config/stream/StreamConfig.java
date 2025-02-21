package com.fiap.g5.msproduct.config.stream;

import com.fiap.g5.msproduct.usecase.DecrementStockUseCase;
import com.fiap.g5.msproduct.usecase.IncrementStockUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class StreamConfig {

    public record StockUpdateEvent(Long productId, int quantity, boolean increment) {}

    @Bean
    public Consumer<StockUpdateEvent> stockUpdateConsumer(IncrementStockUseCase incrementStockUseCase,
                                                            DecrementStockUseCase decrementStockUseCase) {
        return event -> {
            if (event.increment()) {
                incrementStockUseCase.execute(event.productId(), event.quantity());
            } else {
                decrementStockUseCase.execute(event.productId(), event.quantity());
            }
        };
    }
}
