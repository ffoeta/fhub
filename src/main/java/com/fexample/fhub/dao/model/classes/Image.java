package com.fexample.fhub.dao.model.classes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "c_image_table")
@Data
public class Image extends BaseEntity {
    @Column(name = "name")
    private String name;
}