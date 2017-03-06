package com.xihoo.liveshow.view.activity.fragment.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.xihoo.liveshow.R;
import com.xihoo.liveshow.comm.adapter.RecomAdapter;
import com.xihoo.liveshow.comm.constant.Operation;
import com.xihoo.liveshow.comm.constant.bean.RoomListBean;
import com.xihoo.liveshow.comm.customview.NetworkImageHolderView;
import com.xihoo.liveshow.comm.util.JsonUtil;
import com.xihoo.liveshow.comm.util.ToastUtil;
import com.xihoo.liveshow.model.LiveServer;
import com.xihoo.liveshow.net.ServiceListener;
import com.xihoo.liveshow.view.activity.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

/**
 * 推荐主播列表
 * Created by leitonghu on 17/2/22.
 */

public class RecommedFragment extends BaseFragment implements ServiceListener {
    ConvenientBanner convenientBanner;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<String> adImages = new ArrayList<>();
    private LiveServer liveServer;
    private RecomAdapter recomAdapter;

    private View headView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom, null);
        headView = inflater.inflate(R.layout.recom_headview,null);
        convenientBanner = (ConvenientBanner) headView.findViewById(R.id.convenientBanner);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        liveServer = new LiveServer();
        initUI();
        getData();
        setAdapter();
    }

    private void setAdapter() {

    }

    private void getData() {
        liveServer.getRoomList(this, Operation.GET_ROOM_LIST);
    }

    private void initUI() {
        adImages.clear();

        adImages.add("http://192.168.1.24//banner/201702090458004898.png");
        adImages.add("http://192.168.1.24//banner/201702090458004898.png");

        setAdBanner();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addOnItemTouchListener(new com.chad.library.adapter.base.listener.OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });


    }


    private void setAdBanner() {
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new NetworkImageHolderView();
            }
        }, adImages)
                .setPageIndicator(new int[]{R.mipmap.icon_point, R.mipmap.icon_point_pre})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
        ;
        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        if (adImages.size() > 0) {
            convenientBanner.setVisibility(View.VISIBLE);
            if (adImages.size() == 1) {
                convenientBanner.setCanLoop(false);
                convenientBanner.setPointViewVisible(false);
            } else {
                convenientBanner.setCanLoop(true);
                convenientBanner.setPointViewVisible(true);
            }
        } else {
            convenientBanner.setVisibility(View.GONE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(5000);
    }


    @Override
    public void onSuccess(Object returnObj, Response response, Operation operation) {
        String result = returnObj.toString();
        switch (operation) {
            case GET_ROOM_LIST:
                RoomListBean roomListBean = JsonUtil.fromJson(result, RoomListBean.class);
                List<RoomListBean.RoomBean> roomlist = new ArrayList<>();
                RoomListBean.RoomBean roomBean1 ;
                for (int i = 0 ;i< 20;i++){
                    roomBean1 = new RoomListBean.RoomBean();
                    roomBean1.setCover("http://192.168.1.24//banner/201702090458004898.png");
                    roomBean1.setRoomId(i+"");
                    roomBean1.setTitle("测试"+i);
                    roomBean1.setWatcherNum(100+i);
                    roomBean1.setMasterName("阿权主播"+i);
                    roomlist.add(roomBean1);
                }
                roomListBean.setRoomlist(roomlist);

                if (roomListBean.getErrcode() == 0) {
                    recomAdapter = new RecomAdapter(R.layout.item_recomlist, roomListBean.getRoomlist(),getActivity());
                    recyclerView.setAdapter(recomAdapter);
                    recomAdapter.notifyDataSetChanged();
                    recomAdapter.addHeaderView(headView);
                } else {
                    ToastUtil.shortShow(roomListBean.getErrmsg());
                }
                break;


        }
    }

    @Override
    public void onError(Response response, Exception e, Operation operation) {

    }
}
