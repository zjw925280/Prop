package com.example.zjw.baseprop.Gidle;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zjw.baseprop.R;

import java.io.File;

/**
 * Created by Xu on 2016/5/16.
 * 方便替换图片加载框架
 */
public abstract class BaseImageLoaderProvider {
    public abstract void loadImage(Context ctx, ImageLoader img);

    public static void displayImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .fitCenter()
                .crossFade()//淡入淡出
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }

    //加载网络图片并设置大小
    public abstract void displayImage(Context context, String url, ImageView imageView, int width, int height);

    /**
     * 加载sd卡图片
     */
    public abstract void displayImage(Context context, File file, ImageView imageView);

    /**
     * 加载SD卡图片并设置大小
     */
    public abstract void displayImage(Context context, File file, ImageView imageView, int width, int height);

    /**
     * 加载drawable图片
     */
    public abstract void displayImage(Context context, int resId, ImageView imageView);

    /**
     * 加载drawable图片并设置大小
     */
    public abstract void displayImage(Context context, int resId, ImageView imageView, int width, int height);

}
