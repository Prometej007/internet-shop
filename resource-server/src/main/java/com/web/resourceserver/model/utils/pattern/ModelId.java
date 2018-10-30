package com.web.resourceserver.model.utils.pattern;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ModelId<T extends ModelId> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public ModelId() {

    }

    public ModelId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }
}
