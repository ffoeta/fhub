package com.fexample.fhub.dao.dto.Dish;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fexample.fhub.dao.model.Category;
import com.fexample.fhub.dao.model.Dish;
import com.fexample.fhub.dao.model.Image;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DishShort {

    private String name;
    private int kkal;
    private int price;
    List<Category> categories;
    Image image;

    public Dish toDish(){

        Dish dish = new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setCategories(categories);
        dish.setImage(image);

        return dish;
    }

    public static DishShort fromDish(Dish dish){
        DishShort short_ = new DishShort();

        short_.setName(dish.getName());
        short_.setPrice(dish.getPrice());
        short_.setCategories(dish.getCategories());
        short_.setImage(dish.getImage());

        return short_;
    }
}