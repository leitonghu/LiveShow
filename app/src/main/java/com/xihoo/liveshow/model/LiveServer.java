package com.xihoo.liveshow.model;


import com.lzy.okgo.model.HttpParams;
import com.xihoo.liveshow.comm.config.ServiceURL;
import com.xihoo.liveshow.comm.constant.Operation;
import com.xihoo.liveshow.comm.util.CacheUtil;
import com.xihoo.liveshow.net.HttpUtils;
import com.xihoo.liveshow.net.ServiceListener;

/**
 * 直播相关
 * Created by leitonghu on 17/2/23.
 */

public class LiveServer {


    public static String ROOM_LIST = "room/getRoomList";
    public static String ROOM_ENTER = "room/enter";
    public static String ROOM_LEAVE = "room/leave";
    public static String ROOM_CREATE = "room/create";

    public LiveServer(){

    }

    public static LiveServer getInstance(){
        return new LiveServer();
    }


    /**
     * 获取房间列表
     * @param serviceListener
     * @param operation
     */
    public void getRoomList(final ServiceListener serviceListener, final Operation operation){
        String url = ServiceURL.SERVICEURL + ROOM_LIST;
        HttpParams httpParams = new HttpParams();
        HttpUtils.getInstance().postRequest(url,httpParams,serviceListener,operation);
    }

    /**
     * 进入房间
     * @param roomId
     * @param serviceListener
     * @param operation
     */
    public void enterRoom(String roomId,final ServiceListener serviceListener, final Operation operation){
        String url = ServiceURL.SERVICEURL + ROOM_ENTER;
        HttpParams httpParams = new HttpParams();
        httpParams.put("roomId",roomId);
        httpParams.put("uid",CacheUtil.getUid());
        httpParams.put("passtoken",CacheUtil.getAccessToken());
        HttpUtils.getInstance().postRequest(url,httpParams,serviceListener,operation);
    }

    /**
     * 离开房间
     * @param roomId
     * @param serviceListener
     * @param operation
     */
    public void leaveRoom(String roomId,final ServiceListener serviceListener, final Operation operation){
        String url = ServiceURL.SERVICEURL + ROOM_LEAVE;
        HttpParams httpParams = new HttpParams();
        httpParams.put("uid",CacheUtil.getUid());
        httpParams.put("passtoken",CacheUtil.getAccessToken());
        HttpUtils.getInstance().postRequest(url,httpParams,serviceListener,operation);
    }

    /**
     * 创建房间
     * @param cover
     * @param title
     * @param location
     * @param serviceListener
     * @param operation
     */
    public void createRoom(String cover,String title,String location,final ServiceListener serviceListener, final Operation operation){
        String url = ServiceURL.SERVICEURL + ROOM_CREATE;
        HttpParams httpParams = new HttpParams();
        httpParams.put("uid",CacheUtil.getUid());
        httpParams.put("passtoken",CacheUtil.getAccessToken());
        httpParams.put("cover",cover);
        httpParams.put("title",title);
        httpParams.put("location",location);
        HttpUtils.getInstance().postRequest(url,httpParams,serviceListener,operation);
    }



}
