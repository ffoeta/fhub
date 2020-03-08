package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.StoreDetails;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.UUID;

public class StoreDetailsDto  implements DtoEntity<StoreDetails> {

    private UUID id;
    private String name;

    @Override
    public StoreDetailsDto fromModel(StoreDetails storeDetails) {

        return this;
    }

    @Override
    public StoreDetails toModel() {
        return null;
    }
}
