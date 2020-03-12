package com.fexample.fhub.dao.service;

import com.fexample.fhub.dao.model.classes.User.Role;
import com.fexample.fhub.dao.repository.RoleRepository;
import com.fexample.fhub.facade.interfaces.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        if (this.roleRepository.findByName(role.getName()) != null) {
            return null;
        }

        role.setId(UUID.randomUUID());

        role.setCreated(new Date());

        role.setUpdated(new Date());

        return this.roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        if (this.roleRepository.findByName(role.getName()) == null) {
            return null;
        }

        role.setUpdated(new Date());

        return this.roleRepository.save(role);
    }

    @Override
    public List<Role> findAllRoles(Pageable pageable) {
        return this.roleRepository.findAll(pageable).getContent();
    }

    @Override
    public Role findByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
