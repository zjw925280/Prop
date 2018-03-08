package com.example.zjw.baseprop.Http3AndGson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonImpl extends JsonTModel {


    //    Gson解析
    private Gson gson = new Gson();

    public String toJson(Object src) {
        return gson.toJson(src);
    }

    public <T> T toObject(String json, Class<T> claxx) {
        return gson.fromJson(json, claxx);
    }

    public <T> T toObject(byte[] bytes, Class<T> claxx) {
        return gson.fromJson(new String(bytes), claxx);
    }

    public <T> List<T> toList(String json, Class<T> claxx) {
        Type type = new TypeToken<ArrayList<T>>() {
        }.getType();
        List<T> list = gson.fromJson(json, type);
        return list;
    }
}
