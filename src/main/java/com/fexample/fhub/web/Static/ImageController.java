package com.fexample.fhub.web.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fexample.fhub.dao.dto.Static.ImageDto;
import com.fexample.fhub.facade.interfaces.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

    @Autowired
    RoleService roleService;

    @GetMapping("name")
    public ResponseEntity<InputStreamResource> AddNewRole(@RequestParam String name) throws IOException {
        Map<Object, Object> response = new HashMap<>();

        ClassPathResource imgFile = new ClassPathResource("image/" + name + ".jpg");

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

    @PostMapping("add")
    public ResponseEntity<Map<Object, Object>> AddNewImage(@RequestBody ImageDto imageDto){
        Map<Object, Object> response = new HashMap<>();

        response.put("message", "image plug saved");

        return ResponseEntity.ok()
                .body(response);
    }


}