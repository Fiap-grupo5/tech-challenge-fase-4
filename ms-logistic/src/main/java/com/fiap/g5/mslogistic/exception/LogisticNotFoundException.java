package com.fiap.g5.mslogistic.exception;

public class LogisticNotFoundException extends SystemBaseException {
    private static final long serialVersionUID = 1L;

    private final String code = "logistic-service.logisticNotFound";
    private final String message = "Logistic record not found";
    private final Integer httpStatus = 404;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public Integer getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
