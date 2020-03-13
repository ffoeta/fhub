package com.fexample.fhub.dao.repository.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.fexample.fhub.dao.model.classes.User.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    
    Role findByName(String name);

    Page<Role> findAll(Pageable pageable);

}