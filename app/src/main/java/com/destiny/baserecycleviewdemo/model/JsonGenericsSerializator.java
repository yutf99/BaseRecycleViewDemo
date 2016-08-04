package com.destiny.baserecycleviewdemo.model;


import com.destiny.baserecycleviewdemo.okhttp.callback.IGenericsSerializator;
import com.google.gson.Gson;

/**
 * json转换类
 */
public class JsonGenericsSerializator implements IGenericsSerializator {
    Gson mGson = new Gson();
    @Override
    public <T> T transform(String response, Class<T> classOfT) {
        return mGson.fromJson(response, classOfT);
    }
}
