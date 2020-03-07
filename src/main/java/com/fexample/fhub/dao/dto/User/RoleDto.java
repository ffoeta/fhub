package com.fexample.fhub.dao.dto.User;

import com.fexample.fhub.dao.model.classes.Role;
import com.fexample.fhub.dao.model.classes.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

public class RoleDto implements DtoEntity<Role> {

    private String name;

    @Override
    public Role toModel() {
        Role role = new Role();

        role.setName(this.getName());

        return role;
    }

    public static RoleDto fromModel(Role role) {
        RoleDto roleDto = new RoleDto();

        roleDto.setName(role.getName());

        return roleDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
