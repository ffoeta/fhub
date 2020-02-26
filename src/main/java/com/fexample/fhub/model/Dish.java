package com.fexample.fhub.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish")
@Data
public class Dish extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "kkal")
    private int kkal;

    @Column(name = "price")
    private int price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dish_category", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    List<Category> categories;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "dish_image", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")})
    Image image;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "dish_details", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "details_id", referencedColumnName = "id")})
    DishDetails dishDetails;

}