package com.fiap.g5.msorder.order.domain;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Logistic {
    private Long id;
    private Long orderId;
    private String postcode;
    private Integer number;
    private String status;
    private String delivery;
    private LocalDateTime estimatedDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime createdAt;
}
