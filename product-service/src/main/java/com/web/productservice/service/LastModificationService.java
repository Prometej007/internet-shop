package com.web.productservice.service;


import com.web.productservice.model.utils.pattern.LastModification;

public interface LastModificationService<T extends LastModification<T>> {

    T lastModification(LastModification<T> lastModification);

    T setLastModification(LastModification<T> lastModification);
}
