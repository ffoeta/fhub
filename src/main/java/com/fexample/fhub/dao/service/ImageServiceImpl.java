package com.fexample.fhub.dao.service;

import com.fexample.fhub.dao.model.classes.Static.Image;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.repository.ImageRepository;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import com.fexample.fhub.facade.interfaces.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image saveImage(Image image) throws EntityAlreadyExistsException{

        if ( this.imageRepository.findById(image.getId()).orElse(null) != null)
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Image" + image.getId().toString() + "already exists in image repository."));

        return this.imageRepository.save(image);
    }

    @Override
    public Image fakeDeleteImageById(UUID id) throws EntityNotExistsException {

        Image image = this.imageRepository.findById(id).orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityNotExistsException("Unable to find " + id.toString() + " in image repository.")));

        image.setStatus(Status.DELETED);
        image.setUpdated(new Date());

        return this.imageRepository.save(image);
    }

    @Override
    public void deleteImageById(UUID id) throws EntityNotExistsException {

        Image image = this.imageRepository.findById(id).orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityNotExistsException("Unable to find " + id.toString() + " in image repository.")));

        this.imageRepository.delete(image);
    }

    @Override
    public Image findById(UUID id) throws EntityNotExistsException {
        
        Image image = this.imageRepository.findById(id).orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityNotExistsException("Unable to find " + id.toString() + " in image repository.")));

        return image;
    }
}
