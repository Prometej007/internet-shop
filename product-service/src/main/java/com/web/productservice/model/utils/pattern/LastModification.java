package com.web.productservice.model.utils.pattern;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.web.productservice.model.utils.parser.DateDeserializer;
import com.web.productservice.model.utils.parser.DateSerializer;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @author Prometej
 */
@MappedSuperclass
public abstract class LastModification<T extends LastModification> extends ModelId<T> {


    protected Timestamp lastModified;

    @JsonSerialize(using = DateSerializer.class)
    public Timestamp getLastModified() {
        return lastModified;
    }

    @JsonDeserialize(using = DateDeserializer.class)
    public T setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
        return (T) this;
    }

}
