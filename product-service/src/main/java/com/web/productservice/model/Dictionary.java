package com.web.productservice.model;

import com.web.productservice.model.utils.pattern.LastModification;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dictionary  extends LastModification<Dictionary> {
    @Column(columnDefinition = "TEXT")
    private String valueEn;
    @Column(columnDefinition = "TEXT")
    private String valueRu;
    @Column(columnDefinition = "TEXT")
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
