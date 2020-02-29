package com.fexample.fhub.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ingridient")
@Data
public class Ingridient extends BaseEntity {
    @Column(name = "name")
    private String name;
}