package com.fexample.fhub.web.Session;

import java.util.HashMap;
import java.util.Map;

import com.fexample.fhub.dao.dto.Session.LogInDto;
import com.fexample.fhub.dao.dto.Session.SignUpDto;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.interfaces.service.User.UserService;
import com.fexample.fhub.facade.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/session")
public class SessionController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("login")
    public ResponseEntity<Map<Object, Object>> LogInUser(@RequestBody LogInDto logInDto){

        String username = logInDto.getUsername();
        User user = userService.findByUsername(username);

        if (user == null) {

            throw new ControllerServiceCallException("User " + username);
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, logInDto.getPassword()));

        String token = jwtTokenProvider.createToken(username, user.getRoles());

        Map<Object, Object> response = new HashMap<>();

        response.put("username", username);
        response.put("token", token);

        return ResponseEntity.ok()
                    .body(response);
    }

    @PostMapping("signup")
    public ResponseEntity<Map<Object, Object>> SignUpUser(@RequestBody SignUpDto signUpDto){

        User user = userService.saveUser(signUpDto.toModel());

        if (user == null) {

            throw new ControllerServiceCallException("User " + signUpDto.getUsername());
        }

        Map<Object, Object> response = new HashMap<>();

        response.put("count", 1);
        response.put("items", user);

        return ResponseEntity.ok()
                    .body(response);
    }

//    @PostMapping("gen")
//    public ResponseEntity<Map<Object, Object>> gen(@RequestBody UserDto userDto){
//
//        Map<Object, Object> response = new HashMap<>();
//
//        response.put(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
//
//        return ResponseEntity.ok()
//                .body(response);
//    }
}