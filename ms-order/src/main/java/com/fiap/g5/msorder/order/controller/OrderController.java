package com.fiap.g5.msorder.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.g5.msorder.order.domain.CreateLogistic;
import com.fiap.g5.msorder.order.domain.Order;
import com.fiap.g5.msorder.order.gateway.LogisticGateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/order")
@RestController
@AllArgsConstructor
public class OrderController {
    @Autowired
    private LogisticGateway logisticGateway;

    @PostMapping("/")
    public Order createOrder() {
        var order = new Order(
        1L,
        1L,
        "PENDING",
        "01310-100",
        123,
        100.0
        );
        logisticGateway.create(new CreateLogistic(order.getPostcode(), order.getNumber(), order.getId()));
        return order;
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") Long id) {
        return new Order(
            1L,
            1L,
            "PENDING",
            "01310-100",
            123,
            100.0
            );
    }

    @PostMapping("/{id}/status/{status}")
    public Order updateStatus(@PathVariable("id") Long id, @PathVariable("status") String status) {
        var order = new Order(
        1L,
        1L,
        status,
        "01310-100",
        123,
        100.0
        );
        return order;
    }
}
