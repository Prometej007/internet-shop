package com.web.resourceserver.model;

import com.web.resourceserver.model.utils.pattern.LastModification;

import javax.persistence.Entity;

@Entity
public class Dictionary extends LastModification<Dictionary> {
    private String valueEn;
    private String valueRu;
    private String valueUa;

    public String getValueEn() {
        return valueEn;
    }

    public Dictionary setValueEn(String valueEn) {
        this.valueEn = valueEn;
        return this;
    }

    public String getValueRu() {
        return valueRu;
    }

    public Dictionary setValueRu(String valueRu) {
        this.valueRu = valueRu;
        return this;
    }

    public String getValueUa() {
        return valueUa;
    }

    public Dictionary setValueUa(String valueUa) {
        this.valueUa = valueUa;
        return this;
    }
}
