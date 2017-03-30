package com.yunhuakeji.app.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.google.gson.Gson;
import com.yunhuakeji.app.greendao.DaoMaster;
import com.yunhuakeji.app.greendaoutil.DBManager;
import com.yunhuakeji.app.greendaoutil.MySQLiteOpenHelper;

import cn.jpush.android.api.JPushInterface;

/**
 * 程序入口
 */

public class YunHuaApplication extends Application {
    private static YunHuaApplication sInstance; //当前对象
    private  Gson gson;
    private  RequestQueue requestQueue;
    private DaoMaster daoMaster;
    private DBManager dbManager;
    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance=this;
        /**
         * GreenDao数据库更新
         */
        MigrationHelper.DEBUG = true; //如果你想查看日志信息，请将DEBUG设置为true
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this, "yunhua.db",
                null);
        daoMaster=new DaoMaster(helper.getWritableDb());
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }

    public static synchronized YunHuaApplication getInstance()
    {
        return sInstance;
    }



    /**
     * Gson
     * @return 返回Gson 对象
     */
    public Gson getGson(){
        if (gson == null){
            gson=new Gson();
        }

        return gson;
    }

    /**
     * Volley
     * @return 返回RequestQueue
     */
    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    /**
     * DBManager
     *
     * @return 返回数据库管理类
     */
    public DBManager getDBManager(){
        if (dbManager==null){
            dbManager=DBManager.getInstance(this);
        }

        return dbManager;
    }
}
