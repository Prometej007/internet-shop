package com.web.productservice.dto;

import com.web.productservice.model.Dictionary;

import javax.persistence.Column;
import javax.persistence.OneToOne;

public class Image {

    private String path;
    private String content;
    private Dictionary alt;
    private Dictionary title;

    public String getPath() {
        return path;
    }

    public Image setPath(String path) {
        this.path = path;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Image setContent(String content) {
        this.content = content;
        return this;
    }

    public Dictionary getAlt() {
        return alt;
    }

    public Image setAlt(Dictionary alt) {
        this.alt = alt;
        return this;
    }

    public Dictionary getTitle() {
        return title;
    }

    public Image setTitle(Dictionary title) {
        this.title = title;
        return this;
    }
}
