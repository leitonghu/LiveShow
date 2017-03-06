package com.xihoo.liveshow.comm.util;

import com.xihoo.liveshow.comm.constant.SpConstant;

/**
 * 缓存工具
 * Created by leitonghu on 17/2/25.
 */

public class CacheUtil {

    public static void setUserLoginStatus(boolean isLogin){
        SharedPreUtil.putBoolean(SpConstant.KEY_LOGIN_STATUS,isLogin);
    }

    public static boolean isUserLogin(){
        return SharedPreUtil.getBoolean(SpConstant.KEY_LOGIN_STATUS);
    }

    public static void saveUid(Long uid){
        SharedPreUtil.putLong(SpConstant.KEY_LOGIN_UID,uid);
    }

    public static void saveToken(String token){
        SharedPreUtil.putString(SpConstant.KEY_LOGIN_ACCESS_TOKEN,token);
    }

    public static long getUid(){
        return SharedPreUtil.getLong(SpConstant.KEY_LOGIN_UID);
    }

    public static String getAccessToken(){
        return SharedPreUtil.getString(SpConstant.KEY_LOGIN_ACCESS_TOKEN,"");
    }
}
