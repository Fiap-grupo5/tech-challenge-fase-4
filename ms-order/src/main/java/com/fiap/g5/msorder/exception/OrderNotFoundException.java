package com.fiap.g5.msorder.exception;

public class OrderNotFoundException extends SystemBaseException {
    private static final long serialVersionUID = 1L;

    private final String code = "order-service.orderNotFound";
    private final String message = "Order não foi encontrado";
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
