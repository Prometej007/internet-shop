package com.web.productservice.dto;

import com.web.productservice.model.Category;
import com.web.productservice.model.Dictionary;
import com.web.productservice.model.Materials;
import com.web.productservice.model.Product;
import com.web.productservice.model.enums.SoftnessType;
import com.web.productservice.model.utils.pattern.DateCreate;

import javax.persistence.*;
import java.util.List;

public class ProductDto extends DateCreate<Product> {

    private Image image;

    private Dictionary name;
    private Dictionary description;
    private Category category;
    private List<SoftnessType> softness;
    private List<Materials> materials;

    private Double height;
    private Double weight;
    private Double length;


    private Boolean canBuy;
    private Boolean news;

    public Image getImage() {
        return image;
    }

    public ProductDto setImage(Image image) {
        this.image = image;
        return this;
    }

    public Dictionary getName() {
        return name;
    }

    public ProductDto setName(Dictionary name) {
        this.name = name;
        return this;
    }

    public Dictionary getDescription() {
        return description;
    }

    public ProductDto setDescription(Dictionary description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ProductDto setCategory(Category category) {
        this.category = category;
        return this;
    }

    public List<SoftnessType> getSoftness() {
        return softness;
    }

    public ProductDto setSoftness(List<SoftnessType> softness) {
        this.softness = softness;
        return this;
    }

    public List<Materials> getMaterials() {
        return materials;
    }

    public ProductDto setMaterials(List<Materials> materials) {
        this.materials = materials;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public ProductDto setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public ProductDto setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public ProductDto setLength(Double length) {
        this.length = length;
        return this;
    }

    public Boolean getCanBuy() {
        return canBuy;
    }

    public ProductDto setCanBuy(Boolean canBuy) {
        this.canBuy = canBuy;
        return this;
    }

    public Boolean getNews() {
        return news;
    }

    public ProductDto setNews(Boolean news) {
        this.news = news;
        return this;
    }
}
