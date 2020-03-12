package com.fexample.fhub.facade.interfaces.service;

import java.util.List;

import com.fexample.fhub.dao.model.classes.User.User;

import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import org.springframework.data.domain.Pageable;

public interface UserService {

    //save user
    User saveUser(User user) throws EntityAlreadyExistsException;

    //update user
    User updateUser(User user) throws EntityNotExistsException;

    //disable user by username
    User fakeDeleteUserByUsername(String username) throws EntityNotExistsException;

    //delete user by username
    void deleteUserByUsername(String username) throws EntityNotExistsException;

    //find all
    List<User> findAllUsers(Pageable pageable);

    //find user by username
    User findByUsername(String username) throws EntityNotExistsException;

    //find user by email
    User findByEmail(String email) throws EntityNotExistsException;

    //find user by firstname
    List<User> findAllByFirstname(String firstname, Pageable pageable);

    //find user by lastname
    List<User> findAllByLastname(String lastname, Pageable pageable);
}