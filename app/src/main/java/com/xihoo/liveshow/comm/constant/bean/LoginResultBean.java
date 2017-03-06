package com.xihoo.liveshow.comm.constant.bean;

/**
 * 登录结果实体类
 * Created by leitonghu on 17/2/25.
 */

public class LoginResultBean {


    /**
     * errcode : 0
     * uid : 1759252159019235
     * errmsg :
     * passtoken : b399689945adb5f257aabb97a1822d78
     */

    private int errcode;
    private long uid;
    private String errmsg;
    private String passtoken;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getPasstoken() {
        return passtoken;
    }

    public void setPasstoken(String passtoken) {
        this.passtoken = passtoken;
    }
}
