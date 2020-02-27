package com.fexample.fhub.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fexample.fhub.service.implementation.UserServiceImpl;
import com.fexample.fhub.dto.User.UserExtended;
import com.fexample.fhub.exception.UserServiceException;

@RestController
@RequestMapping(value = "/")
public class HomeRestController {

    private final UserServiceImpl userServcice;

    @Autowired
    public HomeRestController(UserServiceImpl userService) {
        this.userServcice = userService;
    }

    @GetMapping
    public ResponseEntity<Map<Object, Object>> home(){
        Map<Object, Object> response = new HashMap<>();

        UserExtended user = null;

        try {
            userServcice.save(user);
        } catch (UserServiceException e) {
            response.put("error",e.getMessage());
            return ResponseEntity.ok(response);
        }
        


        response.put("message", "Wassup you beautiful bastards");

        return ResponseEntity.ok(response);
    }
}