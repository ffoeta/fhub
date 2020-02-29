package com.fexample.fhub.web.rest;

import java.util.HashMap;
import java.util.Map;

import com.fexample.fhub.dao.dto.Session.SessionUp;
import com.fexample.fhub.dao.dto.User.UserExtended;
import com.fexample.fhub.dao.model.User;
import com.fexample.fhub.facades.exception.UserServiceException;
import com.fexample.fhub.facades.interfaces.service.UserService;
import com.fexample.fhub.facades.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/session/")
public class SessionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody UserExtended extended) {
        String username = extended.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, extended.getPassword()));
        User user = userService.findByUsername(username);

        Map<Object, Object> response = new HashMap<>();

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        String token = jwtTokenProvider.createToken(username, user.getRoles());

        response.put("username", username);
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    @PostMapping("signup")
    public ResponseEntity<Map<Object, Object>> sign(@RequestBody UserExtended extended) {

        Map<Object, Object> response = new HashMap<>();

        User user = extended.toUser();

        try {
            userService.save(user);
        }catch(UserServiceException e){
            return ResponseEntity.badRequest().build();
        }
        
        return login(extended);
    }

    @PostMapping("gen")
    public ResponseEntity<Map<Object, Object>> gen(@RequestBody UserExtended extended) {

        Map<Object, Object> response = new HashMap<>();

        String pass = passwordEncoder.encode(extended.getPassword());

        response.put("username", extended.getUsername());
        response.put("password", pass);
        
        return ResponseEntity.ok(response);
        // return ResponseEntity.badRequest().build();
    }
}