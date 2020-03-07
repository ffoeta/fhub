package com.fexample.fhub.dao.dto.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fexample.fhub.dao.model.classes.Role;
import com.fexample.fhub.dao.model.classes.User;

import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements DtoEntity<User>{

    private String username;
    private String password;
    private String email;
    private Status status;
    private String firstname;
    private String lastname;
    private List<Role> roles;
    
    public User toModel() {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setStatus(status);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRoles(roles);

        return user;
    }

    public static UserDto fromModel(User user) {
        UserDto userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setStatus(user.getStatus());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setRoles(user.getRoles());

        return userDto;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}