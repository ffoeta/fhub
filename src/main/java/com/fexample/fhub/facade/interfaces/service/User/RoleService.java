package com.fexample.fhub.facade.interfaces.service.User;

import com.fexample.fhub.dao.model.classes.User.Role;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface RoleService {

    //save Role
    Role saveRole(Role Role) throws EntityAlreadyExistsException;

    //update Role
    Role updateRole(Role Role) throws EntityNotExistsException;

    //disable Role by name
    Role fakeDeleteRoleById(UUID id) throws EntityNotExistsException;

    //delete Role by name
    void deleteRoleById(UUID id) throws EntityNotExistsException;

    //find all Roles
    List<Role> findAllRoles(Pageable pageable);

    //find by name
    Role findByName(String name) throws EntityNotExistsException;

    //find by id
    Role findById(UUID id) throws EntityNotExistsException;
}