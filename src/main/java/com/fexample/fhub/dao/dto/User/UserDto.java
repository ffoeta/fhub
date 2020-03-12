package com.fexample.fhub.dao.dto.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fexample.fhub.dao.model.classes.User.Role;
import com.fexample.fhub.dao.model.classes.User.User;

import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements DtoEntity<User>{

    private UUID id;
    private String username;
    private String email;
    private Status status;
    private String firstname;
    private String lastname;
    private List<Role> roles;
    
    public User toModel() {
        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setStatus(status);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRoles(roles);

        return user;
    }

    @Override
    public UserDto fromModel(User user) {

        this.setUsername(user.getUsername());
        this.setEmail(user.getEmail());
        this.setStatus(user.getStatus());
        this.setFirstname(user.getFirstname());
        this.setLastname(user.getLastname());
        this.setRoles(user.getRoles());

        return this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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