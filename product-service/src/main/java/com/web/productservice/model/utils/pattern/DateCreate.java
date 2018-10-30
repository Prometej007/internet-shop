package com.web.productservice.model.utils.pattern;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.web.productservice.model.utils.parser.DateDeserializer;
import com.web.productservice.model.utils.parser.DateSerializer;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class DateCreate<T extends DateCreate> extends Available<T> {

    protected Timestamp dateCreate;


    @JsonSerialize(using = DateSerializer.class)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    @JsonDeserialize(using = DateDeserializer.class)
    public T setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
        return (T) this;
    }
}
