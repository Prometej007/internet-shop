package com.web.productservice.model.utils.parser;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class DateSerializer extends JsonSerializer<Timestamp> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd MMM yyyy");

    @Override
    public void serialize(Timestamp timestamp, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(timestamp.toLocalDateTime()!=null?timestamp.toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME):"null");
    }
}
