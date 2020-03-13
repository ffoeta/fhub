package com.fexample.fhub.dao.service.User;

import com.fexample.fhub.dao.model.classes.User.Role;
import com.fexample.fhub.dao.repository.User.RoleRepository;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.dao.repository.User.UserRepository;
import com.fexample.fhub.facade.interfaces.service.User.UserService;

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
        
        if (this.userRepository.findByUsername(user.getUsername()) != null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("User " + user.getUsername() + " already exists."));


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

        User user2 = this.userRepository.findByUsername(user.getUsername());

        if (user2 == null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("User " + user.getUsername() + " does not exist."));

        user.setId(user2.getId());
        user.setStatus(user2.getStatus());
        user.setUpdated(new Date());
        user.setCreated(user2.getCreated());
        
        return this.userRepository.save(user);
    }

    @Override
    public User fakeDeleteUserById(UUID id) {

        Optional<User> user = this.userRepository.findById(id);

        user.orElseThrow(() ->
            new ControllerServiceCallException(
                    new EntityAlreadyExistsException("User " + id + " does not exist.")));
        
        user.get().setStatus(Status.DELETED);
        
        return this.userRepository.save(user.get());
    }

    @Override
    public void deleteUserById(UUID id) {

        Optional<User> user = this.userRepository.findById(id);

        user.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("User " + id + " does not exist.")));

        this.userRepository.delete(user.get());
    }

    @Override
    public List<User> findAllUsers(Pageable pageable) {

        return this.userRepository.findAll(pageable).getContent();
    }

    @Override
    public User findByUsername(String username) {

        User user = this.userRepository.findByUsername(username);

        if (user == null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("User " + username + " does not exist."));

        return user;
    }

    @Override
    public User findByEmail(String email) {

        User user = this.userRepository.findByEmail(email);

        if (user == null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("User with " + email + " does not exist."));

        return user;
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