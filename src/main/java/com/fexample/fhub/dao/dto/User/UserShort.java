package com.fexample.fhub.dao.dto.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fexample.fhub.dao.model.User;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserShort {
    private String username;
    private String firstname;


    public User toUser(){

        User user = new User();

        user.setUsername(username);
        user.setFirstname(firstname);

        return user;
    }

    public static UserShort fromUser(User user) {
        UserShort short_ = new UserShort();

        short_.setUsername(user.getUsername());
        short_.setFirstname(user.getFirstname());

        return short_;
    }
}