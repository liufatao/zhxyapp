package com.yunhuakeji.app.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.RelativeLayout;

import com.android.volley.VolleyError;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.adapter.DataReportListviewAdapter;
import com.yunhuakeji.app.application.YunHuaApplication;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.constants.YunHuaUrl;
import com.yunhuakeji.app.http.VolleyInterface;
import com.yunhuakeji.app.http.VolleyRequest;
import com.yunhuakeji.app.model.DataReportModel;
import com.yunhuakeji.app.view.MyActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataReportActivity extends MyActivity {


    @BindView(R.id.rylist_datareport)
    RecyclerView rylistDatareport;
    @BindView(R.id.activity_data_report)
    RelativeLayout activityDataReport;

    private List<DataReportModel.ContentBean.OtherAppBean> list;
    private DataReportModel dataModel;


    @Override
    public void initActivity() {
        setContentView(R.layout.activity_data_report);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        rylistDatareport.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initData() {

            intoData();

    }

    @Override
    public void initProcessor() {

    }

    /**
     * 网络数据请求
     */
    private void httpGetData() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", Constants.userId);
        VolleyRequest.RequestPost(YunHuaUrl.APPLY_URL_GET,"dataReport",map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                // 请求成功
                if (!TextUtils.isEmpty(result)) {
                    bindViewData(result);

                }
            }

            @Override
            public void onMyError(VolleyError error) {

            }
        });
    }

    /**
     * 离线数据
     */
    private void intoData() {
        // 根据用户userid查询数据库是否为空，为空添加数据
//        listsrt = sqlitehelper.rawQuery("select * from datareport where userid=" + Constants.number + "");
//        if (!listsrt.isEmpty())
//        {
//
//            bindViewData(listsrt.get(0).get("datajson"));
//        }
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

        // 填充适配器
        DataReportListviewAdapter listviewAdapter = new DataReportListviewAdapter(DataReportActivity.this, list);
        rylistDatareport.setAdapter(listviewAdapter);

    }


}
