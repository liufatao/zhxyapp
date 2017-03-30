package com.yunhuakeji.app.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.adapter.ApplyAdapter;
import com.yunhuakeji.app.adapter.OtherApplyAdapter;
import com.yunhuakeji.app.application.YunHuaApplication;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.constants.YunHuaUrl;
import com.yunhuakeji.app.greendaomodel.RecommendApplication;
import com.yunhuakeji.app.greendaoutil.DBManager;
import com.yunhuakeji.app.http.VolleyInterface;
import com.yunhuakeji.app.http.VolleyRequest;
import com.yunhuakeji.app.model.ApplyModel;
import com.yunhuakeji.app.tool.MD5Helper;
import com.yunhuakeji.app.util.PackAganmanger;
import com.yunhuakeji.app.view.MyListview;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 我的应用
 */
public class ApplyFragment extends Fragment implements View.OnClickListener {


    private static ApplyAdapter adapter;// 我的应用适配器
    private static OtherApplyAdapter otherApplyAdapter;// 推荐应用适配器
//    private List<ApplyModel.MyAppBean> list;// 我的应用集合
    private List<ApplyModel.OtherAppBean> otherlist;// 推荐应用集合
    private ApplyModel applymodel;// 数据模型
    private static boolean isMagan = true;// 管理标识
    private Activity activity;
    private static TextView txtApplyManage;
    private RelativeLayout rlApplaySearch;
    private MyListview listApply;
    private MyListview listApplyOtherapp;
    private PackAganmanger packAganmanger;
    private DBManager dbManager = YunHuaApplication.getInstance().getDBManager();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_apply, container, false);
        initView(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        if (Constants.checkNet(activity)){
            httpGetData();
        }else {
            thisGetData();
        }




    }


    private void initView(View view) {
        txtApplyManage = (TextView) view.findViewById(R.id.txt_apply_manage);
        txtApplyManage.setOnClickListener(this);
        rlApplaySearch = (RelativeLayout) view.findViewById(R.id.rl_applay_search);
        rlApplaySearch.setOnClickListener(this);
        listApply = (MyListview) view.findViewById(R.id.list_apply);
        listApplyOtherapp = (MyListview) view.findViewById(R.id.list_apply_otherapp);
    }

    //加载本地数据
    private void thisGetData() {
        List<RecommendApplication> list=dbManager.queryRecommendApplication(Constants.userId);
        for (RecommendApplication application:list){
            Log.e("主页jsop",application.getApply_json());
            doSuccess(application.getApply_json());
        }

    }

    //加载网络数据
    private void httpGetData() {
        String ticket=MD5Helper.MD5(Constants.addString+Constants.userId+MD5Helper.MD5(Constants.password));
        //删除推荐应用所以数据
        dbManager.deleteRecommendApplication(Constants.userId);
        Map<String, String> map = new HashMap<>();
        map.put("userid", Constants.userId);
        map.put("ticket", ticket);
        map.put("Version","0");
        VolleyRequest.RequestPost(YunHuaUrl.FUNCTION_URL_OLD, "apply", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                      //成功
                      String json=null;
                      //替换反斜杠
                      json=result.replace("\\","");
                      //取掉引号
                      json=json.substring(1,json.length()-1);

                      Log.e("应用", json);
                if (null!=json) {

                      doSuccess(json);


                }



            }

            @Override
            public void onMyError(VolleyError error) {
                //失败
                Toast.makeText(getContext(), R.string.str_tool_neterror, Toast.LENGTH_LONG).show();
            }
        });

    }

    // 点击管理执行操作
    public static void getManage() {

        txtApplyManage.setText(R.string.str_over);
        if (isMagan) {
            Constants.isMagan = isMagan;
            getDataAdapter();
        }


    }

    // 点击完成按钮
    private void getOver() {
        txtApplyManage.setText(R.string.str_manage);
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

        JSONArray array = new JSONArray();
        // 查询出我的应用数据打包成json
        List<RecommendApplication> list = dbManager.queryRecommendApplication(Constants.userId);
        for (int i = 0; i < list.size(); i++) {
            array.put(list.get(i).getFunction_id());
        }

        Map<String, String> map = new HashMap<>();
        map.put("userid", Constants.userId);
        map.put("function_list", array.toString());
        VolleyRequest.RequestPost(YunHuaUrl.APPLY_URL_SET, "home_submit", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {

            @Override
            public void onMySuccess(String result) {
                // 成功
                Toast.makeText(getContext(), "提交成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMyError(VolleyError error) {
                // 失败
                Toast.makeText(getContext(), "提交失败", Toast.LENGTH_LONG).show();
            }
        });


    }


    // 数据绑定
    public void doSuccess(String s)  {
    applymodel = YunHuaApplication.getInstance().getGson().fromJson(s, ApplyModel.class);


//        list = applymodel.getMy_app();
//        adapter = new ApplyAdapter(getContext(), list);
        otherlist = applymodel.getOther_app();
        otherApplyAdapter = new OtherApplyAdapter(getContext(), otherlist);
        listApply.setAdapter(adapter);
        listApplyOtherapp.setAdapter(otherApplyAdapter);

        RecommendApplication recommendApplication = null;
        for (int i = 0; i < otherlist.size(); i++) {
            recommendApplication = new RecommendApplication();

            recommendApplication.setFunction_name(otherlist.get(0).getList().get(i).getFunction_name());
            recommendApplication.setFunction_face(otherlist.get(0).getList().get(i).getFunction_face());
            recommendApplication.setFunction_id(Integer.valueOf(otherlist.get(0).getList().get(i).getFunction_id()));
            recommendApplication.setType_id(Integer.valueOf(otherlist.get(0).getList().get(i).getType_id()));
            recommendApplication.setType_name(otherlist.get(0).getList().get(i).getType_name());
            recommendApplication.setUnchange(Integer.valueOf(otherlist.get(0).getList().get(i).getUnchange()));
            recommendApplication.setUserId(Constants.userId);
            recommendApplication.setApply_json(s);

        }
        dbManager.insertRecommendApplication(recommendApplication);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_apply_manage:
                if (Constants.checkNet(activity)) {

                    // 管理
                    if (isMagan) {
                        getManage();

                    } else {
                        getOver();
                    }
                   isMagan=!isMagan;

                } else {
                    Snackbar.make(txtApplyManage, R.string.str_tool_neterror, Toast.LENGTH_LONG).show();

                }
                break;
            case R.id.rl_applay_search:
                Toast.makeText(getContext(), "搜索", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
