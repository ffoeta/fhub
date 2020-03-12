package com.fexample.fhub.dao.model.classes.User;

import com.fexample.fhub.dao.model.classes.BaseEntity;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.facade.interfaces.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.*;

@Entity
@Table(name = "c_role_table")
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}