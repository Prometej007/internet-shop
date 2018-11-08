package com.web.productservice.controller;

import com.web.productservice.model.Category;
import com.web.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/create")
    private ResponseEntity create(@RequestBody Category categoryDto) {
        categoryService.create(categoryDto);
        return ResponseEntity.ok().build();
    }

}
