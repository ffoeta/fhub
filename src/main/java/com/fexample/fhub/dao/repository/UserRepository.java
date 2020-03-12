package com.fexample.fhub.dao.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.fexample.fhub.dao.model.classes.User.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Page<User> findAllByFirstname(String firstname, Pageable pageable);

    Page<User> findAllByLastname(String lastname, Pageable pageable);

    User findByUsername(String username);

    User findByEmail(String email);

}