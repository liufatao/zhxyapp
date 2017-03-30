package com.yunhuakeji.app.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 消息记录
 */
public class NewsFragment extends Fragment {


    @BindView(R.id.lv_news)
    ListView lvNews;
    private NewsAdapter newsAdapter;
    private List<String> list;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add("6");
        }
        newsAdapter = new NewsAdapter(getContext(), list);
        lvNews.setAdapter(newsAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
