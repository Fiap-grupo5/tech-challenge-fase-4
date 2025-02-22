package com.fiap.g5.mslogistic.logistic.config.exception;

import com.fiap.g5.mslogistic.logistic.exception.SystemBaseException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionJson {
	private final String code;
	private final String message;
	
	public ExceptionJson(final SystemBaseException baseException) {
		this.code = baseException.getCode();
		this.message = baseException.getMessage();
	}

}
