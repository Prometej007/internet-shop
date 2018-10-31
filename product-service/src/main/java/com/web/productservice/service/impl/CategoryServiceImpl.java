package com.web.productservice.service.impl;

import com.web.productservice.model.Category;
import com.web.productservice.model.utils.pattern.LastModification;
import com.web.productservice.repository.CategoryRepository;
import com.web.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Category create(Category category) {
        return save(setLastModification(category));
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findOne(Category category) {
        return findOne(category.getId());
    }

    @Override
    public Category findOne(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Category update(Category category) {
        return save(setLastModification(category));
    }

    @Override
    public Category lastModification(LastModification<Category> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

    @Override
    public Category setLastModification(LastModification<Category> lastModification) {
        return lastModification.setLastModified(Timestamp.valueOf(LocalDateTime.now()));
    }

}
