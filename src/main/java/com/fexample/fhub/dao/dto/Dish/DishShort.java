package com.fexample.fhub.dao.dto.Dish;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fexample.fhub.dao.model.classes.Category;
import com.fexample.fhub.dao.model.classes.Dish;
import com.fexample.fhub.dao.model.classes.Image;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DishShort implements DtoEntity<Dish>{

    private String name;
    private int kkal;
    private int price;
    List<Category> categories;
    Image image;

    public Dish toModel(){

        Dish dish = new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setCategories(categories);
        dish.setImage(image);

        return dish;
    }

    public static DishShort fromModel(Dish dish){
        DishShort short_ = new DishShort();

        short_.setName(dish.getName());
        short_.setPrice(dish.getPrice());
        short_.setCategories(dish.getCategories());
        short_.setImage(dish.getImage());

        return short_;
    }
}