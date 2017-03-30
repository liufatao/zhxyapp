package com.yunhuakeji.app.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.demo.Cheeses;
import com.yunhuakeji.app.widget.FancyIndexer;
import com.yunhuakeji.app.model.AddressModel;
import com.yunhuakeji.app.demo.MyAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class DemoActivity extends AppCompatActivity {
    private TextView tv_index_center;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        tv_index_center = (TextView) findViewById(R.id.tv_index_center);

        final ListView lv_content = (ListView) findViewById(R.id.lv_content);

        final ArrayList<AddressModel> persons = new ArrayList<AddressModel>();

        // 填充数据, 并排序
        fillAndSortData(persons);

        lv_content.setAdapter(new MyAdapter(persons, this));


        FancyIndexer mFancyIndexer = (FancyIndexer) findViewById(R.id.bar);
        mFancyIndexer.setOnTouchLetterChangedListener(new FancyIndexer.OnTouchLetterChangedListener() {

            @Override
            public void onTouchLetterChanged(String letter) {
                Log.e("letter:",letter);
//                showLetter(letter);提示数字
                // 从集合中查找第一个拼音首字母为letter的索引, 进行跳转
                for (int i = 0; i < persons.size(); i++) {
                    AddressModel goodMan = persons.get(i);
                    String s = goodMan.getPinyin().charAt(0) + "";
                    if(TextUtils.equals(s, letter)){
                        // 匹配成功, 中断循环, 跳转到i位置
                        lv_content.setSelection(i);
                        break;
                    }
                }
            }
        });
    }

    private Handler mHandler = new Handler();

    /**
     * 显示字母提示
     * @param letter
     */
    protected void showLetter(String letter) {
        tv_index_center.setVisibility(View.VISIBLE);
        tv_index_center.setText(letter);

        // 取消掉刚刚所有的演示操作
        mHandler.removeCallbacksAndMessages(null);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 隐藏
                tv_index_center.setVisibility(View.GONE);
            }
        }, 1000);

    }

    /**
     * 获得当前系统语言
     * 填充,排序
     * @param persons
     */
    private void fillAndSortData(ArrayList<AddressModel> persons) {
        String[] datas = null;
        //判断是否是中文
        boolean china = getResources().getConfiguration().locale.getCountry().equals("CN");
        datas = Cheeses.NAMES;
        for (int i = 0; i < datas.length; i++) {
            persons.add(new AddressModel(datas[i]));
        }
        // 排序
        Collections.sort(persons);
    }
}
