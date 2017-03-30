package com.yunhuakeji.app.http;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Volley 请求监听
 */

public abstract class VolleyInterface {
    // Volley监听类
    public static Response.Listener<String> mListener;
    public static Response.ErrorListener mErrorListener;

    public VolleyInterface(Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        this.mListener = listener;
        this.mErrorListener = errorListener;
    }

    public abstract void onMySuccess(String result);

    public abstract void onMyError(VolleyError error);

    // 实例化成功监听传人成功返回数据
    public Response.Listener<String> loadingListener()
    {
        mListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                /**
                 * 链接服务器成功
                 */
                onMySuccess(response);
            }
        };
        return mListener;
    }

    // 实例化失败监听传人失败返回值
    public Response.ErrorListener errorListener()
    {
        mErrorListener = new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                /**
                 * 链接服务器失败
                 */
                onMyError(error);
            }
        };
        return mErrorListener;

    }
}
