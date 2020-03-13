package com.fexample.fhub.dao.service.User;

import com.fexample.fhub.dao.model.classes.User.Role;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.repository.User.RoleRepository;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import com.fexample.fhub.facade.interfaces.service.User.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) throws EntityAlreadyExistsException {

        if (this.roleRepository.findByName(role.getName()) != null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Role " + role.getName() + " already exists."));


        role.setId(UUID.randomUUID());
        role.setCreated(new Date());
        role.setUpdated(new Date());
        role.setStatus(Status.ACTIVE);

        return this.roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role)  throws EntityNotExistsException {

        Optional<Role> role2 = this.roleRepository.findById(role.getId());

        role2.orElseThrow(() ->
            new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Role " + role.getId().toString() + " does not exist.")));

        role.setId(role2.get().getId());
        role.setStatus(role2.get().getStatus());
        role.setCreated(role2.get().getCreated());
        role.setUpdated(new Date());

        return this.roleRepository.save(role);
    }

    @Override
    public Role fakeDeleteRoleById(UUID id) throws EntityNotExistsException {

        Optional<Role> role = this.roleRepository.findById(id);

        role.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Role " + id + " does not exist.")));

        role.get().setStatus(Status.DELETED);
        role.get().setUpdated(new Date());

        return this.roleRepository.save(role.get());
    }

    @Override
    public void deleteRoleById(UUID id) throws EntityNotExistsException {

        Optional<Role> role = this.roleRepository.findById(id);

        role.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Role " + id + " does not exist.")));

        this.roleRepository.deleteById(id);
    }

    @Override
    public List<Role> findAllRoles(Pageable pageable) {

        return this.roleRepository.findAll(pageable).getContent();
    }

    @Override
    public Role findByName(String name) throws EntityNotExistsException {

        Role role = this.roleRepository.findByName(name);

        if (role == null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Role " + name + " does not exist."));

        return role;
    }

    @Override
    public Role findById(UUID id) throws EntityNotExistsException {

        Optional<Role> role = this.roleRepository.findById(id);

        role.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Role " + id + " does not exist.")));

        return role.get();
    }
}
