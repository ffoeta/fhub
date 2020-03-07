package com.fexample.fhub.dao.service;

import com.fexample.fhub.dao.model.classes.Role;
import com.fexample.fhub.dao.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.model.classes.User;
import com.fexample.fhub.dao.repository.UserRepository;
import com.fexample.fhub.facade.interfaces.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        
        if (this.userRepository.findByUsername(user.getUsername()) != null) return null;

        user.setId(UUID.randomUUID());
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        user.setCreated(new Date());
        
        user.setUpdated(new Date());

        user.setStatus(Status.ACTIVE);

        if (user.getRoles() == null) {
            List<Role> roles = new ArrayList<>();
            roles.add(this.roleRepository.findByName("ROLE_USER"));
            user.setRoles(roles);
        }

        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        
        if (this.userRepository.findByUsername(user.getUsername()) == null) return null;
        
        user.setUpdated(new Date());
        
        return this.userRepository.save(user);
    }

    @Override
    public User fakeDeleteUserByUsername(String username) {
        
        User user = this.userRepository.findByUsername(username);
        
        if (user == null) return null;
        
        user.setStatus(Status.DELETED);
        
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUserByUsername(String username) {
        User user = this.userRepository.findByUsername(username);

        if (user == null) return;

        this.userRepository.delete(user);
    }

    @Override
    public List<User> findAllUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable).getContent();
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
    public List<User> findAllByFirstname(String firstname, Pageable pageable) {
        return this.userRepository.findAllByFirstname(firstname, pageable).getContent();
    }

    @Override
    public List<User> findAllByLastname(String lastname, Pageable pageable) {
        return this.userRepository.findAllByLastname(lastname, pageable).getContent();
    }
 



}