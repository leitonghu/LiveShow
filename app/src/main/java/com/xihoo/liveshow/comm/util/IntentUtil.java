package com.xihoo.liveshow.comm.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.io.Serializable;

/**
 * 作    者：
 * 版    本：1.0
 * 创建日期：2016/12/1
 * 描    述：IntentUtil 统一跳转
 * 修订历史：
 */
public class IntentUtil {

    public static void setResult(Activity activity,int resultCode,Serializable o){
        Intent intent = new Intent();
//        intent.putExtra(BaseBussConstant.LINSI_CONTENT, o);
        activity.setResult(resultCode, intent);
        activity.finish();
    }
    public static void startActivity(Context context, final Intent intent) {
        if (intent != null)

            context.startActivity(intent);
    }

    public static void startActivityForResult(final Activity activity, final Intent intent, final int requestCode) {
        if (intent != null)
            activity.startActivityForResult(intent, requestCode);
    }


    public static void startFragmentForResult(final Fragment fragment, final Intent intent, final int requestCode) {
        if (intent != null)
            fragment.startActivityForResult(intent, requestCode);
    }

}
