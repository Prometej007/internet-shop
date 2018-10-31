package com.web.productservice.controller;

import com.web.productservice.dto.ProductDto;
import com.web.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/create")
    private ResponseEntity create(@RequestBody ProductDto productDto) {
        productService.create(productDto);
        return ResponseEntity.ok().build();
    }


}
