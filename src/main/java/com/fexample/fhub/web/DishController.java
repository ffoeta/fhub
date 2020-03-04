package com.fexample.fhub.web;

import com.fexample.fhub.dao.dto.Dish.DishExtended;
import com.fexample.fhub.dao.model.classes.Dish;
import com.fexample.fhub.facades.generics.controller.EntityControllerGeneric;
import com.fexample.fhub.facades.interfaces.service.DishService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/dish")
public class DishController extends EntityControllerGeneric<Dish, DishExtended, DishService>{}