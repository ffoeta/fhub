package com.fexample.fhub.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role extends BaseEntity{

    @Column(name = "name")
    private String name;
}