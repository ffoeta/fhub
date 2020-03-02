package com.fexample.fhub.web.rest;

import java.util.ArrayList;
import java.util.List;

import com.fexample.fhub.dao.dto.User.UserExtended;
import com.fexample.fhub.dao.model.User;
import com.fexample.fhub.facades.interfaces.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public ResponseEntity getAll(){

        List<UserExtended> usersExtendeds = new ArrayList<>();

        List<User> users = userService.findAll();

        users.forEach(user -> {
            usersExtendeds.add(UserExtended.fromUser(user));
        });

        return new ResponseEntity<>(usersExtendeds, HttpStatus.OK);
    }
}