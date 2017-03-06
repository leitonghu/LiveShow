package com.xihoo.liveshow.comm.util;

import android.widget.Toast;

import com.xihoo.liveshow.BaseApplication;
import com.xihoo.liveshow.R;


/**
 * 作    者：chenyonglin
 * 版    本：1.0
 * 创建日期：2016/10/05
 * 描    述：toast 类
 * 修订历史：
 */
public final class ToastUtil {

    private static Toast toast = null;// 提醒框

    private ToastUtil() {
    }

    public static void showRqBusError() {
        toastShow("错误", Toast.LENGTH_SHORT);
    }

    public static void showNodata() {
        shortShow(BaseApplication.context().getString(R.string.no_more_data));
    }

    public static void shortShow(CharSequence cs) {
        toastShow(cs, Toast.LENGTH_SHORT);
    }

    public static void longShow(CharSequence cs) {
        toastShow(cs, Toast.LENGTH_LONG);
    }

    private static void toastShow(CharSequence cs, int duration) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.context(), cs, duration);
        } else {
            toast.setText(cs);
        }
        toast.setDuration(duration);
        toast.show();
    }

    /**
     * 弹出Toast,在屏幕中间显示
     *
     * @param resId
     */

    public static final void toastInCenter(String resId) {
        shortShow(resId);
    }

     /**
        *网络连接失败提示
        *
        * @param
        * @return
        */
    public static void errorShow() {
        toastShow(BaseApplication.resources().getString(R.string.net_err), Toast.LENGTH_SHORT);
    }
}
