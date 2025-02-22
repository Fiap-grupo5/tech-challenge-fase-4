package com.fiap.g5.mslogistic.logistic.exception;

import lombok.Getter;

@Getter
public class AcessoRepositorioDadosException extends SystemBaseException {
	private static final long serialVersionUID = -4718879604367765891L;
	
	private final String code = "logistic-service.erroAcessarRepositorioDados";//NOSONAR
	private final String message = "Erro ao acessar o repositorio de dados";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}
