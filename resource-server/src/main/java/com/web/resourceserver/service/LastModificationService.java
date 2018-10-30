package com.web.resourceserver.service;


import com.web.resourceserver.model.utils.pattern.LastModification;

public interface LastModificationService<T extends LastModification<T>> {

    T lastModification(LastModification<T> lastModification);

    T setLastModification(LastModification<T> lastModification);
}
