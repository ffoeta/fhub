package com.fexample.fhub.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
@Data
public class Store extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "store_dish", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")})
    private List<Dish> dishes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "store_category", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "store_food", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "food_id", referencedColumnName = "id")})
    private List<Food> foods;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "store_details", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "details_id", referencedColumnName = "id")})
    StoreDetails storeDetails;

}