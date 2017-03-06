package com.xihoo.liveshow.model;


import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.xihoo.liveshow.comm.config.ServiceURL;
import com.xihoo.liveshow.comm.constant.Operation;
import com.xihoo.liveshow.comm.util.CacheUtil;
import com.xihoo.liveshow.net.HttpUtils;
import com.xihoo.liveshow.net.ServiceListener;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 账号相关
 * Created by leitonghu on 17/2/23.
 */

public class AccountServer {


    public static String REGISTER = "user/register";
    public static String LOGIN = "user/login";
    public static String VISITOR_LOGIN = "user/visitor";
    public static String LOGOUT = "user/loginOut";

    public AccountServer(){

    }

    public static AccountServer getInstance(){
        return new AccountServer();
    }



    public void toRegister(String username, String pwd, final ServiceListener serviceListener, final Operation operation){
        String url = ServiceURL.SERVICEURL + REGISTER;
        HttpParams httpParams = new HttpParams();
        httpParams.put("username",username);
        httpParams.put("password",pwd);
        HttpUtils.getInstance().postRequest(url,httpParams,serviceListener,operation);
    }

    public void toLogin(String username, String pwd, final ServiceListener serviceListener, final Operation operation){
        String url = ServiceURL.SERVICEURL +  LOGIN;
        HttpParams httpParams = new HttpParams();
        httpParams.put("username",username);
        httpParams.put("password",pwd);
        HttpUtils.getInstance().postRequest(url,httpParams,serviceListener,operation);
    }

    public void toVisitorLogin(final ServiceListener serviceListener, final Operation operation){
        String url = ServiceURL.SERVICEURL +  VISITOR_LOGIN;
        HttpParams httpParams = new HttpParams();
        HttpUtils.getInstance().postRequest(url,httpParams,serviceListener,operation);
    }

    public void toLoginOut(final ServiceListener serviceListener, final Operation operation){
        String url = ServiceURL.SERVICEURL +  LOGOUT;
        HttpParams httpParams = new HttpParams();
        httpParams.put("uid", CacheUtil.getUid());
        httpParams.put("passtoken",CacheUtil.getAccessToken());
        HttpUtils.getInstance().postRequest(url,httpParams,serviceListener,operation);
    }

}
