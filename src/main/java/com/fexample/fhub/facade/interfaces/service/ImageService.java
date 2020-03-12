package com.fexample.fhub.facade.interfaces.service;

import com.fexample.fhub.dao.model.classes.Static.Image;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;

import java.util.UUID;

public interface ImageService {

    //save image
    Image saveImage(Image image);

    //disable image by name
    Image fakeDeleteImageById(UUID id) throws EntityNotExistsException;

    //delete image by name
    void deleteImageById(UUID id) throws EntityNotExistsException;

    //find by id
    Image findById(UUID id) throws EntityNotExistsException, ControllerServiceCallException;

}
