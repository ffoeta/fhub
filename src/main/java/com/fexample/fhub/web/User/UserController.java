package com.fexample.fhub.web.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fexample.fhub.dao.model.classes.User;
import com.fexample.fhub.facade.exception.EntityNotFoundException;
import com.fexample.fhub.facade.interfaces.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping("all")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Map<Object, Object>> FindAllUsers(@RequestParam(value= "page", defaultValue = "0") int page,
                                                            @RequestParam(value= "size", defaultValue = "10") int size,
                                                            @RequestParam(value= "sort", defaultValue = "username") String sort){
        List<User> users = service.findAllUsers(PageRequest.of(page, size, Sort.by(sort)));

        Map<Object, Object> response = new HashMap<>();

        response.put("count", users.size());
        response.put("items", users);

        return ResponseEntity.ok()
                    .body(response);
    }

    @GetMapping("username")
    public ResponseEntity<Map<Object, Object>> FindUserByUserName(@RequestParam String username){

        User user = service.findByUsername(username);

        if (user == null) {

            throw new EntityNotFoundException("User " + username);
        }

        Map<Object, Object> response = new HashMap<>();

        response.put("count", 1);
        response.put("items", user);

        return ResponseEntity.ok()
                    .body(response);
    }

    @GetMapping("email")
    public ResponseEntity<Map<Object, Object>> FindUserByEmail(@RequestParam String email){

        User user = service.findByEmail(email);

        if (user == null) {

            throw new EntityNotFoundException("Email " + email);
        }

        Map<Object, Object> response = new HashMap<>();

        response.put("count", 1);
        response.put("items", user);

        return ResponseEntity.ok()
                    .body(response);
    }

    @GetMapping("firstname")
    public ResponseEntity<Map<Object, Object>> FindUserByFirstName( @RequestParam(value= "firstname") String firstname,
                                                                    @RequestParam(value= "page", defaultValue = "0") int page,
                                                                    @RequestParam(value= "size", defaultValue = "10") int size,
                                                                    @RequestParam(value= "sort", defaultValue = "username") String sort){

        List<User> users = service.findAllByFirstname(firstname, PageRequest.of(page, size, Sort.by(sort)));

        Map<Object, Object> response = new HashMap<>();

        response.put("count", users.size());
        response.put("items", users);

        return ResponseEntity.ok()
                    .body(response);
    }

    @GetMapping("lastname")
    public ResponseEntity<Map<Object, Object>> FindUserByLastName(  @RequestParam(value= "lastname") String lastname,
                                                                    @RequestParam(value= "page", defaultValue = "0") int page,
                                                                    @RequestParam(value= "size", defaultValue = "10") int size,
                                                                    @RequestParam(value= "sort", defaultValue = "username") String sort){
        List<User> users = service.findAllByLastname(lastname, PageRequest.of(page, size, Sort.by(sort)));

        Map<Object, Object> response = new HashMap<>();

        response.put("count", users.size());
        response.put("items", users);

        return ResponseEntity.ok()
                    .body(response);
    }
}