package com.web.resourceserver.service;

import com.web.resourceserver.dto.ImageDto;
import com.web.resourceserver.model.Image;

import java.sql.Timestamp;

public interface ImageService extends GrudOperations<Image>{

    Timestamp findLastMod(String path);

    Image findByPath(String path);

}
