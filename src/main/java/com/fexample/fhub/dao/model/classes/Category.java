package com.fexample.fhub.dao.model.classes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "с_category_table")
@Data
public class Category extends BaseEntity {
    @Column(name = "name")
    private String name;
}