package com.fexample.fhub.facade.interfaces.service;

import com.fexample.fhub.dao.model.classes.Role;

public interface RoleService {

    //find by name
    Role findByName(String name);

}