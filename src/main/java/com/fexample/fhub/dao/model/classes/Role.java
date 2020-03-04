package com.fexample.fhub.dao.model.classes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "c_role_table")
@Data
public class Role extends BaseEntity{

    @Column(name = "name")
    private String name;
}