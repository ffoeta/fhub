package com.fexample.fhub.web;

import java.util.HashMap;
import java.util.Map;

import com.fexample.fhub.dao.dto.User.UserDto;
import com.fexample.fhub.dao.model.classes.User;
import com.fexample.fhub.facade.interfaces.service.UserService;
import com.fexample.fhub.facade.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/session")
public class SessionController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("login")
    public ResponseEntity<Map<Object, Object>> LogInUser(@RequestBody UserDto userDto){

        String username = userDto.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userDto.getPassword()));
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        String token = jwtTokenProvider.createToken(username, user.getRoles());

        Map<Object, Object> response = new HashMap<>();

        response.put("username", username);
        response.put("token", token);

        return ResponseEntity.ok()
                    .body(response);
    }

    @PostMapping("signup")
    public ResponseEntity<Map<Object, Object>> SignUpUser(@RequestBody UserDto userDto){

        User user = userService.saveUser(userDto.toModel());

        Map<Object, Object> response = new HashMap<>();

        response.put("count", 1);
        response.put("items", user);

        return ResponseEntity.ok()
                    .body(response);
    }
}