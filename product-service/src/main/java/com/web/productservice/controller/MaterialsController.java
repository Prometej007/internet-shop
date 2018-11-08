package com.web.productservice.controller;


import com.web.productservice.model.Materials;
import com.web.productservice.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materials")
public class MaterialsController {


    @Autowired
    private MaterialsService materialsService;

    @PostMapping("/create")
    private ResponseEntity create(@RequestBody Materials materialsDto) {
        materialsService.create(materialsDto);
        return ResponseEntity.ok().build();
    }

}
