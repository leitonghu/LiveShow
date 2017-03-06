package com.xihoo.liveshow.view.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xihoo.liveshow.R;
import com.xihoo.liveshow.comm.constant.Operation;
import com.xihoo.liveshow.comm.constant.bean.BaseBean;
import com.xihoo.liveshow.comm.util.CacheUtil;
import com.xihoo.liveshow.comm.util.JsonUtil;
import com.xihoo.liveshow.comm.util.ToastUtil;
import com.xihoo.liveshow.model.AccountServer;
import com.xihoo.liveshow.net.ServiceListener;
import com.xihoo.liveshow.view.activity.LoginActivity;
import com.xihoo.liveshow.view.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Response;


public class UserFragment extends BaseFragment implements ServiceListener {


    AccountServer accountServer;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.id)
    TextView infoId;
    @BindView(R.id.edit_userInfo)
    RelativeLayout editUserInfo;
    @BindView(R.id.about)
    RelativeLayout about;
    @BindView(R.id.logout)
    RelativeLayout logout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountServer = AccountServer.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        infoId.setText("ID:"+CacheUtil.getUid());
    }

    @Override
    public void onSuccess(Object returnObj, Response response, Operation operation) {
        String result = returnObj.toString();
        switch (operation) {
            case LOGOUT:
                BaseBean baseBean = JsonUtil.fromJson(result, BaseBean.class);
                if (baseBean.getErrcode() == 0) {
                    ToastUtil.shortShow("退出成功");
                    clearCacheData();
                    ((MainActivity) getActivity()).finish();
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    ToastUtil.shortShow(baseBean.getErrmsg());
                }
                break;
        }
    }

    private void clearCacheData() {
        CacheUtil.saveToken("");
        CacheUtil.saveUid(0l);
    }

    @Override
    public void onError(Response response, Exception e, Operation operation) {

    }

    @OnClick({R.id.profile_image, R.id.edit_userInfo, R.id.about, R.id.logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_image:

                break;
            case R.id.edit_userInfo:

                break;
            case R.id.about:

                break;
            case R.id.logout:
                accountServer.toLoginOut(this, Operation.LOGOUT);
                break;
        }
    }
}
