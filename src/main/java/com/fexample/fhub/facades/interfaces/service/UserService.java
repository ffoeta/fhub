package com.fexample.fhub.facades.interfaces.service;

import java.util.List;
import java.util.UUID;

import com.fexample.fhub.dao.model.User;
import com.fexample.fhub.facades.exception.UserServiceException;



public interface UserService {

    //saves user to db
    User save(User user);

    //delete user
    User delete(User user);

    //finds by id
    User findById(UUID id);

    //finds by username
    User findByUsername(String name);

    //finds by email
    User findByEmail(String email);

    //selects user
    User find(User user);

    //selects all users
    List<User> findAll();

}