package com.example.zjw.baseprop.Http3AndGson;

import android.util.Log;

import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2018/1/26.
 */

public class MyStringCallback extends StringCallback {
    //MyStringCallback用于向json server处理有关字符串的请求（Json/Http/Https 字符串callback）

    @Override
    public void onError(Call call, Exception e, int id) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(String response, int id) {
        String string = response.toString();
        Log.e("string", "string==" + string);
    }

}
