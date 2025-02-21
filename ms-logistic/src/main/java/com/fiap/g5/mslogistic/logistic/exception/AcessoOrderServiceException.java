package com.fiap.g5.mslogistic.logistic.exception;

import lombok.Getter;

@Getter
public class AcessoOrderServiceException extends SystemBaseException {
	private static final long serialVersionUID = 5897188869189066850L;
	
	private final String code = "order-service.erroAcessoOrderService";//NOSONAR
	private final String message = "Erro ao acessar o serviço de order";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}
