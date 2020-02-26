package com.fexample.fhub.service.interface_;

import com.fexample.fhub.dto.User.UserExtended;
import com.fexample.fhub.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User register(User user, String ROLE);

    User update(User user);

    User findByUsername(String username);

    User findById(UUID id);

    List<User> getAll();

    void deleteById(UUID id);

    User getUser(UserExtended extended);

    User setIUser(User user, UserExtended extended);
}