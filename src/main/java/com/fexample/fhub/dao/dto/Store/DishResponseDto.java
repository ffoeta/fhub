package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Static.Image;
import com.fexample.fhub.dao.model.classes.Store.Category;
import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoResponseEntity;
import com.fexample.fhub.facade.interfaces.service.Static.ImageService;
import com.fexample.fhub.facade.interfaces.service.Static.LinkService;
import com.fexample.fhub.facade.interfaces.service.Store.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DishResponseDto  implements DtoResponseEntity<Dish> {

    @Autowired
    LinkService linkService;

    @Autowired
    ImageService imageService;

    @Autowired
    CategoryService categoryService;

    private String name;

    private String image;

    private int kkal;

    private int price;

    private String description;

    List<String> categories;

    List<String> galery;


    @Override
    public DishResponseDto fromModel(Dish dish) {

        this.setName(dish.getName());
        this.setImage(dish.getImage().getUrl());

        this.setKkal(dish.getKkal());
        this.setPrice(dish.getPrice());
        this.setDescription(dish.getDescription());

        List<String> categoriesString = new ArrayList<>();

        dish.getCategories().forEach((category) -> {
            categoriesString.add(category.getName());
        });
        this.setCategories(categoriesString);

        List<String> galeryString = new ArrayList<>();

        dish.getGalery().forEach((link) -> {
            galeryString.add(link.getUrl());
        });
        this.setGalery(galeryString);

        return this;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getKkal() {

        return kkal;
    }

    public void setKkal(int kkal) {

        this.kkal = kkal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public List<String> getCategories() {

        return categories;
    }

    public void setCategories(List<String> categories) {

        this.categories = categories;
    }

    public LinkService getLinkService() {
        return linkService;
    }

    public void setLinkService(LinkService linkService) {
        this.linkService = linkService;
    }

    public ImageService getImageService() {
        return imageService;
    }

    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getGalery() {
        return galery;
    }

    public void setGalery(List<String> galery) {
        this.galery = galery;
    }
}
