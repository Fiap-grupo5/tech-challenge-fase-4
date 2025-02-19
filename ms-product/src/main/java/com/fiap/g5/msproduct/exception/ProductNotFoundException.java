package com.fiap.g5.msproduct.exception;

public class ProductNotFoundException extends SystemBaseException {
    private static final long serialVersionUID = 1L;
    
    private final String code = "product-service.productNotFound";
    private final String message = "Product não foi encontrado";
    private final Integer httpStatus = 404;

    @Override
    public String getCode() { return code; }

    @Override
    public Integer getHttpStatus() { return httpStatus; }

    @Override
    public String getMessage() { return message; }
}
