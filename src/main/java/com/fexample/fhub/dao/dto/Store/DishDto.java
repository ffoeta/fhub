package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.dao.model.classes.Store.DishDetails;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.List;

public class DishDto  implements DtoEntity<Dish> {

    private String name;

    private int kkal;

    private int price;

    List<String> categories;

    List<byte[]> images;

    DishDetails dishDetails;

    @Override
    public DishDto fromModel(Dish dish) {

        this.setName(dish.getName());
        this.setKkal(dish.getKkal());
        this.setPrice(dish.getPrice());
//        this.setCategories(dish.getCategories());
//        this.setImages(dish.getImages());
        this.setDishDetails(dish.getDishDetails());

        return this;
    }

    @Override
    public Dish toModel() {

        Dish dish = new Dish();

        dish.setName(this.getName());
        dish.setKkal(this.getKkal());
        dish.setPrice(this.getPrice());
//        dish.setCategories(this.getCategories());
//        dish.setImages(this.getImages());
        dish.setDishDetails(this.getDishDetails());

        return dish;
    }

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

    public List<String> getCategories() {

        return categories;
    }

    public void setCategories(List<String> categories) {

        this.categories = categories;
    }

    public List<byte[]> getImages() {

        return images;
    }

    public void setImages(List<byte[]> images) {

        this.images = images;
    }

    public DishDetails getDishDetails() {

        return dishDetails;
    }

    public void setDishDetails(DishDetails dishDetails) {

        this.dishDetails = dishDetails;
    }
}
