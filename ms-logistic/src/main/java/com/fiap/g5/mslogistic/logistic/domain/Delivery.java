package com.fiap.g5.mslogistic.logistic.domain;

public enum Delivery {
    ENTREGADOR_1("Entregador 1"),
    ENTREGADOR_2("Entregador 2"),
    ENTREGADOR_3("Entregador 3"),
    ENTREGADOR_4("Entregador 4"),
    ENTREGADOR_5("Entregador 5");

    private final String value;

    Delivery(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Delivery fromString(String value) {
        for (Delivery deliveries : values()) {
            if (deliveries.getValue().equalsIgnoreCase(value)) {
                return deliveries;
            }
        }
        return null; // Retorna null se a string não corresponder a nenhum delevery
    }
}
