package com.fexample.fhub.model;

import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "dishdetails")
@Data
public class DishDetails extends BaseEntity{

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "details_image", joinColumns = {@JoinColumn(name = "details_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")})
    List<Image> images;
}