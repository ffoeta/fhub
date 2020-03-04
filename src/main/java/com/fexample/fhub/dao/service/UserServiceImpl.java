package com.fexample.fhub.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.model.classes.User;
import com.fexample.fhub.dao.repository.UserRepository;
import com.fexample.fhub.facades.exception.UserServiceException;
import com.fexample.fhub.facades.interfaces.service.UserService;

@Service
// @Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User save(User user){

        try{
            if ((user == null) || ((user.getUsername() == null)
                && (user.getId() == null)
                && (user.getEmail() == null))) {
                throw new UserServiceException("User provided is null or bad credentials");
            }
        }catch(Exception e){
            System.out.println(e);
        }

        User user2 = this.find(user);

        if (user2 == null) {
            user.setId(UUID.randomUUID());
            user.setCreated(new Date());
            user2 = user;
        } else {
            if (user.getId() != null) {
                user2.setId(user.getId());
            }
            ;
            if (user.getUsername() != null) {
                user2.setUsername(user.getUsername());
            }
            ;
            if (user.getPassword() != null) {
                user2.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            ;
            if (user.getEmail() != null) {
                user2.setEmail(user.getEmail());
            }
            ;
            if (user.getFirstname() != null) {
                user2.setFirstname(user.getFirstname());
            }
            ;
            if (user.getLastname() != null) {
                user2.setLastname(user.getLastname());
            }
            ;
            if (user.getStatus() != null) {
                user2.setStatus(user.getStatus());
            }
            if (user.getRoles() != null) {
                user2.setRoles(user.getRoles());
            }
        }

        user2.setUpdated(new Date());
        return this.userRepository.save(user2);
    }

    @Override
    public User delete(User user){
        try {
            if (user == null) {
                throw new UserServiceException("User provided is null");
            }
        }catch(Exception e){
            System.out.println(e);
        }

        User user2 = this.find(user);
        user2.setStatus(Status.DELETED);
        this.save(user2);
        return this.find(user2);
    }

    @Override
    public User findById(UUID id) {
        return this.userRepository.findByid(id);
    }

    @Override
    public User findByName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User find(User user) {
        User user2 = this.findByName(user.getUsername());

        if (user2 == null) {
            user2 = this.findById(user.getId());
        }
        if (user2 == null) {
            user2 = this.findByEmail(user.getEmail());
        }
        return user2;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findByFirstname(String firstname) {
        return this.userRepository.findByFirstname(firstname);
    }

    @Override
    public User findByLastname(String lastname) {
        return this.findByLastname(lastname);
    }
}