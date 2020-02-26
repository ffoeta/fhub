package com.fexample.fhub.service.implementation;

import com.fexample.fhub.dto.User.UserExtended;
import com.fexample.fhub.model.Role;
import com.fexample.fhub.model.Status;
import com.fexample.fhub.model.User;
import com.fexample.fhub.repository.RoleRepository;
import com.fexample.fhub.repository.UserRepository;
import com.fexample.fhub.service.interface_.UserService;
// import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
// @Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserServiceImpl(final UserRepository userRepository, final RoleRepository roleRepository, final BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(final User user, final String ROLE) {
        final Role role = roleRepository.findByName(ROLE);
        final List<Role> userRoles = new ArrayList<>();
        userRoles.add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setId(UUID.randomUUID());
        final Date date = new Date();
        user.setCreated(date);
        user.setUpdated(date);
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(final User user) {
        user.setUpdated(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        final List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User findByUsername(final String username) {
        final User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findById(final UUID id) {
        final User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public void deleteById(final UUID id) {
        userRepository.deleteById(id);
    }

    public User getUser(final UserExtended extended) {
        User user = null;
        if (extended.getId() != null) {
            user = findById(extended.getId());
        } else if (extended.getUsername() != null) {
            user = findByUsername(extended.getUsername());
        }
        return user;
    }

    public User setIUser(final User user, final UserExtended extended) {
        if (user == null) {
            return null;
        }
        final String username = extended.getUsername();
        final String password = extended.getPassword();
        if (username != null) {
            user.setUsername(username);
        }
        if (password != null) {
            user.setPassword(password);
        }
        return user;
    }
}