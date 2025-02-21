package com.fiap.g5.mslogistic.logistic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.g5.mslogistic.logistic.domain.CreateLogistic;
import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.usecase.CreateLogisticUseCase;
import com.fiap.g5.mslogistic.logistic.usecase.FindAllLogisticsUseCase;
import com.fiap.g5.mslogistic.logistic.usecase.FindLogisticByIdUseCase;
import com.fiap.g5.mslogistic.logistic.usecase.UpdateLogisticDelivery;
import com.fiap.g5.mslogistic.logistic.usecase.UpdateStatusLogisticUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Slf4j
@CrossOrigin(origins = "*") //NOSONAR
@RequestMapping("/logistic")
@RestController
@AllArgsConstructor
public class LogisticController {
    private CreateLogisticUseCase createLogisticUseCase;
    private FindAllLogisticsUseCase findAllLogisticsUseCase;
    private FindLogisticByIdUseCase findLogisticByIdUseCase;
    private UpdateLogisticDelivery updateLogisticDelivery;
    private UpdateStatusLogisticUseCase updateStatusLogisticUseCase;
    
    @PostMapping("/")
    public Logistic create(@RequestBody(required = true) CreateLogistic createLogistic) {
        return createLogisticUseCase.create(createLogistic);
    }

    @GetMapping("/")
    public List<Logistic> findAll() {
        return findAllLogisticsUseCase.findAll();
    }

    @GetMapping("/{id}")
    public Logistic findById(@PathVariable("id") Long id) {
        return findLogisticByIdUseCase.findById(id);
    }

    @PostMapping("/{id}/delivery/{status}")
    public Logistic updateDelivery(@PathVariable("id") Long id, @PathVariable("delivery") String delivery) {
        return updateLogisticDelivery.updateDelivery(id, delivery);
    }

    @PostMapping("/{id}/status/{status}")
    public Logistic updateStatus(@PathVariable("id") Long id, @PathVariable("status") String status) {
        return updateStatusLogisticUseCase.updateStatus(id, status);
    }
}
