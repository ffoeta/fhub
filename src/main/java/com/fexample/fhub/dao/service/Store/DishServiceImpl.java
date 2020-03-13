package com.fexample.fhub.dao.service.Store;

import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.repository.Store.DishRepository;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import com.fexample.fhub.facade.interfaces.service.Store.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository DishRepository;

    @Override
    public Dish saveDish(Dish Dish) throws EntityAlreadyExistsException {

        if (this.DishRepository.findByName(Dish.getName()) != null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Dish " + Dish.getName() + " already exists."));


        Dish.setId(UUID.randomUUID());
        Dish.setCreated(new Date());
        Dish.setUpdated(new Date());
        Dish.setStatus(Status.ACTIVE);

        return this.DishRepository.save(Dish);
    }

    @Override
    public Dish updateDish(Dish Dish)  throws EntityNotExistsException {

        Optional<Dish> Dish2 = this.DishRepository.findById(Dish.getId());

        Dish2.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Dish " + Dish.getId().toString() + " does not exist.")));

        Dish.setId(Dish2.get().getId());
        Dish.setStatus(Dish2.get().getStatus());
        Dish.setCreated(Dish2.get().getCreated());
        Dish.setUpdated(new Date());

        return this.DishRepository.save(Dish);
    }

    @Override
    public Dish fakeDeleteDishById(UUID id) throws EntityNotExistsException {

        Optional<Dish> Dish = this.DishRepository.findById(id);

        Dish.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Dish " + id + " does not exist.")));

        Dish.get().setStatus(Status.DELETED);
        Dish.get().setUpdated(new Date());

        return this.DishRepository.save(Dish.get());
    }

    @Override
    public void deleteDishById(UUID id) throws EntityNotExistsException {

        Optional<Dish> Dish = this.DishRepository.findById(id);

        Dish.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Dish " + id + " does not exist.")));

        this.DishRepository.deleteById(id);
    }

    @Override
    public List<Dish> findAllDishes(Pageable pageable) {

        return this.DishRepository.findAll(pageable).getContent();
    }

    @Override
    public Dish findByName(String name) throws EntityNotExistsException {

        Dish Dish = this.DishRepository.findByName(name);

        if (Dish == null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Dish " + name + " does not exist."));

        return Dish;
    }

    @Override
    public Dish findById(UUID id) throws EntityNotExistsException {

        Optional<Dish> Dish = this.DishRepository.findById(id);

        Dish.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Dish " + id + " does not exist.")));

        return Dish.get();
    }
}
