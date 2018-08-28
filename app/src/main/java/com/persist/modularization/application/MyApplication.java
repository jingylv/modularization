package com.persist.modularization.application;

import android.app.Application;

/**
 * @author lvjingyuan
 * @date 2018/8/27
 * @describe 应用程序的入口,进行一些初始化的配置
 */


public class MyApplication extends Application {

    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getInstance(){
        return myApplication;
    }
}
