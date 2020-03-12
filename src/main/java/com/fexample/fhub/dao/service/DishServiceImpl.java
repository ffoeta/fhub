package com.fexample.fhub.dao.service;

import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.repository.DishRepository;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import com.fexample.fhub.facade.interfaces.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository dishRepository;

    @Override
    public Dish saveDish(Dish dish) throws EntityAlreadyExistsException {

        if (this.dishRepository.findByName(dish.getName()) != null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Dish" + dish.getName() + "already exists."));

        dish.setCreated(new Date());
        dish.setUpdated(new Date());
        dish.setStatus(Status.ACTIVE);

        return this.dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Dish dish) throws EntityNotExistsException {

        Dish dish2 = this.dishRepository.findByName(dish.getName());

        if (dish2 != null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Dish" + dish.getName() + "does not exist."));

        dish.setId(dish2.getId());
        dish.setStatus(dish2.getStatus());
        dish.setCreated(dish2.getCreated());
        dish.setUpdated(new Date());

        return this.dishRepository.save(dish);
    }

    @Override
    public Dish fakeDeleteDishByName(String name) throws EntityNotExistsException {

        Dish dish = this.dishRepository.findByName(name);

        if (dish != null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Dish" + dish.getName() + "does not exist."));

        dish.setUpdated(new Date());
        dish.setStatus(Status.DELETED);

        return this.dishRepository.save(dish);
    }

    @Override
    public void deleteDishByName(String name) throws EntityNotExistsException {

        Dish dish = this.dishRepository.findByName(name);

        if (dish != null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Dish" + dish.getName() + "does not exist."));

        this.dishRepository.delete(dish);
    }
}
