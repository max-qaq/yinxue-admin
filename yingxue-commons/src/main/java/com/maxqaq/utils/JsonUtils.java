package com.maxqaq.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @program: yinxue-admin
 * @description:
 * @author: max-qaq
 * @create: 2022-07-29 15:19
 **/

public class JsonUtils {
    private static final ObjectMapper jsonMapper = new ObjectMapper();

    public static String getJson(Object o) {
        try {
            return jsonMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
