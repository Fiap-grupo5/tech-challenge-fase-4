package com.fiap.g5.mslogistic.logistic.domain;

public enum OrderStatus {
    PENDING("PENDING"),
    SUCCESS("SUCCESS"),
    CANCELED("CANCELED"),;

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
