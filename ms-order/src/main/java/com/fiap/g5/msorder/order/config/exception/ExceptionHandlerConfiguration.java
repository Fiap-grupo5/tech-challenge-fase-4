package com.fiap.g5.msorder.order.config.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fiap.g5.msorder.order.exception.SystemBaseException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerConfiguration {

    @ExceptionHandler({ SystemBaseException.class })
    @ResponseBody
    public ResponseEntity<ExceptionJson> handleSystemBaseException(SystemBaseException e, HttpServletResponse response) {
        ExceptionJson exceptionJson = new ExceptionJson(e);
        return new ResponseEntity<>(exceptionJson, new HttpHeaders(), e.getHttpStatus());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ExceptionJson genericError(Throwable e) {
        log.error(e.getMessage(), e);
        return new ExceptionJson(HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
}