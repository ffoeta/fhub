package com.fexample.fhub.service.interface_;

import com.fexample.fhub.dto.Dish.DishExtended;
import com.fexample.fhub.model.Dish;

import java.util.List;
import java.util.UUID;

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