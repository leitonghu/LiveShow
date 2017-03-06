package com.xihoo.liveshow.comm.constant.bean;

import java.util.List;

/**
 * 推荐首页广告
 * Created by leitonghu on 17/2/26.
 */

public class AdBean {

    /**
     * errcode : 0
     * errmsg :
     * data : [{"title":"","image":"http://192.168.1.24//banner/201702090458004898.png","link":"http://debug-wechat.youdeyi.com/wechat/html/gifts/redPacket.html"}]
     */

    private int errcode;
    private String errmsg;
    private List<DataAd> data;

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

    public List<DataAd> getData() {
        return data;
    }

    public void setData(List<DataAd> data) {
        this.data = data;
    }

    public static class DataAd {
        /**
         * title :
         * image : http://192.168.1.24//banner/201702090458004898.png
         * link : http://debug-wechat.youdeyi.com/wechat/html/gifts/redPacket.html
         */

        private String title;
        private String image;
        private String link;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
