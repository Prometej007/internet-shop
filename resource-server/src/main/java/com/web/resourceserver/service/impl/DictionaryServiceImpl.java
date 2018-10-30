package com.web.resourceserver.service.impl;

import com.web.resourceserver.model.Dictionary;
import com.web.resourceserver.model.utils.pattern.LastModification;
import com.web.resourceserver.repository.DictionaryRepository;
import com.web.resourceserver.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Dictionary create(Dictionary dictionary) {
        return save(setLastModification(dictionary));
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Dictionary save(Dictionary dictionary) {
        return dictionaryRepository.save(setLastModification(dictionary));
    }

    @Override
    public Dictionary findOne(Dictionary dictionary) {
        return findOne(dictionary.getId());
    }

    @Override
    public Dictionary findOne(Long id) {
        return dictionaryRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<Dictionary> findAll() {
        return dictionaryRepository.findAll();
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Dictionary update(Dictionary dictionary) {
        return save(setLastModification(dictionary));
    }

    @Override
    public Dictionary lastModification(LastModification<Dictionary> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

    @Override
    public Dictionary setLastModification(LastModification<Dictionary> lastModification) {
        return lastModification.setLastModified(Timestamp.valueOf(LocalDateTime.now()));
    }

}
