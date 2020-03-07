package com.fexample.fhub.dao.model.classes;

import javax.persistence.*;

@Entity
@Table(name = "c_food_table")
public class Food extends BaseEntity {
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}