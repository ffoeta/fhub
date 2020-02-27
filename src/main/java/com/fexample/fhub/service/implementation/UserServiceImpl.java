package com.fexample.fhub.service.implementation;

import com.fexample.fhub.dto.User.UserExtended;
import com.fexample.fhub.exception.UserServiceException;
import com.fexample.fhub.model.Status;
import com.fexample.fhub.model.User;
import com.fexample.fhub.repository.RoleRepository;
import com.fexample.fhub.repository.UserRepository;
import com.fexample.fhub.service.interface_.UserService;
// import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
// @Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserServiceImpl(final UserRepository userRepository, 
    final RoleRepository roleRepository, final BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(UserExtended extended) throws UserServiceException {
        
        if  ( (extended == null) || ( (extended.getUsername() == null) 
                                        && (extended.getId() == null) 
                                        && (extended.getEmail() == null) ) ) {
            throw new UserServiceException("User provided is null or bad credentials");
        }

        User user = this.find(extended);

        if (user == null) {
            user = extended.toUser();
            user.setId(UUID.randomUUID());
            user.setCreated(new Date());
        } else {
            if (extended.getId() != null ) {
                user.setId(extended.getId());
            };
            if (extended.getUsername() != null) {
                user.setUsername(extended.getUsername());
            };
            if (extended.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(extended.getPassword()));             
            };
            if (extended.getEmail() != null) {
                user.setEmail(extended.getEmail());
            };
            if (extended.getFirstname() != null) {
                user.setFirstname(extended.getFirstname());
            };
            if (extended.getLastname() != null) {
                user.setLastname(extended.getLastname());
            };
            if (extended.getStatus() != null) {
                user.setStatus(extended.getStatus());
            }
            if (extended.getRoles() != null) {
                user.setRoles(extended.getRoles());
            }
        }

        user.setUpdated(new Date());
        return this.userRepository.save(user);
    }

    @Override
    public User delete(UserExtended extended) throws UserServiceException {
        if ( extended == null ) {
            throw new UserServiceException("User provided is null");
        }

        UserExtended extended2 = extended;
        extended2.setStatus(Status.DELETED);
        this.save(extended2);
        return this.find(extended2);
    }

    @Override
    public User findById(UUID id) {

        return this.userRepository.findByid(id);
    }

    @Override
    public User findByUsername(String username) {

        return this.userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {

        return this.userRepository.findByEmail(email);
    }

    @Override
    public User find(UserExtended extended) {

        User user = this.findByUsername(extended.getUsername());

        if (user == null) {
            user = this.findById(extended.getId());
        }
        if (user == null) {
            user = this.findByEmail(extended.getEmail());
        }
        return null;
    }

    @Override
    public List<User> findAll() {

        return this.userRepository.findAll();
    }
}