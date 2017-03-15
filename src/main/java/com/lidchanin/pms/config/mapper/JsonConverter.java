package com.lidchanin.pms.config.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

    public String toJSON(Object object) {
        if (object == null) {
            return "{}";
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{}";
    }
}