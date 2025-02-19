package com.fiap.g5.msorder.config.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockUpdateProducer {

    private final StreamBridge streamBridge;

    public void sendStockUpdateEvent(Long productId, int quantity, boolean increment) {
        var event = new StreamConfig.StockUpdateEvent(productId, quantity, increment);
        streamBridge.send("stockUpdate-out-0", event);
    }
}
