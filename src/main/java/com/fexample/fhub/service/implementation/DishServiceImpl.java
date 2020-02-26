package com.spring.service.Implementations;

import com.fexample.fhub.dto.Dish.DishExtended;

import com.fexample.fhub.model.Category;
import com.fexample.fhub.model.Dish;
import com.fexample.fhub.model.DishDetails;
import com.fexample.fhub.model.Status;

import com.fexample.fhub.repository.DishRepository;
import com.fexample.fhub.repository.DishDetailsRepository;
import com.fexample.fhub.repository.IngridientRepository;
import com.fexample.fhub.repository.CategoryRepository;

import com.fexample.fhub.service.interface_.DishService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final DishDetailsRepository detailsRepository;
    private final CategoryRepository categoryRepository;
    private final IngridientRepository ingridientRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, DishDetailsRepository detailsRepository, 
                            CategoryRepository categoryRepository, IngridientRepository ingridientRepository) {
        this.dishRepository = dishRepository;
        this.detailsRepository = detailsRepository;
        this.categoryRepository = categoryRepository;
        this.ingridientRepository = ingridientRepository;
    }

    @Override
    public Dish save(Dish dish){

        DishDetails dishDetails = new DishDetails();

        dish.setId(UUID.randomUUID());
        dish.setStatus(Status.ACTIVE);

        dishDetails.setId(UUID.randomUUID());
        dishDetails.setStatus(Status.ACTIVE);

        Date date = new Date();

        dish.setCreated(date);
        dish.setUpdated(date);

        dishDetails.setCreated(date);
        dishDetails.setUpdated(date);

        detailsRepository.save(dishDetails);
        dishRepository.save(dish);

        Dish dish2 = dishRepository.findById(dish.getId()).orElse(null);
        DishDetails dishDetails2 = detailsRepository.findById(dishDetails.getId()).orElse(null);

        dish2.setDishDetails((dishDetails);
        dishDetails2.setItem(dish);

        detailsRepository.save(dishDetails);

        return dishRepository.save(dish2);
    }

    @Override
    public Item update(Item item) {
        item.setUpdated(new Date());
        return itemRepository.save(item);
    }

    @Override
    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public Item findById(UUID id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        itemRepository.deleteById(id);
    }

    public Item getItem(ItemBodyV2 itemBodyV2) {
        Item item = null;
        if (itemBodyV2.getId() != null) {
            item = findById(UUID.fromString(itemBodyV2.getId()));
        } else {
            item = findByName(itemBodyV2.getName());
        }
        return item;
    }

    public Item setItem(Item item, ItemBodyV2 itemBodyV2) {
        if (item == null) {
            return null;
        }

        UUID id = UUID.fromString(itemBodyV2.getId());
        String name = itemBodyV2.getName();
        Category category = categoryRepository.findByName(itemBodyV2.getCategoty());
        Brand brand = brandRepository.findByName(itemBodyV2.getBrand());

        if (id != null) {
            item.setId(id);
        }
        if (name != null) {
            item.setName(name);
        }
        if (category != null) {
            item.setCategory(category);
        }
        if (brand != null) {
            item.setBrand(brand);
        }
        return item;
    }
}