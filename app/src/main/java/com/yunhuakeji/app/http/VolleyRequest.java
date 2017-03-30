package com.yunhuakeji.app.http;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.yunhuakeji.app.application.YunHuaApplication;

import java.util.Map;

/**
 * Volloey 封装
 */

public class VolleyRequest {
    private static StringRequest stringRequest;
    public static Context context;
    /**
     * VOLLEY GET 请求
     *
     *
     * @param url 请求地址
     *
     * @param tag 任务标识
     *
     * @param vif 请求监听
     *
     */
    public static void RequestGet(String url, String tag, VolleyInterface vif)
    {
        // 防止重复请求，所以先取消tag标识的请求队列
        YunHuaApplication.getInstance().getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.errorListener());
        stringRequest.setTag(tag);
        YunHuaApplication.getInstance().getRequestQueue().add(stringRequest);

    }

    /**
     * VOLLEY POST 请求
     *
     *
     * @param url 请求地址
     *
     *
     * @param params 键值对
     *
     * @param vif 请求监听
     *
     */
    public static void RequestPost(String url,String tag,final Map<String, String> params, VolleyInterface vif)
    {
         // 防止重复请求，所以先取消tag标识的请求队列
        YunHuaApplication.getInstance().getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.POST,url, vif.loadingListener(), vif.errorListener())
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                return params;
            }
        };
        stringRequest.setTag(tag);
        YunHuaApplication.getInstance().getRequestQueue().add(stringRequest);
    }
}
