package com.fexample.fhub.dao.service;

import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.repository.DishRepository;
import com.fexample.fhub.facade.interfaces.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository dishRepository;

    @Override
    public Dish saveDish(Dish dish) {

        if (this.dishRepository.findByName(dish.getName()) == null) return  null;

        dish.setCreated(new Date());
        dish.setUpdated(new Date());
        dish.setStatus(Status.ACTIVE);

        return this.dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Dish dish) {
        return null;
    }

    @Override
    public Dish fakeDeleteDishByName(String name) {
        return null;
    }

    @Override
    public void deleteDishByName(String name) {

    }
}
