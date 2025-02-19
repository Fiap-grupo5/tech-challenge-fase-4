package com.fiap.g5.msproduct.exception;

public class DataRepositoryAccessException extends SystemBaseException {
    private static final long serialVersionUID = 1L;

    private final String code = "product-service.errorAccessingDataRepository";
    private final String message = "Error accessing data repository";
    private final Integer httpStatus = 500;

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
