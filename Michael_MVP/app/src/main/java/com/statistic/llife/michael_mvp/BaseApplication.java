package com.statistic.llife.michael_mvp;

import android.app.Application;

import com.statistic.llife.michael_mvp.model.DBManager;

/**
 * @author lizhiming211223
 */
public class BaseApplication extends Application {

    private static Application app;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        DBManager.getInstance().init();
    }

    public static synchronized Application getInstance() {
        return app;
    }




}