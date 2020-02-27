// package com.spring.service.Implementations;

// import com.fexample.fhub.dto.Dish.DishExtended;

// import com.fexample.fhub.model.Category;
// import com.fexample.fhub.model.Dish;
// import com.fexample.fhub.model.DishDetails;
// import com.fexample.fhub.model.Status;

// import com.fexample.fhub.repository.DishRepository;
// import com.fexample.fhub.repository.DishDetailsRepository;
// import com.fexample.fhub.repository.IngridientRepository;
// import com.fexample.fhub.repository.CategoryRepository;

// import com.fexample.fhub.service.interface_.DishService;

// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.Date;
// import java.util.List;
// import java.util.UUID;

// @Service
// @Slf4j
// public class DishServiceImpl implements DishService {

//     private final DishRepository dishRepository;
//     private final DishDetailsRepository detailsRepository;
//     private final CategoryRepository categoryRepository;
//     private final IngridientRepository ingridientRepository;

//     @Autowired
//     public DishServiceImpl(DishRepository dishRepository, DishDetailsRepository detailsRepository, 
//                             CategoryRepository categoryRepository, IngridientRepository ingridientRepository) {
//         this.dishRepository = dishRepository;
//         this.detailsRepository = detailsRepository;
//         this.categoryRepository = categoryRepository;
//         this.ingridientRepository = ingridientRepository;
//     }

//     @Override
//     public Dish save(Dish dish){

//         DishDetails dishDetails = new DishDetails();

//         dish.setId(UUID.randomUUID());
//         dish.setStatus(Status.ACTIVE);

//         dishDetails.setId(UUID.randomUUID());
//         dishDetails.setStatus(Status.ACTIVE);

//         Date date = new Date();

//         dish.setCreated(date);
//         dish.setUpdated(date);

//         dishDetails.setCreated(date);
//         dishDetails.setUpdated(date);

//         detailsRepository.save(dishDetails);
//         dishRepository.save(dish);

//         Dish dish2 = dishRepository.findById(dish.getId()).orElse(null);
//         DishDetails dishDetails2 = detailsRepository.findById(dishDetails.getId()).orElse(null);

//         dish2.setDishDetails((dishDetails));
//         dishDetails2.setDish(dish);

//         detailsRepository.save(dishDetails);

//         return dishRepository.save(dish2);
//     }

//     @Override
//     public Dish update(Dish dish) {
//         dish.setUpdated(new Date());
//         return dishRepository.save(dish);
//     }

//     @Override
//     public Dish findByName(String name) {
//         return dishRepository.findByName(name);
//     }

//     @Override
//     public Dish findById(UUID id) {
//         return dishRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<Dish> getAll() {
//         return dishRepository.findAll();
//     }

//     @Override
//     public void deleteById(UUID id) {
//         dishRepository.deleteById(id);
//     }

//     public Dish getItem(DishExtended extended) {
//         Dish dish = null;
//         if (extended.getId() != null) {
//             dish = findById(UUID.fromString(extended.getId()));
//         } else {
//             dish = findByName(itemBodyV2.getName());
//         }
//         return item;
//     }

//     public Dish setDish(Dish dish, DishExtended extended) {
//         if (dish == null) {
//             return null;
//         }

//         UUID id = UUID.fromString(extended.getId());

//         String name = extended.getName();
        
//         List<Category> categories = categoryRepository.findByName(extended.getCategoty());

//         Brand brand = brandRepository.findByName(itemBodyV2.getBrand());

//         if (id != null) {
//             item.setId(id);
//         }
//         if (name != null) {
//             item.setName(name);
//         }
//         if (category != null) {
//             item.setCategory(category);
//         }
//         if (brand != null) {
//             item.setBrand(brand);
//         }
//         return item;
//     }
// }