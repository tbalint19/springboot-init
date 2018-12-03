package com.aaa.controller;

import com.aaa.model.dto.DefaultHttpAuthError;
import com.aaa.model.exception.HTTP401;
import com.aaa.model.exception.HTTP403;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HTTP401.class)
    protected ResponseEntity<Object> handle401(HTTP401 ex) {
        return new ResponseEntity<>(new DefaultHttpAuthError(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(HTTP403.class)
    protected ResponseEntity<Object> handle403(HTTP403 ex) {
        return new ResponseEntity<>(new DefaultHttpAuthError(ex.getMessage()), HttpStatus.FORBIDDEN);
    }

}
