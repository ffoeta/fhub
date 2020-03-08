package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Dish;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

public class DishDto  implements DtoEntity<Dish> {
    @Override
    public DishDto fromModel(Dish dish) {

        return this;
    }

    @Override
    public Dish toModel() {
        return null;
    }
}
