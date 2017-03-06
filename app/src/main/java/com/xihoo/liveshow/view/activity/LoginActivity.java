package com.xihoo.liveshow.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.xihoo.liveshow.R;
import com.xihoo.liveshow.comm.constant.Operation;
import com.xihoo.liveshow.comm.constant.bean.LoginResultBean;
import com.xihoo.liveshow.comm.util.CacheUtil;
import com.xihoo.liveshow.comm.util.JsonUtil;
import com.xihoo.liveshow.comm.util.ToastUtil;
import com.xihoo.liveshow.model.AccountServer;
import com.xihoo.liveshow.net.ServiceListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

/**
 * 登录界面
 * Created by leitonghu on 17/2/23.
 */

public class LoginActivity extends AppCompatActivity implements ServiceListener {
    @BindView(R.id.username)
    MaterialEditText username;
    @BindView(R.id.pwd)
    MaterialEditText pwd;
    @BindView(R.id.login)
    ButtonRectangle login;
    @BindView(R.id.register)
    ButtonRectangle register;
    @BindView(R.id.visitor)
    TextView visitor;

    AccountServer accountServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        accountServer = AccountServer.getInstance();
    }

    @OnClick({R.id.login, R.id.register, R.id.visitor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                if (checkForm()){
                    toLogin();
                }
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.visitor:
                toVisitorLogin();
                break;
        }
    }

    private void toVisitorLogin() {
        accountServer.toVisitorLogin(this, Operation.VISITORLOGIN);
    }

    private boolean checkForm() {
        return true;
    }

    private void toLogin() {
        accountServer.toLogin(username.getText().toString(),pwd.getText().toString(),this, Operation.LOGIN);
    }

    @Override
    public void onSuccess(Object returnObj, Response response, Operation operation) {
        String result = returnObj.toString();
        switch (operation){
            case VISITORLOGIN:
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

    @Override
    public void onError(Response response, Exception e, Operation operation) {
        ToastUtil.shortShow(response.code()+":"+response.message());
    }
}
