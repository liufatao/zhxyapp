package com.yunhuakeji.app.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.adapter.DataReportListviewAdapter;
import com.yunhuakeji.app.application.YunHuaApplication;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.constants.YunHuaUrl;
import com.yunhuakeji.app.http.VolleyInterface;
import com.yunhuakeji.app.http.VolleyRequest;
import com.yunhuakeji.app.listener.RecyclerItemClickListener;
import com.yunhuakeji.app.listener.RecyclerviewListener;
import com.yunhuakeji.app.model.DataReportModel;
import com.yunhuakeji.app.widget.RecyclerViewDivider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 数据报告
 */
public class DataReportFragment extends Fragment {


    @BindView(R.id.rylist_datareport)
    RecyclerView rylistDatareport;
    private List<DataReportModel.ContentBean.OtherAppBean> list;
    private DataReportModel dataModel;
    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_report, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        intoData();


    }

    /**
     * 初始化视图控件
     */
    private void initView() {

        activity = getActivity();
        rylistDatareport.setLayoutManager(new LinearLayoutManager(activity));
        rylistDatareport.addItemDecoration(new RecyclerViewDivider(getContext(), LinearLayoutManager.VERTICAL, 40, ContextCompat.getColor(getContext(), R.color.color_darkgrey)));
    }

    /**
     * 网络数据请求
     */
    private void httpGetData() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", Constants.userId);
        VolleyRequest.RequestPost(YunHuaUrl.APPLY_URL_GET, "report", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                // 请求成功
                if (!TextUtils.isEmpty(result)) {
                    bindViewData(result);

                }
            }

            @Override
            public void onMyError(VolleyError error) {
                //请求失败
            }
        });
    }

    /**
     * 离线数据
     */
    private void intoData() {
        bindViewData(YunHuaUrl.json);
    }

    /**
     * 绑定视图数据
     *
     * @param json
     */
    private void bindViewData(String json) {
        // 解析数据
        dataModel = YunHuaApplication.getInstance().getGson().fromJson(json, DataReportModel.class);
        list = dataModel.getContent().getOther_app();// 填充数据
        // 填充适配器
        DataReportListviewAdapter listviewAdapter = new DataReportListviewAdapter(activity, list);
        rylistDatareport.setAdapter(listviewAdapter);

        rylistDatareport.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerviewListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Snackbar.make(rylistDatareport,list.get(0).getList().get(position).getFunction_name(),Snackbar.LENGTH_INDEFINITE).show();
                Toast.makeText(getContext(), list.get(0).getList().get(position).getFunction_name(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

    }

}
