package com.web.orderservice.model;

import com.web.orderservice.model.utils.pattern.DateCreate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ItemBin extends DateCreate<ItemBin> {

    private Long productId;
    private Integer count;
    private Double pricePerOne;

    @ManyToOne
    private Bin bin;

    public Long getProductId() {
        return productId;
    }

    public ItemBin setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public ItemBin setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Double getPricePerOne() {
        return pricePerOne;
    }

    public ItemBin setPricePerOne(Double pricePerOne) {
        this.pricePerOne = pricePerOne;
        return this;
    }

    public Bin getBin() {
        return bin;
    }

    public ItemBin setBin(Bin bin) {
        this.bin = bin;
        return this;
    }
}
