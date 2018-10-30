package com.web.productservice.model;

import com.web.productservice.model.utils.pattern.DateCreate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Materials extends DateCreate<Materials> {
    @OneToOne
    private Dictionary name;
    @OneToOne
    private Dictionary description;
    private String image;

    public Dictionary getName() {
        return name;
    }

    public Materials setName(Dictionary name) {
        this.name = name;
        return this;
    }

    public Dictionary getDescription() {
        return description;
    }

    public Materials setDescription(Dictionary description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Materials setImage(String image) {
        this.image = image;
        return this;
    }
}
