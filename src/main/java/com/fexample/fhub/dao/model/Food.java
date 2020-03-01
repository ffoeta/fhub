package com.fexample.fhub.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "c_food_table")
@Data
public class Food extends BaseEntity {
    @Column(name = "name")
    private String name;
}