package com.fiap.g5.mslogistic.exception;

public abstract class SystemBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public abstract String getCode();
    public abstract Integer getHttpStatus();
    @Override
    public abstract String getMessage();
}
