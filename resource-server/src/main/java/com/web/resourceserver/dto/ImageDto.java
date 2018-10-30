package com.web.resourceserver.dto;

import com.web.resourceserver.model.utils.pattern.LastModification;

import java.sql.Timestamp;

public class ImageDto extends LastModification<ImageDto> {

    public ImageDto() {
    }

    public ImageDto(Timestamp timestamp, Long id) {
        super(timestamp, id);
    }

}
