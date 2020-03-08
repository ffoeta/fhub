package com.fexample.fhub.facade.handler;

import com.fexample.fhub.facade.exception.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EntityExceptionHandler {
    @ExceptionHandler(value = EntityAlreadyExistsException.class)
    public ResponseEntity<Map<Object, Object>> exception(EntityAlreadyExistsException exception) {

        Map<Object, Object> response = new HashMap<>();
        response.put("message", exception.getMessage() + " already exists");

        return new ResponseEntity<Map<Object, Object>>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Map<Object, Object>> exception(EntityNotFoundException exception) {

        Map<Object, Object> response = new HashMap<>();
        response.put("message", exception.getMessage() + " not found");

        return new ResponseEntity<Map<Object, Object>>(response, HttpStatus.NOT_FOUND);
    }
}
