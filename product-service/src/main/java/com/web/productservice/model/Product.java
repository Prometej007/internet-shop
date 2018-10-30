package com.web.productservice.model;

import com.web.productservice.model.enums.SoftnessType;
import com.web.productservice.model.utils.pattern.DateCreate;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product extends DateCreate<Product> {

    @OneToOne
    private Dictionary name;
    @OneToOne
    private Dictionary description;
    @ManyToOne
    private Category category;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<SoftnessType> softness;
    @ManyToMany
    private List<Materials> materials;

    private Double height;
    private Double weight;
    private Double length;


    private Boolean canBuy;
    private Boolean news;

    public Dictionary getName() {
        return name;
    }

    public Product setName(Dictionary name) {
        this.name = name;
        return this;
    }

    public Dictionary getDescription() {
        return description;
    }

    public Product setDescription(Dictionary description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public List<SoftnessType> getSoftness() {
        return softness;
    }

    public Product setSoftness(List<SoftnessType> softness) {
        this.softness = softness;
        return this;
    }

    public List<Materials> getMaterials() {
        return materials;
    }

    public Product setMaterials(List<Materials> materials) {
        this.materials = materials;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public Product setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public Product setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public Product setLength(Double length) {
        this.length = length;
        return this;
    }

    public Boolean getCanBuy() {
        return canBuy;
    }

    public Product setCanBuy(Boolean canBuy) {
        this.canBuy = canBuy;
        return this;
    }

    public Boolean getNews() {
        return news;
    }

    public Product setNews(Boolean news) {
        this.news = news;
        return this;
    }
}
