package com.fexample.fhub.dao.service.Static;

import com.fexample.fhub.dao.model.classes.Static.Image;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.repository.Static.ImageRepository;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import com.fexample.fhub.facade.interfaces.service.Static.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository ImageRepository;

    @Override
    public Image saveImage(Image Image) throws EntityAlreadyExistsException {

        Image.setId(UUID.randomUUID());
        Image.setCreated(new Date());
        Image.setUpdated(new Date());
        Image.setStatus(Status.ACTIVE);

        return this.ImageRepository.save(Image);
    }

    @Override
    public Image updateImage(Image Image)  throws EntityNotExistsException {

        Optional<Image> Image2 = this.ImageRepository.findById(Image.getId());

        Image2.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Image " + Image.getId().toString() + " does not exist.")));

        Image.setId(Image2.get().getId());
        Image.setStatus(Image2.get().getStatus());
        Image.setCreated(Image2.get().getCreated());
        Image.setUpdated(new Date());

        return this.ImageRepository.save(Image);
    }

    @Override
    public Image fakeDeleteImageById(UUID id) throws EntityNotExistsException {

        Optional<Image> Image = this.ImageRepository.findById(id);

        Image.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Image " + id + " does not exist.")));

        Image.get().setStatus(Status.DELETED);
        Image.get().setUpdated(new Date());

        return this.ImageRepository.save(Image.get());
    }

    @Override
    public void deleteImageById(UUID id) throws EntityNotExistsException {

        Optional<Image> Image = this.ImageRepository.findById(id);

        Image.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Image " + id + " does not exist.")));

        this.ImageRepository.deleteById(id);
    }

    @Override
    public List<Image> findAllImages(Pageable pageable) {

        return this.ImageRepository.findAll(pageable).getContent();
    }

    @Override
    public Image findById(UUID id) throws EntityNotExistsException {

        Optional<Image> Image = this.ImageRepository.findById(id);

        Image.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Image " + id + " does not exist.")));

        return Image.get();
    }
}
