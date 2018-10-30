package com.web.resourceserver.service.impl;

import com.web.resourceserver.dto.ImageDto;
import com.web.resourceserver.model.Image;
import com.web.resourceserver.model.utils.pattern.LastModification;
import com.web.resourceserver.repository.ImageRepository;
import com.web.resourceserver.service.DictionaryService;
import com.web.resourceserver.service.GeneratorService;
import com.web.resourceserver.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {


    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private GeneratorService generatorService;

    @Override
    public Timestamp findLastMod(String path) {
        return imageRepository.findDto(path);
    }

    @Override
    public Image findByPath(String path) {
        return imageRepository.findByPath(path);
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Image create(Image image) {
        return save(
                setLastModification(
                        generatorService.generatePath(image)
                                .setTitle(dictionaryService.create(image.getTitle()))
                                .setAlt(dictionaryService.create(image.getAlt()))
                        .setDateCreate(Timestamp.valueOf(LocalDateTime.now()))
                        .setAvailable(true)
                )
        );
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Image save(Image image) {
        return setLastModification(imageRepository.save(image));
    }

    @Override
    public Image findOne(Image image) {
        return findOne(image.getId());
    }

    @Override
    public Image findOne(Long id) {
        return imageRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Image update(Image image) {
        return save(
                setLastModification(image)
                .setTitle(dictionaryService.update(image.getTitle()))
                .setAlt(dictionaryService.update(image.getAlt()))
        );
    }

    @Override
    public Image lastModification(LastModification<Image> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

    @Override
    public Image setLastModification(LastModification<Image> lastModification) {
        return lastModification.setLastModified(Timestamp.valueOf(LocalDateTime.now()));
    }

}
