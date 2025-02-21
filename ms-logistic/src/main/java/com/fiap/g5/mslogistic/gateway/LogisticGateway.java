package com.fiap.g5.mslogistic.gateway;

import com.fiap.g5.mslogistic.domain.Logistic;

import java.util.List;
import java.util.Optional;

public interface LogisticGateway {

    List<Logistic> findAll();

    Optional<Logistic> findById(Long id);

    Logistic create(Logistic logistic);

    Logistic update(Long id, Logistic logistic);

    void delete(Long id);
}
