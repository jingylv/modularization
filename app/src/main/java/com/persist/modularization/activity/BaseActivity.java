package com.persist.modularization.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author lvjingyuan
 * @date 2018/8/27
 * @describe 基类Activity 提供初始化和公共配置
 */


public class BaseActivity extends AppCompatActivity {

    public String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
