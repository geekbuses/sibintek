package ru.sibintek.test.jsonsstorage.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    private static final TypeReference<Map<String, String>> TYPE_STRMAP = new TypeReference<Map<String, String>>() {
    };

    private JsonUtils() {
    }

    public static Map<String, String> jsonAsStrMap(String json) {
        return fromJson(json, TYPE_STRMAP);
    }


    public static <T> T fromJson(String json, TypeReference<T> typeRef) {
        try {
            return ContextUtil.getBean(ObjectMapper.class).readValue(json, typeRef);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static String toJson(Object obj) {
        try {
            return ContextUtil.getBean(ObjectMapper.class).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка сериализации json");
        }
    }
}
