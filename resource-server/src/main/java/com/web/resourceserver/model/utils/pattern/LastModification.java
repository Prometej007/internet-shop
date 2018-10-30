package com.web.resourceserver.model.utils.pattern;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.web.resourceserver.model.utils.parser.DateDeserializer;
import com.web.resourceserver.model.utils.parser.DateSerializer;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @author Prometej
 */
@MappedSuperclass
public abstract class LastModification<T extends LastModification> extends ModelId<T> {
    protected Timestamp lastModified;

    public LastModification() {
    }

    public LastModification(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public LastModification(Timestamp lastModified, Long id) {
        super(id);
        this.lastModified = lastModified;
    }

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
