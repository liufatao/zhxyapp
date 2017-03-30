package com.yunhuakeji.app.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by liufatao on 2017/3/6.
 */

public  abstract class MyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
        initView();
        initProcessor();
        initData();

    }

    /**
     * 初始化布局
     */
    protected abstract void initActivity();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 处理器
     */
    protected abstract void initProcessor();

    /**
     *
     * @return 当前上下文
     */
    protected Context getContext(){
        return this;
    }
}
