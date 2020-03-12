package com.fexample.fhub.facade.interfaces.service;

import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;

public interface DishService {

    //save dish
    Dish saveDish(Dish dish) throws EntityAlreadyExistsException;

    //update dish
    Dish updateDish(Dish dish) throws EntityNotExistsException;

    //disable dish by name
    Dish fakeDeleteDishByName(String name) throws EntityNotExistsException;

    //delete dish by name
    void deleteDishByName(String name) throws EntityNotExistsException;
}
