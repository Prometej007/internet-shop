package com.web.productservice.service;


import com.web.productservice.model.Image;

import java.sql.Timestamp;

public interface ImageService extends GrudOperations<Image>{

    Timestamp findLastMod(String path);

    Image findByPath(String path);

}
