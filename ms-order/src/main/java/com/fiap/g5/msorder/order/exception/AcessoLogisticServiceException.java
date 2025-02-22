package com.fiap.g5.msorder.order.exception;

import lombok.Getter;

@Getter
public class AcessoLogisticServiceException extends SystemBaseException {
	private static final long serialVersionUID = 5897188869189066850L;
	
	private final String code = "logistic-service.erroAcessoLogisticService";//NOSONAR
	private final String message = "Erro ao acessar o serviço de logistica";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}
