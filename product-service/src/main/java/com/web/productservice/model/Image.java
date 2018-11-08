package com.web.productservice.model;


import com.web.productservice.model.utils.pattern.DateCreate;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "id"), @Index(columnList = "path")})
public class Image extends DateCreate<Image> {
    private String path;
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @OneToOne
    private Dictionary alt;
    @OneToOne
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
