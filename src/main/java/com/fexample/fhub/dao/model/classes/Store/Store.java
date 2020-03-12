package com.fexample.fhub.dao.model.classes.Store;

import com.fexample.fhub.dao.model.classes.BaseEntity;
import com.fexample.fhub.dao.model.classes.Static.Image;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "c_store_table")
public class Store extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_store_dish_table", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")})
    private List<Dish> dishes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_store_category_table", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_store_food_table", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "food_id", referencedColumnName = "id")})
    private List<Food> foods;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_store_image_table", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")})
    List<Image> images;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "r_store_details_table", joinColumns = {@JoinColumn(name = "store_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "details_id", referencedColumnName = "id")})
    StoreDetails storeDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public StoreDetails getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(StoreDetails storeDetails) {
        this.storeDetails = storeDetails;
    }
}