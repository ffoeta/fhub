package com.fexample.fhub.dto.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fexample.fhub.model.Status;
import com.fexample.fhub.model.User;
import com.fexample.fhub.model.Role;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserExtended {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private Status status;
    private String firstname;
    private String lastname;
    private List<Role> roles;

    public User toUser() {
        User user = new User();

        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setStatus(status);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRoles(roles);

        return user;
    }

    public static UserExtended fromUser(User user) {
        UserExtended extended = new UserExtended();

        extended.setId(user.getId());
        extended.setUsername(user.getUsername());
        extended.setPassword(user.getPassword());
        extended.setEmail(user.getEmail());
        extended.setStatus(user.getStatus());
        extended.setFirstname(user.getFirstname());
        extended.setLastname(user.getLastname());
        extended.setRoles(user.getRoles());

        return extended;
    }
}