// package com.fexample.fhub.web;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import com.fexample.fhub.dao.model.classes.Dish;
// import com.fexample.fhub.facade.interfaces.service.DishService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping(value = "/api/dish")
// public class DishController {
    
//     @Autowired
//     private DishService service;

//     @GetMapping("find")
//     public ResponseEntity<Map<Object, Object>> FindAllDishes(){

//         List<Dish> dishes = service.findAll();

//         Map<Object, Object> response = new HashMap<>();

//         response.put("count", dishes.size());
//         response.put("items", dishes);

//         return ResponseEntity.ok(response);
//     }
// }