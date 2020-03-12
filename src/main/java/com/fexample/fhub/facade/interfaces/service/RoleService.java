package com.fexample.fhub.facade.interfaces.service;

import com.fexample.fhub.dao.model.classes.User.Role;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    //save role
    Role saveRole(Role role) throws EntityAlreadyExistsException;

    //update role
    Role updateRole(Role role) throws EntityNotExistsException;

    //find all roles
    List<Role> findAllRoles(Pageable pageable);

    //find by name
    Role findByName(String name) throws EntityNotExistsException;
}