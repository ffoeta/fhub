package com.fexample.fhub.service.interface_;

import com.fexample.fhub.dto.User.UserExtended;
import com.fexample.fhub.exception.UserServiceException;
import com.fexample.fhub.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    //saves user to db
    User save(UserExtended extended) throws UserServiceException;

    //delete user
    User delete(UserExtended extended) throws UserServiceException;

    //finds by id
    User findById(UUID id);

    //finds by username
    User findByUsername(String name);

    //finds by email
    User findByEmail(String email);

    //selects user
    User find(UserExtended extended);

    //selects all users
    List<User> findAll();

}