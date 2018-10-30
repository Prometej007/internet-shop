package com.web.authservice.controller;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ExceptionsController.class);

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(AuthenticationException.class)
    private ResponseEntity authenticationException(AuthenticationException exceptions) {
        logger.error(exceptions);
        exceptions.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptions);
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity runtimeException(RuntimeException exceptions) {
        logger.error(exceptions);
        exceptions.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptions);
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(UsernameNotFoundException.class)
    private ResponseEntity usernameNotFoundException(UsernameNotFoundException exceptions) {
        exceptions.printStackTrace();
        logger.error(exceptions);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptions);
    }

}
