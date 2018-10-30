package com.web.resourceserver.controller;

import com.web.resourceserver.model.Image;
import com.web.resourceserver.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping("/create")
    private ResponseEntity<String> create(@RequestBody Image image) {
        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.create(image).getPath());
    }

    @PostMapping("/update")
    private ResponseEntity<String> update(@RequestBody Image image) {
        return ResponseEntity.status(HttpStatus.OK).body(imageService.update(image).getPath());
    }

    @GetMapping("/{path}")
    private ResponseEntity<String> findByPath(WebRequest webRequest, @PathVariable String path) {
        Timestamp imageDto = imageService.findLastMod(path);
        if (webRequest.checkNotModified(imageDto.getTime())) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).lastModified(imageDto.getTime()).body(imageService.findByPath(path).getPath());
    }


}
