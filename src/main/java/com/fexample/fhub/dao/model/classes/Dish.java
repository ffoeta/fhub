package com.fexample.fhub.dao.model.classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "с_dish_table")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKkal() {
        return kkal;
    }

    public void setKkal(int kkal) {
        this.kkal = kkal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public DishDetails getDishDetails() {
        return dishDetails;
    }

    public void setDishDetails(DishDetails dishDetails) {
        this.dishDetails = dishDetails;
    }
}