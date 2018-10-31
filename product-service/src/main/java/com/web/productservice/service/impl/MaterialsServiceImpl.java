package com.web.productservice.service.impl;

import com.web.productservice.model.Materials;
import com.web.productservice.model.utils.pattern.LastModification;
import com.web.productservice.repository.MaterialsRepository;
import com.web.productservice.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaterialsServiceImpl implements MaterialsService {

    @Autowired
    private MaterialsRepository materialsRepository;

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Materials create(Materials materials) {
        return save(setLastModification(materials));
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Materials save(Materials materials) {
        return materialsRepository.save(materials);
    }

    @Override
    public Materials findOne(Materials materials) {
        return findOne(materials.getId());
    }

    @Override
    public Materials findOne(Long id) {
        return materialsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Materials> findAll() {
        return materialsRepository.findAll();
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Materials update(Materials materials) {
        return save(setLastModification(materials));
    }

    @Override
    public Materials lastModification(LastModification<Materials> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

    @Override
    public Materials setLastModification(LastModification<Materials> lastModification) {
        return lastModification.setLastModified(Timestamp.valueOf(LocalDateTime.now()));
    }

}
