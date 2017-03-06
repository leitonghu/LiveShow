package com.xihoo.liveshow.comm.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xihoo.liveshow.R;
import com.xihoo.liveshow.comm.constant.bean.RoomListBean;
import com.xihoo.liveshow.comm.util.GlideImageLoaderUtil;

import java.util.List;

/**
 * 推荐房间列表适配器
 * Created by leitonghu on 17/2/26.
 */

public class RecomAdapter extends BaseQuickAdapter<RoomListBean.RoomBean,BaseViewHolder>{

    private Context mContext;

    public RecomAdapter(int layoutResId, List data, Context context) {
        super(layoutResId, data);
        this.mContext = context;
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, RoomListBean.RoomBean roomBean) {
        viewHolder.setText(R.id.name,roomBean.getMasterName())
                .setText(R.id.location,"火星")
                .setText(R.id.signatrue,roomBean.getTitle())
                .setText(R.id.onlineNum,"在线人数"+roomBean.getWatcherNum())
                .setText(R.id.liveStatus,"直播");

//        Glide.with(mContext).load
//                (roomBean.getCover()).crossFade().into((ImageView) viewHolder.getView(R.id.headImage));
//        Glide.with(mContext).load
//                (roomBean.getCover()).crossFade().into((ImageView) viewHolder.getView(R.id.room_bg));

        GlideImageLoaderUtil.displayUserImage
                (mContext,roomBean.getCover(),(ImageView) viewHolder.getView(R.id.headImage));
        GlideImageLoaderUtil.displayDefalutImage
                (mContext,roomBean.getCover(),(ImageView) viewHolder.getView(R.id.room_bg));
    }
}
