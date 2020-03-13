package com.fexample.fhub.facade.interfaces.service.Store;

import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DishService {

    //save Dish
    Dish saveDish(Dish Dish) throws EntityAlreadyExistsException;

    //update Dish
    Dish updateDish(Dish Dish) throws EntityNotExistsException;

    //disable Dish by name
    Dish fakeDeleteDishById(UUID id) throws EntityNotExistsException;

    //delete Dish by name
    void deleteDishById(UUID id) throws EntityNotExistsException;

    //find all Dishes
    List<Dish> findAllDishes(Pageable pageable);

    //find by name
    Dish findByName(String name) throws EntityNotExistsException;

    //find by id
    Dish findById(UUID id) throws EntityNotExistsException;
}
