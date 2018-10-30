package com.web.resourceserver.service.impl;

import com.web.resourceserver.model.Image;
import com.web.resourceserver.repository.ImageRepository;
import com.web.resourceserver.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.Optional.ofNullable;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private ImageRepository imageRepository;

    private static String generate(Integer count) {
        String str = (UUID.randomUUID().toString() + UUID.randomUUID().toString()).replace("-", "").replace("-", "").replace("-", "").replace("-", "").replace("-", "").replace("-", "").replace("-", "").replace("-", "");
        if (str.length() < count)
            throw new RuntimeException();
        return str.substring(0, count);
    }

    @Override
    public Image generatePath(Image image) {
        return new Image().setPath(generatePath());
    }

    @Override
    public String generatePath() {
        String path;
        do {
            path = generate(64);
        } while (ofNullable(imageRepository.countByPath(path)).isPresent());
        return path;
    }
}
