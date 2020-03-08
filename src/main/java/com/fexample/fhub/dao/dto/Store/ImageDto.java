package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Image;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.UUID;

public class ImageDto  implements DtoEntity<Image> {

    private UUID id;
    private String name;

    @Override
    public ImageDto fromModel(Image image) {

        return this;
    }

    @Override
    public Image toModel() {
        return null;
    }
}
