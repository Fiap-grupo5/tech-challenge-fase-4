package com.fiap.g5.mslogistic.config.exception;

import com.fiap.g5.mslogistic.exception.SystemBaseException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(SystemBaseException.class)
    @ResponseBody
    public ResponseEntity<ExceptionJson> handleSystemBaseException(
            SystemBaseException e,
            HttpServletResponse response
    ) {
        final ExceptionJson exceptionJson = new ExceptionJson(e);
        return new ResponseEntity<>(exceptionJson, new HttpHeaders(), HttpStatus.valueOf(e.getHttpStatus()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ExceptionJson genericError(Throwable e) {
        log.error(e.getMessage(), e);
        return new ExceptionJson(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()
        );
    }
}
