package com.persist.modularization.okhttp.listener;

import java.util.ArrayList;

/**
 * @author lvjingyuan
 * @date 2018/8/27
 * @describe 当需要专门处理Cookie时创建此回调接口
 */


public interface DisposeHandleCookieListener extends DisposeDataListener{
    void onCookie(ArrayList<String> cookieStrList);
}
