package com.xihoo.liveshow;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Application基类
 * Created by leitonghu on 17/2/24.
 */

public class BaseApplication extends Application{

    public static Context _context;
    public static Resources _resource;

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        _resource = _context.getResources();

    }

    public static synchronized Context context(){
        return _context;
    }

    public static Resources resources(){
        return _resource;
    }
}
