package com.fexample.fhub.facade.interfaces.service;

import java.util.List;

import com.fexample.fhub.dao.model.classes.User.User;

import org.springframework.data.domain.Pageable;

public interface UserService {

    //save user
    User saveUser(User user);

    //update user
    User updateUser(User user);

    //disable user by username
    User fakeDeleteUserByUsername(String username);

    //delete user by username
    void deleteUserByUsername(String username);

    //find all
    List<User> findAllUsers(Pageable pageable);

    //find user by username
    User findByUsername(String username);

    //find user by email
    User findByEmail(String email);

    //find user by firstname
    List<User> findAllByFirstname(String firstname, Pageable pageable);

    //find user by lastname
    List<User> findAllByLastname(String lastname, Pageable pageable);

}