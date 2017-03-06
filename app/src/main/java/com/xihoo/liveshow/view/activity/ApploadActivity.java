package com.xihoo.liveshow.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;

import com.xihoo.liveshow.R;
import com.xihoo.liveshow.comm.util.CacheUtil;
import com.xihoo.liveshow.comm.util.SharedPreUtil;

public class ApploadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appload);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (CacheUtil.isUserLogin()){
                    startActivity(new Intent(ApploadActivity.this,MainActivity.class));
                }else {
                    startActivity(new Intent(ApploadActivity.this,LoginActivity.class));
                }

                finish();
            }
        },2000);
    }

}
