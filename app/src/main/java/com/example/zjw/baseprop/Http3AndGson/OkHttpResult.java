package com.example.zjw.baseprop.Http3AndGson;

//网络连接接口
public interface OkHttpResult {

    //连接成功

    public void linkSuccess(Object object, int type);

    //链接失败

    public void linkFailure(String request, int type);
}
