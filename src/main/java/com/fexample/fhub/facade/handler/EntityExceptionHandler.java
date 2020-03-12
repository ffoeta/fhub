package com.fexample.fhub.facade.handler;

import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(value = ControllerServiceCallException.class)
    public ResponseEntity<Map<Object, Object>> exception(ControllerServiceCallException exception) {

        Map<Object, Object> response = new HashMap<>();
        response.put("message", exception.getCause().getMessage());

        return new ResponseEntity<Map<Object, Object>>(response, HttpStatus.CONFLICT);
    }
}
