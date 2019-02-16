package com.aaa.controller;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //@ExceptionHandler(HTTP401.class)
    //protected ResponseEntity<Object> handle401(HTTP401 ex) {
    //    return new ResponseEntity<>(new DefaultHttpAuthError(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    //}

}
