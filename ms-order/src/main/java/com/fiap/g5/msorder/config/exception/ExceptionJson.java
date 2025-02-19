package com.fiap.g5.msorder.config.exception;

import com.fiap.g5.msorder.exception.SystemBaseException;
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
