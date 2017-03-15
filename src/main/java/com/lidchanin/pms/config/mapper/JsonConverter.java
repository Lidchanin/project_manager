package com.lidchanin.pms.config.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class <code>JsonConverter</code> convert Object in the String.
 * This class works with the help of the library Jackson.
 */
public class JsonConverter {

    /**
     * Method <code>toJSON</code> translate object to String with
     * the help of the <code>ObjectMapper</code>.
     * @see ObjectMapper
     * @param object witch need to convert.
     * @return converted Object in the String.
     */
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