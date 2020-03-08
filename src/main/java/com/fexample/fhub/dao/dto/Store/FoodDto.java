package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Food;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.UUID;

public class FoodDto  implements DtoEntity<Food> {

    private UUID id;
    private String name;

    @Override
    public FoodDto fromModel(Food food) {

        return this;
    }

    @Override
    public Food toModel() {
        return null;
    }
}
