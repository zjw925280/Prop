package com.example.zjw.baseprop.Http3AndGson;

import java.util.List;

public abstract  class JsonTModel {

    private static JsonTModel json;
    JsonTModel() {

    }

    public static JsonTModel get() {
        if (json == null) {
            json = new GsonImpl();
        }
        return json;
    }

    public abstract String toJson(Object src);

    public abstract <T> T toObject(String json, Class<T> claxx);

    public abstract <T> T toObject(byte[] bytes, Class<T> claxx);

    public abstract <T> List<T> toList(String json, Class<T> claxx);

}
