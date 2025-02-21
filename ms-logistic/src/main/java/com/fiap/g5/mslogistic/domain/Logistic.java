package com.fiap.g5.mslogistic.domain;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Logistic {

    private Long id;
    private Long orderId;
    private String delivery;          // ex: nome da transportadora ou método
    private LogisticStatus status;
    private LocalDateTime estimatedDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
