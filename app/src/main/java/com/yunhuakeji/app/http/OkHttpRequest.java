package com.yunhuakeji.app.http;

import android.util.Log;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求帮助类
 */

public class OkHttpRequest {
    private static OkHttpClient okHttpClient;
    Request request = null;
    Call call = null;
    //定义上传文件类型二进制流文件
    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("application/octet-stream");
    /**
     * okhttp
     * get请求
     */
    public void getOkHttp() {
        okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder().url("url");
        builder.method("GET", null);
        request = builder.build();
        call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //成功
                if (null != response) {
                    String s = response.cacheResponse().toString();
                } else {
                    response.body().string();
                    String s = response.networkResponse().toString();
                }
            }
        });
    }

    /**
     * okhttp
     * POST 请求
     */
    public void postOkHttp() {
        okHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("size", "10")
                .build();
        request = new Request.Builder().url("url").post(formBody).build();
        call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response) {
                    String s = response.cacheResponse().toString();
                } else {
                    response.body().string();
                    String s = response.networkResponse().toString();
                }
            }
        });
    }

    /**
     * okhttp 上传文件
     * @param file 文件
     * @param url 上传地址
     */
    public static void postAsynFile(File file,String url) {
        okHttpClient=new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("ok上传文件",response.body().string());
            }
        });
    }
}
