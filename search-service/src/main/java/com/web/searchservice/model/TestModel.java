package com.web.searchservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "test_model", type = "test_model")
public class TestModel {
    @Id
    @Field(type = FieldType.Long)
    private Long id;
    @Field(type = FieldType.Text)
    private String name;

    public Long getId() {
        return id;
    }

    public TestModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestModel setName(String name) {
        this.name = name;
        return this;
    }
}
