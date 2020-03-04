package com.fexample.fhub.dao.model.classes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "c_ingridient_table")
@Data
public class Ingridient extends BaseEntity {
    @Column(name = "name")
    private String name;
}