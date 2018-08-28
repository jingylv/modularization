package com.persist.modularization.okhttp;

import com.persist.modularization.okhttp.https.HttpsUtils;
import com.persist.modularization.okhttp.listener.DisposeDataHandle;
import com.persist.modularization.okhttp.response.CommonJsonCallback;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author lvjingyuan
 * @date 2018/8/27
 * @describe
 */


public class CommonHttpClient {

    private static final int TIME_OUT = 10;
    private static OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        //为所有的请求添加请求头
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain
                        .request()
                        .newBuilder()
                        .addHeader("User-Agent","Imooc-Mobile") //标明发送本次请求的客户端
                        .build();
                return chain.proceed(request);
            }
        });

        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(TIME_OUT,TimeUnit.SECONDS);
        builder.writeTimeout(TIME_OUT,TimeUnit.SECONDS);
        builder.followRedirects(true); //允许重定向
        builder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(),HttpsUtils.initTrustManager());

        mOkHttpClient = builder.build();
    }

    public static OkHttpClient getInstance(){
        return mOkHttpClient;
    }

    public static Call get(Request request, DisposeDataHandle disposeDataHandle){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(disposeDataHandle));
        return call;
    }
}
