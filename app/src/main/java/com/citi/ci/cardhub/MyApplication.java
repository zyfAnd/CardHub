package com.citi.ci.cardhub;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by zhang on 2017/12/3.
 */

public class MyApplication extends ZApplication {
    private String TAG = "CardHub-Logger";
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(TAG);
        context = getApplicationContext();
//        Logger.init(TAG).logLevel(LogLevel.NONE);
        ZXingLibrary.initDisplayOpinion(this);
    }
    public  static Context getContext()
    {
        return context;
    }
}
