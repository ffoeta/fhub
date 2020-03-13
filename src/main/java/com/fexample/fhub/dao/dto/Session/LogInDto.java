package com.fexample.fhub.dao.dto.Session;

import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;

public class LogInDto implements DtoRequestEntity<User> {

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
    public User toModel() {

        User user = new User();

        user.setUsername(this.getUsername());
        user.setPassword(this.getPassword());

        return user;
    }
}
