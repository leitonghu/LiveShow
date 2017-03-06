package com.xihoo.liveshow.comm.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.xihoo.liveshow.BaseApplication;
import com.xihoo.liveshow.R;

import java.io.File;



//// TODO: 2016/11/29  如果是 CircleImageView会有bug，因此http://blog.csdn.net/jeffleo/article/details/52097151

public class GlideImageLoaderUtil {


    public static void displayImage(Context context, String path, final ImageView imageView) {
        Glide.with(context).load(path)
                .error(R.mipmap.comm_pictures_no)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .fitCenter()
                .into(imageView);
    }


    /**
     * 加载uri 和 网络图片
     *
     * @param activity
     * @param path
     * @param imageView
     */
    public static void displayDefalutImage(Activity activity, String path, ImageView imageView) {
        Glide.with(activity).load(path)
                .placeholder(R.mipmap.comm_pictures_no)//
                .error(R.mipmap.comm_pictures_no)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    public static void displayDefalutImage(Fragment fragment, String path, ImageView imageView) {
        Glide.with(fragment).load(path)
                .placeholder(R.mipmap.comm_pictures_no)//
                .error(R.mipmap.comm_pictures_no)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    public static void displayDefalutImage(Context context, String path, ImageView imageView) {
        Glide.with(context).load(path)
                .placeholder(R.mipmap.comm_pictures_no)//
                .error(R.mipmap.comm_pictures_no)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    //// TODO: 2016/11/29  如果是 CircleImageView会有bug，因此http://blog.csdn.net/jeffleo/article/details/52097151
    public static void displayUserImage(Activity activity, String path, final ImageView imageView) {
        Glide.with(activity).load(path)
            //    .placeholder(R.mipmap.comm_user_default_icon)//CircleImageView 会有bug
                .error(R.mipmap.comm_user_default_icon)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    public static void displayUserImage(Context context, String path, final ImageView imageView) {
        Glide.with(context).load(path).asBitmap().centerCrop()
               .placeholder(R.mipmap.comm_user_default_icon)//CircleImageView 会有bug
                .error(R.mipmap.comm_user_default_icon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(BaseApplication.resources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 加载消息图片
     *
     * @param context
     * @param path
     * @param imageView
     */
    public static void displayMsgImage(Context context, String path, final ImageView imageView) {
        Glide.with(context).load(path)
                .error(R.mipmap.comm_pictures_no)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .override(300,300)
                .fitCenter()
                .into(imageView);
    }

    /**
     * 加载消息图片
     *
     * @param context
     * @param path
     * @param target
     */
    public static void displayMsgImage(Context context, String path, GlideDrawableImageViewTarget target) {
        Glide.with(context).load(path)
                .error(R.mipmap.comm_pictures_no)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .override(300,300)
                .fitCenter()
                .into(target);
    }

    /**
     * 加载本地图片
     *
     * @param context
     * @param filePath
     * @param imageView
     */
    public static void displayDefalutImage(Context context, File filePath, ImageView imageView) {
        Glide.with(context).load(filePath)
                .placeholder(R.mipmap.comm_pictures_no)//
                .error(R.mipmap.comm_pictures_no)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    public static void displayDefalutImage(Activity activity, File filePath, ImageView imageView) {
        Glide.with(activity).load(filePath)
                .placeholder(R.mipmap.comm_pictures_no)//
                .error(R.mipmap.comm_pictures_no)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    /**
     * 加载app res 文件
     *
     * @param context
     * @param resId
     * @param imageView
     */
    public static void displayDefalutImage(Context context, int resId, ImageView imageView) {
        Glide.with(context).load(resId)
                .placeholder(R.mipmap.comm_pictures_no)//
                .error(R.mipmap.comm_pictures_no)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    public static void displayDefalutImage(Activity activity, int resId, ImageView imageView) {
        Glide.with(activity).load(resId)
                .placeholder(R.mipmap.comm_pictures_no)//
                .error(R.mipmap.comm_pictures_no)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    public static void displayDefalutImageNoplac(Activity activity, int resId, ImageView imageView) {
        Glide.with(activity).load(resId)
                .error(R.mipmap.comm_pictures_no)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

}
