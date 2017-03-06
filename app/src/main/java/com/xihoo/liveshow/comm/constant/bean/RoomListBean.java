package com.xihoo.liveshow.comm.constant.bean;

import java.util.List;

/**
 * 房间列表
 * Created by leitonghu on 17/2/26.
 */

public class RoomListBean {


    /**
     * errcode : 0
     * errmsg :
     * roomlist : [{"cover":"100","title":"aaa","watcherNum":0,"roomId":"100","masterName":"dfaf"}]
     */

    private int errcode;
    private String errmsg;
    private List<RoomBean> roomlist;

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

    public List<RoomBean> getRoomlist() {
        return roomlist;
    }

    public void setRoomlist(List<RoomBean> roomlist) {
        this.roomlist = roomlist;
    }

    public static class RoomBean {
        /**
         * cover : 100
         * title : aaa
         * watcherNum : 0
         * roomId : 100
         * masterName : dfaf
         */

        private String cover;
        private String title;
        private int watcherNum;
        private String roomId;
        private String masterName;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWatcherNum() {
            return watcherNum;
        }

        public void setWatcherNum(int watcherNum) {
            this.watcherNum = watcherNum;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getMasterName() {
            return masterName;
        }

        public void setMasterName(String masterName) {
            this.masterName = masterName;
        }
    }
}
