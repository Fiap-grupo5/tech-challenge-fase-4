package com.fiap.g5.mslogistic.logistic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.g5.mslogistic.logistic.domain.Route;
import com.fiap.g5.mslogistic.logistic.usecase.FindAllRoutesUseCase;
import com.fiap.g5.mslogistic.logistic.usecase.FindRouteByIdUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Slf4j
@CrossOrigin(origins = "*") //NOSONAR
@RequestMapping("/route")
@RestController
@AllArgsConstructor
public class RouteController {
    private FindAllRoutesUseCase findAllRoutesUseCase;
    private FindRouteByIdUseCase findRouteByIdUseCase;

    @GetMapping("/")    
    public List<Route> findAll() {
        return findAllRoutesUseCase.findAll();
    }

    @GetMapping("/{id}")    
    public Route findById(@PathVariable("id") Long id) {
        return findRouteByIdUseCase.findById(id);
    }
}
