package com.persist.modularization.okhttp.listener;

/**
 * @author lvjingyuan
 * @date 2018/8/27
 * @describe 请求成功或者失败的回调接口
 */


public interface DisposeDataListener {

    //请求成功回调事件处理
    void onSuccess(Object responseObj);

    //请求失败回调事件处理
    void onFailure(Object resonObj);
}
