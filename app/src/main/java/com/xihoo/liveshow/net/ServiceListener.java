package com.xihoo.liveshow.net;

import com.xihoo.liveshow.comm.constant.Operation;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 网络请求返回监听
 * Created by leitonghu on 17/2/24.
 */

public interface ServiceListener {


    /**
     * 执行成功
     * @param returnObj
     * @param operation
     * @param response
     */
    void onSuccess(Object returnObj,Response response, Operation operation);


    /**
     * 请求失败
     * @param operation
     * @param response
     * @param e
     */
    void onError(Response response, Exception e, Operation operation);


}
