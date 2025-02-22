package com.fiap.g5.mslogistic.logistic.domain;

import java.util.Map;
import java.util.Set;

public enum LogisticStatus {
    PENDING("PENDING"),
    DELIVERED("DELIVERED"),
    CANCELED("CANCELED"),
    IN_TRANSIT("IN_TRANSIT");

    private String status;

    LogisticStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static LogisticStatus fromString(String status) {
        for (LogisticStatus logisticStatus : values()) {
            if (logisticStatus.getStatus().equalsIgnoreCase(status)) {
                return logisticStatus;
            }
        }
        return null; // Retorna null se a string não corresponder a nenhum status
    }

    private static final Map<LogisticStatus, Set<LogisticStatus>> TRANSITIONS = Map.of(
        PENDING, Set.of(IN_TRANSIT, CANCELED), // PENDING -> Pode ir para IN_TRANSIT ou CANCELED
        IN_TRANSIT, Set.of(DELIVERED, CANCELED), // IN_TRANSIT -> Pode ir para DELIVERED ou CANCELED
        DELIVERED, Set.of(), // DELIVERED -> Não pode mudar mais
        CANCELED, Set.of() // CANCELED -> Não pode mudar mais
    );

    public boolean canTransitionTo(LogisticStatus newStatus) {
        return TRANSITIONS.getOrDefault(this, Set.of()).contains(newStatus);
    }
}
