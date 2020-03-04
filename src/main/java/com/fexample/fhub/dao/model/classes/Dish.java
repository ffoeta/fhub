package com.fexample.fhub.dao.model.classes;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "с_dish_table")
@Data
public class Dish extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "kkal")
    private int kkal;

    @Column(name = "price")
    private int price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_dish_category_table", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    List<Category> categories;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "r_dish_image_table", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")})
    Image image;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "r_dish_details_table", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "details_id", referencedColumnName = "id")})
    DishDetails dishDetails;

}