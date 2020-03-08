package com.fexample.fhub.dao.dto.Static;

import com.fexample.fhub.dao.model.classes.Image;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.UUID;

public class ImageDto  implements DtoEntity<Image> {

    private UUID id;
    private String name;

    @Override
    public ImageDto fromModel(Image image) {

        this.setId(image.getId());
        this.setName(image.getName());

        return this;
    }

    @Override
    public Image toModel() {
        Image image = new Image();

        image.setId(id);
        image.setName(name);

        return image;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
