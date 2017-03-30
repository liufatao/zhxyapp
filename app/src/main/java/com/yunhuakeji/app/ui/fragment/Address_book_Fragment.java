package com.yunhuakeji.app.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.adapter.AddressBookAdapter;
import com.yunhuakeji.app.demo.Cheeses;
import com.yunhuakeji.app.model.AddressModel;
import com.yunhuakeji.app.widget.FancyIndexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 通讯录
 */
public class Address_book_Fragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.lv_addressbook)
    ListView lvAddressbook;
    @BindView(R.id.bar)
    FancyIndexer bar;
    @BindView(R.id.tv_index_center)
    TextView tvIndexCenter;
    Unbinder unbinder;

    private LinearLayout lyAddressbookNewfriend;
    private LinearLayout lyAddressbookTeacher;
    private LinearLayout lyAddressbookClass;
    private LinearLayout lyAddressbookSchoolnews;

    private AddressBookAdapter addressBookAdapter;
    private List<AddressModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_book, container, false);
        unbinder=ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intoView();
        initData();
    }


    private void intoView() {
        //给list view 添加头部文件
        View view = getView().inflate(getContext(), R.layout.include_addressbook, null);
        lvAddressbook.addHeaderView(view, null, false);//禁止头部点击

        //我的新朋友
        lyAddressbookNewfriend = (LinearLayout) view.findViewById(R.id.ly_addressbook_newfriend);
        lyAddressbookNewfriend.setOnClickListener(this);
        //教师通讯录
        lyAddressbookTeacher = (LinearLayout) view.findViewById(R.id.ly_addressbook_teacher);
        lyAddressbookTeacher.setOnClickListener(this);
        //我的班级
        lyAddressbookClass = (LinearLayout) view.findViewById(R.id.ly_addressbook_class);
        lyAddressbookClass.setOnClickListener(this);
        //学校通知
        lyAddressbookSchoolnews = (LinearLayout) view.findViewById(R.id.ly_addressbook_schoolnews);
        lyAddressbookSchoolnews.setOnClickListener(this);


    }

    /**
     * 初始化数据
     */
    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < Cheeses.NAMES.length; i++) {
            list.add(new AddressModel(Cheeses.NAMES[i]));
        }
        //对集合进行排序
        Collections.sort(list);
        addressBookAdapter = new AddressBookAdapter(getContext(), list);
        lvAddressbook.setAdapter(addressBookAdapter);

        lvAddressbook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), position + "", Toast.LENGTH_LONG).show();
            }
        });

        bar.setOnTouchLetterChangedListener(new FancyIndexer.OnTouchLetterChangedListener() {

            @Override
            public void onTouchLetterChanged(String letter) {
                // 从集合中查找第一个拼音首字母为letter的索引, 进行跳转
                for (int i = 0; i < list.size(); i++) {
                    AddressModel goodMan = list.get(i);
                    String s = goodMan.getPinyin().charAt(0) + "";
                    if (TextUtils.equals(s, letter)) {
                        // 匹配成功, 中断循环, 跳转到i位置
                        lvAddressbook.setSelection(i);
                        break;
                    }
                }
            }
        });
    }


    @OnClick(R.id.rl_search)
    public void onClick() {
        switch (getView().getId()) {
            case R.id.rl_search:
                Toast.makeText(getContext(), "搜索", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_addressbook_newfriend:
                //我的新朋友
                Toast.makeText(getContext(), "我的新朋友", Toast.LENGTH_LONG).show();
                break;
            case R.id.ly_addressbook_teacher:
                //教师通讯录
                Toast.makeText(getContext(), "教师通讯录", Toast.LENGTH_LONG).show();
                break;
            case R.id.ly_addressbook_class:
                //我的班级
                Toast.makeText(getContext(), "我的班级", Toast.LENGTH_LONG).show();
                break;
            case R.id.ly_addressbook_schoolnews:
                //学校通知
                Toast.makeText(getContext(), "学校通知", Toast.LENGTH_LONG).show();
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
