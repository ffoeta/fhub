package com.fexample.fhub.dao.dto.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fexample.fhub.dao.model.classes.User;
import com.fexample.fhub.facades.interfaces.dto.DtoEntity;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserShort implements DtoEntity<User>{
    private String username;
    private String firstname;


    public User toModel(){

        User user = new User();

        user.setUsername(username);
        user.setFirstname(firstname);

        return user;
    }

    public static UserShort fromModel(User user) {
        UserShort short_ = new UserShort();

        short_.setUsername(user.getUsername());
        short_.setFirstname(user.getFirstname());

        return short_;
    }
}