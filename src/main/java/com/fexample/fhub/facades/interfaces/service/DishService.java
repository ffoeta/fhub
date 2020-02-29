package com.fexample.fhub.facades.interfaces.service;

import java.util.List;
import java.util.UUID;

import com.fexample.fhub.dao.dto.Dish.DishExtended;
import com.fexample.fhub.dao.model.Dish;

public interface DishService {
    Dish save(Dish dish);

    Dish update(Dish dish);

    Dish findByName(String name);

    Dish findById(UUID id);

    List<Dish> getAll();

    void deleteById(UUID id);

    Dish getDish(DishExtended extended);

    Dish setDish(Dish dish, DishExtended extended);
}