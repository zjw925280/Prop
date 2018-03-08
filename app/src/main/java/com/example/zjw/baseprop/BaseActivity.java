package com.example.zjw.baseprop;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.zjw.baseprop.Http3AndGson.OkHttpResult;
import com.example.zjw.baseprop.Http3AndGson.OkHttpUtlis;

public class BaseActivity extends Activity {


    private static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    //okhttp请求调用
    public static void requestOKHttpData(String url, OkHttpResult context, Class cass, int tepy) {
        OkHttpUtlis okHttpUtlis = new OkHttpUtlis();
        okHttpUtlis.setResult((OkHttpResult) context, cass, tepy);
        okHttpUtlis.getRequest(url);
        Log.e("url","url=="+url);
    }

    /**
     * 显示Toast 文本资源
     */
    public static final void showToast(String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    //父布局实例化控件
    @SuppressWarnings("unchecked")
    protected final <T extends View> T getView(int rid) {
        return (T) findViewById(rid);
    }

    //子布局实例化控件
    @SuppressWarnings("unchecked")
    protected final <T extends View> T getView(View view, int rid) {
        return (T) view.findViewById(rid);
    }

//掩藏软键盘

    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }


}
