package com.fexample.fhub.facades.interfaces.service;

import com.fexample.fhub.dao.model.classes.User;

public interface UserService extends BaseEntityService<User> {

    //finds by email
    User findByEmail(String email);

    //finds by email
    User findByFirstname(String firstname);

    //finds by email
    User findByLastname(String lastname);

}