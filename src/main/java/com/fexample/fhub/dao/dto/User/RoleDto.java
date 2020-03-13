package com.fexample.fhub.dao.dto.User;

import com.fexample.fhub.dao.model.classes.User.Role;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoResponseEntity;

import java.util.UUID;

public class RoleDto implements DtoResponseEntity<Role>, DtoRequestEntity<Role> {

    private UUID id;
    private String name;

    @Override
    public Role toModel() {
        Role role = new Role();

        role.setName(this.getName());

        return role;
    }

    @Override
    public RoleDto fromModel(Role role) {

        this.setId(role.getId());
        this.setName(role.getName());

        return this;
    }

    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
