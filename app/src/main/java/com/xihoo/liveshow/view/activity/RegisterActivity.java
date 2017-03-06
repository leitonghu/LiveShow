package com.xihoo.liveshow.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gc.materialdesign.views.ButtonRectangle;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.xihoo.liveshow.R;
import com.xihoo.liveshow.comm.constant.Operation;
import com.xihoo.liveshow.comm.constant.bean.BaseBean;
import com.xihoo.liveshow.comm.constant.bean.LoginResultBean;
import com.xihoo.liveshow.comm.util.CacheUtil;
import com.xihoo.liveshow.comm.util.IntentUtil;
import com.xihoo.liveshow.comm.util.JsonUtil;
import com.xihoo.liveshow.comm.util.ToastUtil;
import com.xihoo.liveshow.model.AccountServer;
import com.xihoo.liveshow.net.ServiceListener;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 注册界面
 * Created by leitonghu on 17/2/23.
 */

public class RegisterActivity extends AppCompatActivity implements ServiceListener {
    @BindView(R.id.username)
    MaterialEditText username;
    @BindView(R.id.pwd)
    MaterialEditText pwd;
    @BindView(R.id.toRegister)
    ButtonRectangle toRegister;

    AccountServer accountServer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        accountServer = AccountServer.getInstance();
    }

    @OnClick(R.id.toRegister)
    public void onClick() {
        goToRegister();
    }

    private void goToRegister() {
        if (checkForm()){
            accountServer.
                    toRegister(username.getText().toString(),pwd.getText().toString(),this, Operation.REGISTER);
        }
    }

    private boolean checkForm() {//暂时处理
        return true;
    }



    @Override
    public void onSuccess(Object returnObj, Response response, Operation operation) {

        String result = returnObj.toString();
        switch (operation){
            case REGISTER:
                BaseBean baseBean = JsonUtil.fromJson(result,BaseBean.class);
                if (baseBean.getErrcode() == 0){
                    ToastUtil.shortShow("注册成功");
                   toLogin();
                }else{
                    ToastUtil.shortShow(baseBean.getErrmsg());
                }
                break;
            case LOGIN:
                LoginResultBean resultBean = JsonUtil.fromJson(result,LoginResultBean.class);
                if (resultBean.getErrcode() == 0){
                    CacheUtil.setUserLoginStatus(true);
                    saveData(resultBean);
                    startActivity(new Intent(this,MainActivity.class));
                    finish();
                }else{
                    ToastUtil.shortShow(resultBean.getErrmsg());
                }
                break;

        }


    }
    private void saveData(LoginResultBean resultBean) {
        CacheUtil.saveUid(resultBean.getUid());
        CacheUtil.saveToken(resultBean.getPasstoken());
    }

    private void toLogin() {
        accountServer.toLogin(username.getText().toString(),pwd.getText().toString(),this,Operation.LOGIN);
    }

    @Override
    public void onError(Response response, Exception e, Operation operation) {

    }
}
