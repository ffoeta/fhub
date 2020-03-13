package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Store.Food;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoResponseEntity;

import java.util.UUID;

public class FoodDto  implements DtoResponseEntity<Food>, DtoRequestEntity<Food> {

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
