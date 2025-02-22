package com.fiap.g5.mslogistic.logistic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class LogisticOrder {
    Logistic logistic;
    Delivery delivery;
}
