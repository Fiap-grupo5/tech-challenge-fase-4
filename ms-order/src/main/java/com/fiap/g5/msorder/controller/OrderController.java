package com.fiap.g5.msorder.controller;

import com.fiap.g5.msorder.domain.Order;
import com.fiap.g5.msorder.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final CancelOrderUseCase cancelOrderUseCase;
    private final ConfirmOrderUseCase confirmOrderUseCase;
    private final FindAllOrdersUseCase findAllOrdersUseCase;
    private final FindOrderByIdUseCase findOrderByIdUseCase;

    @GetMapping
    public List<Order> listAll() {
        return findAllOrdersUseCase.execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        Order order = findOrderByIdUseCase.execute(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order created = createOrderUseCase.execute(order);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Order> cancel(@PathVariable Long id) {
        Order canceled = cancelOrderUseCase.execute(id);
        return ResponseEntity.ok(canceled);
    }

    @PostMapping("/{id}/confirm")
    public ResponseEntity<Order> confirm(@PathVariable Long id) {
        Order confirmed = confirmOrderUseCase.execute(id);
        return ResponseEntity.ok(confirmed);
    }
}
