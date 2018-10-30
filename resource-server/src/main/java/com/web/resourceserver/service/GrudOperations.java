package com.web.resourceserver.service;


import com.web.resourceserver.model.utils.pattern.LastModification;

import java.util.List;

public interface GrudOperations<T extends LastModification<T>> extends LastModificationService<T> {

    T create(T t);

    T save(T t);

    T findOne(T t);

    T findOne(Long id);

    List<T> findAll();

    T update(T t);

}
