package com.g5.customerservice.application.dto;

import java.util.UUID;

public record CustomerDTO(UUID id, String name, String email, String phone, String address) {}
