package com.example.zjw.baseprop.Gidle;

import android.content.Context;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Xu on 2016/5/16.
 */
public class ImageLoaderUtil {
    public static final int PIC_LARGE = 0;
    public static final int PIC_MEDIUM = 1;
    public static final int PIC_SMALL = 2;

    public static final int LOAD_STRATEGY_NORMAL = 0;
    public static final int LOAD_STRATEGY_ONLY_WIFI = 1;

    private static ImageLoaderUtil mInstance;
    private GlideImageLoaderProvider mProvider;

    private ImageLoaderUtil() {
        mProvider = new GlideImageLoaderProvider();
    }

    //single instance
    public static ImageLoaderUtil getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoaderUtil.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderUtil();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    /**
     * 可自定义加载图片
     * 用法
     * ImageLoader imageLoader =new ImageLoader.Builder().url("img url").imgView(mImgView).build();
     * ImageLoaderUtil.getInstance().loadImage(context,imageLoader);
     *
     * @param context
     * @param img
     */
    public void loadImage(Context context, ImageLoader img) {
        mProvider.loadImage(context, img);
    }

    /**
     * 加载网络图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void displayImage(Context context, String url, ImageView imageView) {
        mProvider.displayImage(context, url, imageView);
    }

    /**
     * 加载网络图片并设置大小
     *
     * @param context
     * @param url
     * @param imageView
     * @param width
     * @param height
     */
    public void displayImage(Context context, String url, ImageView imageView, int width, int height) {
        mProvider.displayImage(context, url, imageView, width, height);
    }

    /**
     * 加载SD卡图片
     *
     * @param context
     * @param file
     * @param imageView
     */
    public void displayImage(Context context, File file, ImageView imageView) {
        mProvider.displayImage(context, file, imageView);
    }

    /**
     * 加载SD卡图片并设置大小
     *
     * @param context
     * @param file
     * @param imageView
     * @param width
     * @param height
     */
    public void displayImage(Context context, File file, ImageView imageView, int width, int height) {
        mProvider.displayImage(context, file, imageView, width, height);
    }

    /**
     * 加载drawable图片
     *
     * @param context
     * @param resId
     * @param imageView
     */
    public void displayImage(Context context, int resId, ImageView imageView) {
        mProvider.displayImage(context, resId, imageView);
    }

    /**
     * 加载drawable图片并设置大小
     *
     * @param context
     * @param resId
     * @param imageView
     * @param width
     * @param height
     */
    public void displayImage(Context context, int resId, ImageView imageView, int width, int height) {
        mProvider.displayImage(context, resId, imageView, width, height);
    }

    /**
     * 加载网络图片显示为圆形图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void displayCricleImage(Context context, String url, ImageView imageView) {
        mProvider.displayCricleImage(context, url, imageView);
    }

    public void displayCricleImage(Context context, String url, ImageView imageView, int defaultImage) {
        mProvider.displayCricleImage(context, url, imageView, defaultImage);
    }

    /**
     * 加载SD卡图片显示为圆形图片
     * @param context
     * @param file
     * @param imageView
     */
    public void displayCricleImage(Context context, File file, ImageView imageView) {
        mProvider.displayCricleImage(context, file, imageView);
    }

    /**
     * 加载drawable图片显示为圆形图片
     * @param context
     * @param resId
     * @param imageView
     */
    public void displayCricleImage(Context context, int resId, ImageView imageView) {
        mProvider.displayCricleImage(context, resId, imageView);
    }
}
