package com.xihoo.liveshow.comm.constant.bean;

/**
 * 基础bean类
 * Created by leitonghu on 17/2/24.
 */

public class BaseBean {


    /**
     * errcode : 0
     * errmsg :
     */

    private int errcode;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
