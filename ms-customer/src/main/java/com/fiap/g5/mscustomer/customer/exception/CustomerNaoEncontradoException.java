package com.fiap.g5.mscustomer.customer.exception;

import lombok.Getter;

@Getter
public class CustomerNaoEncontradoException extends SystemBaseException {
	private static final long serialVersionUID = 925166288542143659L;
	
	private final String code = "customer-service.customerNaoEncontrado";//NOSONAR
	private final String message = "Customer não foi encontrado";//NOSONAR
	private final Integer httpStatus = 404;//NOSONAR
}
