package com.web.orderservice.model;

import com.web.orderservice.model.enums.BinStatusEnum;
import com.web.orderservice.model.utils.pattern.DateCreate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class BinStatus extends DateCreate<BinStatus> {
    @Enumerated(EnumType.STRING)
    private BinStatusEnum status;
    @ManyToOne
    private Bin bin;

    public BinStatusEnum getStatus() {
        return status;
    }

    public BinStatus setStatus(BinStatusEnum status) {
        this.status = status;
        return this;
    }

    public Bin getBin() {
        return bin;
    }

    public BinStatus setBin(Bin bin) {
        this.bin = bin;
        return this;
    }
}
