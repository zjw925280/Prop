package com.example.zjw.baseprop.Gidle;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.taoqianke.app.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Xu on 2016/5/16.
 */
public class GlideImageLoaderProvider extends BaseImageLoaderProvider {
    /**
     * 可自定义加载图片
     * 用法
     * ImageLoader imageLoader =new ImageLoader.Builder().url("img url").imgView(mImgView).build();
     * ImageLoaderUtil.getInstance().loadImage(context,imageLoader);
     *
     * @param ctx
     * @param img
     */
    @Override
    public void loadImage(Context ctx, ImageLoader img) {
        loadNormal(ctx, img);
    }

    /**
     * 加载网络图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url).diskCacheStrategy(DiskCacheStrategy.ALL)
//                .fitCenter()
                .crossFade()//淡入淡出
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
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
    @Override
    public void displayImage(Context context, String url, ImageView imageView, int width, int height) {
        Glide.with(context)
                .load(url)
                .fitCenter()
                .override(width, height)
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载SD卡图片
     *
     * @param context
     * @param file
     * @param imageView
     */
    @Override
    public void displayImage(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .fitCenter()
                .into(imageView);
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
    @Override
    public void displayImage(Context context, File file, ImageView imageView, int width, int height) {
        Glide.with(context)
                .load(file)
                .override(width, height)
                .fitCenter()
                .into(imageView);
    }

    /**
     * 加载drawable图片
     *
     * @param context
     * @param resId
     * @param imageView
     */
    @Override
    public void displayImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .crossFade()
                .into(imageView);
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
    @Override
    public void displayImage(Context context, int resId, ImageView imageView, int width, int height) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .override(width, height)
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载网络图片显示为圆形图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayCricleImage(Context context, String url, ImageView imageView) {

            Glide.with(context)
                    .load(url)
                    .transform(new GlideCircleTransform(context))
                    .crossFade()
                    .placeholder(R.mipmap.img_login_head_portrait1)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
    }

    public static void displayCricleImage(Context context, String url, ImageView imageView, int defaultImage) {
        Glide.with(context)
                .load(url)
                .transform(new GlideCircleTransform(context))
                .placeholder(R.mipmap.img_login_head_portrait1)
                .into(imageView);
    }

    /**
     * 加载SD卡图片显示为圆形图片
     *
     * @param context
     * @param file
     * @param imageView
     */
    public static void displayCricleImage(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                //.centerCrop()
                .transform(new GlideCircleTransform(context))
                .into(imageView);

    }

    /**
     * 加载drawable图片显示为圆形图片
     *
     * @param context
     * @param resId
     * @param imageView
     */
    public void displayCricleImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    //将资源ID转为Uri
    public Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    /**
     * load image with Glide
     */
    private void loadNormal(Context ctx, ImageLoader img) {
        Glide.with(ctx).load(img.getUrl())
                .crossFade()
                .placeholder(img.getPlaceHolder())
                .into(img.getImgView());
    }


    /**
     * load cache image with Glide
     */
    private void loadCache(Context ctx, ImageLoader img) {
        Glide.with(ctx).using(new StreamModelLoader<String>() {
            @Override
            public DataFetcher<InputStream> getResourceFetcher(final String model, int i, int i1) {
                return new DataFetcher<InputStream>() {
                    @Override
                    public InputStream loadData(Priority priority) throws Exception {
                        throw new IOException();
                    }

                    @Override
                    public void cleanup() {

                    }

                    @Override
                    public String getId() {
                        return model;
                    }

                    @Override
                    public void cancel() {

                    }
                };
            }
        }).load(img.getUrl()).placeholder(img.getPlaceHolder()).diskCacheStrategy(DiskCacheStrategy.ALL).into(img.getImgView());
    }


}