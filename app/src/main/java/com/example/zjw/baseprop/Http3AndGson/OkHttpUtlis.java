package com.example.zjw.baseprop.Http3AndGson;

import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;

import okhttp3.Call;

public class OkHttpUtlis<T> {
    private OkHttpResult result;
    private int type;
    private Class<T> claxx;

//创建一个set方法接受请求结果

    public void setResult(OkHttpResult result, Class<T> claxx, int type) {

        this.result = result;
        this.type = type;
        this.claxx = claxx;
    }


//    创建get请求


    public void getRequest(String url) {

        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

                OkHttpUtlis.this.result.linkFailure("网络链接失败", type);
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("aaa", "aaaa====" + response);
                Object obj = GsonImpl.get().toObject(response, claxx);
                Log.e("obj", "obj=" + obj);
                OkHttpUtlis.this.result.linkSuccess(obj, type);
            }
        });
    }

//头像上传
   public void  postRequest(String url, String imagkey, String imagName, File file,String tokenKey,String token){
       OkHttpUtils.post().addFile(imagkey, imagName, file)//
               .url(url)
               .addParams(imagkey, imagName)//
               .addParams(tokenKey, token)
               .build()//
               .execute(new MyStringCallback() {

                   @Override
                   public void onError(Call call, Exception e, int id) {
                       OkHttpUtlis.this.result.linkFailure("", type);
                       e.printStackTrace();
                   }

                   @Override
                   public void onResponse(String response, int id) {
                       Log.e("aaa", "aaaa====" + response);
//                       Object obj = GsonImpl.get().toObject(response, claxx);
//                       Log.e("obj", "obj=" + obj);
                       OkHttpUtlis.this.result.linkSuccess(response, type);
                   }
               }
    );

}

}
