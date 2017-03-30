package com.yunhuakeji.app.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.adapter.ApplyAdapter;
import com.yunhuakeji.app.adapter.OtherApplyAdapter;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.model.ApplyModel;
import com.yunhuakeji.app.view.MyActivity;
import com.yunhuakeji.app.view.MyListview;

import java.util.List;

/**
 * 应用页
 */
public class ApplyActivity extends MyActivity implements View.OnClickListener {


    private static TextView mTxtApplyManage;
    private android.widget.Button mBtnSearch;
    private com.yunhuakeji.app.view.MyListview mListApply;
    private com.yunhuakeji.app.view.MyListview mListApplyOtherapp;
    private static ApplyAdapter adapter;// 我的应用适配器
    private static OtherApplyAdapter otherApplyAdapter;// 推荐应用适配器
//    private List<ApplyModel.MyAppBean> list;// 我的应用集合
    private List<ApplyModel.OtherAppBean> otherlist;// 推荐应用集合
    private ApplyModel applymodel;// 数据模型
    private static boolean isMagan = false;// 管理标识

    @Override
    public void initActivity() {
        setContentView(R.layout.activity_apply);
    }

    @Override
    public void initView() {
        //管理按钮
        mTxtApplyManage = (TextView) findViewById(R.id.txt_apply_manage);
        mTxtApplyManage.setOnClickListener(this);
        //搜索按钮
        mBtnSearch = (Button) findViewById(R.id.btn_search);
        mBtnSearch.setOnClickListener(this);
        mListApply = (MyListview) findViewById(R.id.list_apply);
        mListApplyOtherapp = (MyListview) findViewById(R.id.list_apply_otherapp);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initProcessor() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_apply_manage:
                if (Constants.checkNet(this)) {

                    // 管理
                    if (isMagan = !isMagan) {
                        getManage();
                    } else {
                        getOver();
                    }
                } else {
                    Toast.makeText(ApplyActivity.this, R.string.str_tool_neterror, Toast.LENGTH_LONG).show();
                }
                break;
            // 搜索
            case R.id.btn_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_LONG).show();
                break;
        }
    }

    //加载本地数据
    private void thisGetData() {
    }

    //加载网络数据
    private void httpGetData() {
    }

    // 点击管理执行操作
    public static void getManage() {

        mTxtApplyManage.setText("完成");
        Constants.isMagan = isMagan;
        getDataAdapter();
    }

    // 点击完成按钮
    private void getOver() {
        mTxtApplyManage.setText(R.string.str_manage);
        Constants.isMagan = isMagan;
        getDataAdapter();
        getMyAppJson();
    }

    // 刷新数据
    public static void getDataAdapter() {
        adapter.notifyDataSetChanged();
        otherApplyAdapter.notifyDataSetChanged();
    }

    // 打包我的应用为json数据上传后台
    private void getMyAppJson() {

//        JSONArray array = new JSONArray();
//        // 查询出我的应用数据打包成json
//        listsrt = sqlitehelper.rawQuery("select * from yhappmanagprivate where userId=?", new String[]
//                {
//                        Constants.number
//                });
//        for (int i = 0; i < listsrt.size(); i++)
//        {
//            array.put(listsrt.get(i).get("function_id"));
//        }
//
//        Map<String, String> map = new HashMap<>();
//        map.put("userid", Constants.number);
//        map.put("function_list", array.toString());
//        VolleyRequest.RequestPost(DmeoActivity.this, "http://192.168.0.11:8080/GroupChat/Contacts/setFunctionList", "two", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener)
//        {
//
//            @Override
//            public void onMySuccess(String result)
//            {
//                // TODO Auto-generated method stub
//                Toast.makeText(DmeoActivity.this, "提交成功", 0).show();
//            }
//
//            @Override
//            public void onMyError(VolleyError error)
//            {
//                // TODO Auto-generated method stub
//                Toast.makeText(DmeoActivity.this, "提交失败", 0).show();
//            }
//        });
//
//        System.out.println(array.toString());

    }

}
