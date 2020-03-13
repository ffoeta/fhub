package com.fexample.fhub.dao.model.classes.Store;

import com.fexample.fhub.dao.model.classes.BaseEntity;
import com.fexample.fhub.dao.model.classes.Static.Link;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "с_dish_table")
public class Dish extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "r_dish_image_table", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "link_id", referencedColumnName = "id")})
    private Link image;

    @Column(name = "kkal")
    private int kkal;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_dish_category_table", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categories;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_dish_galery_table", joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "link_id", referencedColumnName = "id")})
    private List<Link> galery;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Link getImage() {

        return image;
    }

    public void setImage(Link image) {

        this.image = image;
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

    public List<Link> getGalery() {

        return galery;
    }

    public void setGalery(List<Link> galery) {

        this.galery = galery;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }
}