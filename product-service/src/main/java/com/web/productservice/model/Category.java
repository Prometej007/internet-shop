package com.web.productservice.model;

import com.web.productservice.model.utils.pattern.DateCreate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Category extends DateCreate<Category> {


    private String image;
    @Column(name = "_order")
    private Integer order;
    @OneToOne
    private Dictionary name;
    @OneToOne
    private Dictionary description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public String getImage() {
        return image;
    }

    public Category setImage(String image) {
        this.image = image;
        return this;
    }

    public Integer getOrder() {
        return order;
    }

    public Category setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public Dictionary getName() {
        return name;
    }

    public Category setName(Dictionary name) {
        this.name = name;
        return this;
    }

    public Dictionary getDescription() {
        return description;
    }

    public Category setDescription(Dictionary description) {
        this.description = description;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Category setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
