package com.fexample.fhub.facade.interfaces.service;

import com.fexample.fhub.dao.model.classes.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    //save role
    Role saveRole(Role role);

    //update role
    Role updateRole(Role role);

    //find all roles
    List<Role> findAllRoles(Pageable pageable);

    //find by name
    Role findByName(String name);

}