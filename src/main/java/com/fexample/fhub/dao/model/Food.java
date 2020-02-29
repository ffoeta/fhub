package com.fexample.fhub.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "food")
@Data
public class Food extends BaseEntity {
    @Column(name = "name")
    private String name;
}