package com.fexample.fhub.dao.service.Store;

import com.fexample.fhub.dao.model.classes.Store.Category;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.repository.Store.CategoryRepository;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import com.fexample.fhub.facade.interfaces.service.Store.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository CategoryRepository;

    @Override
    public Category saveCategory(Category Category) throws EntityAlreadyExistsException {

        if (this.CategoryRepository.findByName(Category.getName()) != null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Category " + Category.getName() + " already exists."));


        Category.setId(UUID.randomUUID());
        Category.setCreated(new Date());
        Category.setUpdated(new Date());
        Category.setStatus(Status.ACTIVE);

        return this.CategoryRepository.save(Category);
    }

    @Override
    public Category updateCategory(Category Category)  throws EntityNotExistsException {

        Optional<Category> Category2 = this.CategoryRepository.findById(Category.getId());

        Category2.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Category " + Category.getId().toString() + " does not exist.")));

        Category.setId(Category2.get().getId());
        Category.setStatus(Category2.get().getStatus());
        Category.setCreated(Category2.get().getCreated());
        Category.setUpdated(new Date());

        return this.CategoryRepository.save(Category);
    }

    @Override
    public Category fakeDeleteCategoryById(UUID id) throws EntityNotExistsException {

        Optional<Category> Category = this.CategoryRepository.findById(id);

        Category.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Category " + id + " does not exist.")));

        Category.get().setStatus(Status.DELETED);
        Category.get().setUpdated(new Date());

        return this.CategoryRepository.save(Category.get());
    }

    @Override
    public void deleteCategoryById(UUID id) throws EntityNotExistsException {

        Optional<Category> Category = this.CategoryRepository.findById(id);

        Category.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Category " + id + " does not exist.")));

        this.CategoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategories(Pageable pageable) {

        return this.CategoryRepository.findAll(pageable).getContent();
    }

    @Override
    public Category findByName(String name) throws EntityNotExistsException {

        Category Category = this.CategoryRepository.findByName(name);

        if (Category == null)
            throw new ControllerServiceCallException(
                    new EntityAlreadyExistsException("Category " + name + " does not exist."));

        return Category;
    }

    @Override
    public Category findById(UUID id) throws EntityNotExistsException {

        Optional<Category> Category = this.CategoryRepository.findById(id);

        Category.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Category " + id + " does not exist.")));

        return Category.get();
    }
}
