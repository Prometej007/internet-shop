package com.web.orderservice.model;

import com.web.orderservice.model.utils.pattern.DateCreate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Bin extends DateCreate<Bin> {
    @Column(name = "_order")
    private String order;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String comment;
    private Double price;

    @OneToMany(mappedBy = "bin")
    private List<ItemBin> itemBins;

    @OneToMany(mappedBy = "bin")
    private List<BinStatus> statuses;

    public String getOrder() {
        return order;
    }

    public Bin setOrder(String order) {
        this.order = order;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Bin setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Bin setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Bin setPrice(Double price) {
        this.price = price;
        return this;
    }

    public List<ItemBin> getItemBins() {
        return itemBins;
    }

    public Bin setItemBins(List<ItemBin> itemBins) {
        this.itemBins = itemBins;
        return this;
    }

    public List<BinStatus> getStatuses() {
        return statuses;
    }

    public Bin setStatuses(List<BinStatus> statuses) {
        this.statuses = statuses;
        return this;
    }
}
