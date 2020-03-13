package com.fexample.fhub.facade.interfaces.service.User;

import java.util.List;
import java.util.UUID;

import com.fexample.fhub.dao.model.classes.User.User;

import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import org.springframework.data.domain.Pageable;

public interface UserService {

    //save User
    User saveUser(User User) throws EntityAlreadyExistsException;

    //update User
    User updateUser(User User) throws EntityNotExistsException;

    //disable User by Username
    User fakeDeleteUserById(UUID id) throws EntityNotExistsException;

    //delete User by Username
    void deleteUserById(UUID id) throws EntityNotExistsException;

    //find all
    List<User> findAllUsers(Pageable pageable);

    //find User by Username
    User findByUsername(String Username) throws EntityNotExistsException;

    //find User by email
    User findByEmail(String email) throws EntityNotExistsException;

    //find User by firstname
    List<User> findAllByFirstname(String firstname, Pageable pageable);

    //find User by lastname
    List<User> findAllByLastname(String lastname, Pageable pageable);
}