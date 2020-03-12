package com.fexample.fhub.facade.handler;

import com.fexample.fhub.FhubApplication;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FhubApplication.class);

    @ExceptionHandler(value = ControllerServiceCallException.class)
    public ResponseEntity<Map<Object, Object>> exception(ControllerServiceCallException exception) {

        LOGGER.warn("Handled exception " + exception.toString()
                + "Caused " + exception.getCause().getMessage());

        Map<Object, Object> response = new HashMap<>();
        response.put("message", exception.getMessage() + " already exists");

        return new ResponseEntity<Map<Object, Object>>(response, HttpStatus.CONFLICT);
    }
}
