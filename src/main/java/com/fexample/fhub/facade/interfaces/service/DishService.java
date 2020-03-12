package com.fexample.fhub.facade.interfaces.service;

import com.fexample.fhub.dao.model.classes.Store.Dish;

public interface DishService {

    //save dish
    Dish saveDish(Dish dish);

    //update dish
    Dish updateDish(Dish dish);

    //disable dish by name
    Dish fakeDeleteDishByName(String name);

    //delete dish by name
    void deleteDishByName(String name);
}
