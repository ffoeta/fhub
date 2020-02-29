package com.fexample.fhub.web.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order/")
public class OrderController {

    @GetMapping
    public ResponseEntity<Map<Object, Object>> home(){
        Map<Object, Object> response = new HashMap<>();

        response.put("message", "Wassup you beautiful bastards");

        return ResponseEntity.ok(response);
    }
}