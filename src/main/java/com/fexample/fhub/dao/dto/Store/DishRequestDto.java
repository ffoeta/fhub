package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Static.Image;
import com.fexample.fhub.dao.model.classes.Static.Link;
import com.fexample.fhub.dao.model.classes.Store.Category;
import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;
import com.fexample.fhub.facade.interfaces.service.Static.ImageService;
import com.fexample.fhub.facade.interfaces.service.Static.LinkService;
import com.fexample.fhub.facade.interfaces.service.Store.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DishRequestDto implements DtoRequestEntity<Dish> {

    @Autowired
    LinkService linkService;

    @Autowired
    ImageService imageService;

    @Autowired
    CategoryService categoryService;

    private String name;

    private byte[] image;

    private int kkal;

    private int price;

    private String description;

    List<String> categories;

    List<byte[]> galery;

    @Override
    public Dish toModel() {

        Dish dish = new Dish();

        Image image = new Image();

        image.setImage(this.getImage());
        image.setId(UUID.randomUUID());
        image.setStatus(Status.ACTIVE);
        image.setCreated(new Date());
        image.setUpdated(new Date());

        image = this.imageService.saveImage(image);

        Link link = new Link();

        link.setUrl(image.getId().toString());
        link.setId(UUID.randomUUID());
        link.setStatus(Status.ACTIVE);
        link.setCreated(new Date());
        link.setUpdated(new Date());

        link = this.linkService.saveLink(link);

        dish.setImage(link);

        dish.setName(this.getName());
        dish.setKkal(this.getKkal());
        dish.setPrice(this.getPrice());
        dish.setDescription(this.getDescription());

        List<Category> categories = new ArrayList<>();
        this.categories.forEach((categoryString) -> {
            categories.add(this.categoryService.findByName(categoryString));
        });

        dish.setCategories(categories);

        List<Link> galery2 = new ArrayList<>();

        this.getGalery().forEach((galeryImage) -> {
            Image image2 = new Image();

            image2.setImage(galeryImage);
            image2.setId(UUID.randomUUID());
            image2.setStatus(Status.ACTIVE);
            image2.setCreated(new Date());
            image2.setUpdated(new Date());

            image2 = this.imageService.saveImage(image2);

            Link link2 = new Link();

            link2.setUrl(image2.getId().toString());
            link2.setId(UUID.randomUUID());
            link2.setStatus(Status.ACTIVE);
            link2.setCreated(new Date());
            link2.setUpdated(new Date());

            link2 = this.linkService.saveLink(link2);

            galery2.add(link2);
        });

        return dish;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<byte[]> getGalery() {
        return galery;
    }

    public void setGalery(List<byte[]> galery) {
        this.galery = galery;
    }
}
