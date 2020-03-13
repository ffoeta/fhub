package com.fexample.fhub.facade.interfaces.service.Static;

import com.fexample.fhub.dao.model.classes.Static.Image;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ImageService {

    //save Image
    Image saveImage(Image Image) throws EntityAlreadyExistsException;

    //update Image
    Image updateImage(Image Image) throws EntityNotExistsException;

    //disable Image by name
    Image fakeDeleteImageById(UUID id) throws EntityNotExistsException;

    //delete Image by name
    void deleteImageById(UUID id) throws EntityNotExistsException;

    //find all Images
    List<Image> findAllImages(Pageable pageable);

    //find by id
    Image findById(UUID id) throws EntityNotExistsException;
}
