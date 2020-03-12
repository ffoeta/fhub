package com.fexample.fhub.dao.model.classes.Static;

import com.fexample.fhub.dao.model.classes.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "c_image_table")
public class Image extends BaseEntity {

    @Lob
    @Column(name = "image")
    private byte[] image;

    public byte[] getImage() {

        return image;
    }

    public void setImage(byte[] image) {

        this.image = image;
    }

}