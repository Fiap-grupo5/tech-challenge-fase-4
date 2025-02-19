package com.fiap.g5.msproduct.config.exception;

import com.fiap.g5.msproduct.exception.SystemBaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionJson {
    private final String code;
    private final String message;

    public ExceptionJson(SystemBaseException baseException) {
        this.code = baseException.getCode();
        this.message = baseException.getMessage();
    }
}
