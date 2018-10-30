package com.web.resourceserver.service;

import com.web.resourceserver.model.Image;

public interface GeneratorService {

    Image generatePath(Image image);
    String generatePath();

}
