package com.web.productservice.service;


import com.web.productservice.model.Image;

public interface GeneratorService {

    Image generatePath(Image image);
    String generatePath();

}
