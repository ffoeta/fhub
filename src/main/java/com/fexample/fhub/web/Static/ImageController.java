package com.fexample.fhub.web.Static;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fexample.fhub.dao.model.classes.Static.Image;
import com.fexample.fhub.facade.interfaces.service.Static.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping("id")
    public ResponseEntity<Object> AddNewRole(@RequestParam UUID id) throws RuntimeException {
        Map<Object, Object> response = new HashMap<>();

        Image image = this.imageService.findById(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }
}