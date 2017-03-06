package com.xihoo.liveshow.net;

import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.xihoo.liveshow.comm.constant.Operation;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 网络请求工具类
 * Created by leitonghu on 17/2/25.
 */

public class HttpUtils {

    public HttpUtils(){

    }
    public static HttpUtils getInstance(){
        return new HttpUtils();
    }

    public void postRequest(String url, HttpParams httpParams, final ServiceListener serviceListener, final Operation operation){
        OkGo.post(url)
                .cacheKey("REGISTER")
                .cacheMode(CacheMode.DEFAULT)
                .params(httpParams)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.e("tag",s);
                        serviceListener.onSuccess(s,response ,operation);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        serviceListener.onError(response,e,operation);
                    }
                });
    }
}
