package com.web.orderservice.model.utils.pattern;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Available<T extends Available> extends LastModification<T> {

    protected Boolean available;

    public Boolean getAvailable() {
        return available;
    }

    public T setAvailable(Boolean available) {
        this.available = available;
        return (T) this;
    }
}
