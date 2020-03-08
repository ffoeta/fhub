package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Store;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.UUID;

public class StoreDto  implements DtoEntity<Store> {

    private UUID id;
    private String name;

    @Override
    public StoreDto fromModel(Store store) {

        return this;
    }

    @Override
    public Store toModel() {
        return null;
    }
}
