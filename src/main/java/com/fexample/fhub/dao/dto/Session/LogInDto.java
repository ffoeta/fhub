package com.fexample.fhub.dao.dto.Session;

import com.fexample.fhub.dao.model.classes.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

public class LogInDto implements DtoEntity<User> {

    private String username;
    private String password;

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public LogInDto fromModel(User user) {

        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());

        return this;
    }

    @Override
    public User toModel() {

        User user = new User();

        user.setUsername(this.getUsername());
        user.setPassword(this.getPassword());

        return user;
    }
}
