package com.fiap.g5.msorder.order.gateway.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "poc-spring-cloud-produto-service")
public interface ProdutoClient {

    @PatchMapping("/produto/produtos/{id}/stock/decrement")
    void decrementStock(@PathVariable("id") Long productId,
                        @RequestParam("quantity") int quantidade);

    @PatchMapping("/produto/produtos/{id}/stock/increment")
    void incrementStock(@PathVariable("id") Long productId,
                        @RequestParam("quantity") int quantidade);
}
