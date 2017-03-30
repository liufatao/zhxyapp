package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.application.YunHuaApplication;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.greendaomodel.MyApplication;
import com.yunhuakeji.app.greendaoutil.DBManager;
import com.yunhuakeji.app.ui.fragment.ApplyFragment;
import com.yunhuakeji.app.view.ScrollGridview;

import java.util.List;
import java.util.Map;

/**
 * 应用主页ListView适配器 用于装我的应用数据
 *
 * @author lft
 */
public class ApplyAdapter extends BaseAdapter {
//    private List<ApplyModel.MyAppBean> list;
//    private static List<ApplyModel.MyAppBean> listBeen;
    private Context context;
    private LayoutInflater inflater;
    private static ApplyGridViewAdapter gridViewAdapter;
    private static List<Map<String, String>> listsrt, myapplist;// 用于数据库装填
    private static DBManager dbManager = YunHuaApplication.getInstance().getDBManager();
//    ApplyModel.MyAppBean appBean;

//    public ApplyAdapter(Context context, List<ApplyModel.MyAppBean> list) {
//        this.context = context;
//        this.list = list;
//        inflater = LayoutInflater.from(context);
//
//    }

    @Override
    public int getCount() {

   return 0;

    }

    @Override
    public Object getItem(int position) {

//        return list.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.home_listview_item, parent, false);
            viewHolder.mGdv_list_item = (ScrollGridview) convertView.findViewById(R.id.gdv_list_item);
            viewHolder.mTxt_GroupName = (TextView) convertView.findViewById(R.id.txt_groupname);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        bindData(viewHolder, position);

        return convertView;

    }

    private class ViewHolder {
        ScrollGridview mGdv_list_item;
        TextView mTxt_GroupName;
    }

    /**
     * 绑定数据
     *
     * @param viewHolder
     * @param position
     */
    private void bindData(ViewHolder viewHolder, int position) {
//        final ApplyModel.MyAppBean applyModel = list.get(position);
//        listBeen =  applyModel;
//        gridViewAdapter = new ApplyGridViewAdapter(listBeen, context);
        viewHolder.mGdv_list_item.setAdapter(gridViewAdapter);
//        if (!applyModel.getName().isEmpty()) {
//            viewHolder.mTxt_GroupName.setText(applyModel.getName());
//            // 用户点击管理时为true刷新数据
//            if (Constants.isMagan) {
//                gridViewAdapter.notifyDataSetChanged();
//            }
//        }
        // 单击事件
        viewHolder.mGdv_list_item.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Constants.isMagan) {
//                   onEdit(applyModel,position);
                } else {
                    //非编辑状态
//                    Toast.makeText(context,listBeen.get(position).getFunction_name(),Toast.LENGTH_LONG).show();
                }

            }
        });
        // 长按编辑
        viewHolder.mGdv_list_item.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ApplyFragment.getManage();
                return false;
            }
        });
    }

    /**
     * 添加数据 刷新数据
     * 把最新的数据添加到我的应用集合给用户展示
     */
    public static void addItem() {
//        ApplyModel.MyAppBean bean;
        List<MyApplication> list = dbManager.queryMyApplicationList(Constants.userId);
        int i = list.size()-1;//勿删防止数组越界
//        bean = new ListBean();
//        bean.setFunction_name(list.get(i).getFunction_name());
//        bean.setFunction_face(list.get(i).getFunction_face());
//        bean.setFunction_id(Integer.valueOf(list.get(i).getFunction_id()));
//        bean.setType_id(Integer.valueOf(list.get(i).getType_id()));
//        bean.setUnchange(Integer.valueOf(list.get(i).getUnchange()));
//        bean.setType_name(list.get(i).getType_name());
//        listBeen.add(bean);
        gridViewAdapter.notifyDataSetChanged();


    }

    /**
     * 用户编辑状态下需要做的事
     * @param applyModel 数据模型
     * @param position 模型ID
     */
//    private void onEdit(ApplyModel.MyAppBean applyModel,int position){
//        // 编辑状态下
//        // 删除过后刷新全部
//        int funtion_id = applyModel.getList().get(position).getFunction_id();
//        // 移除Listview item项
//        applyModel.getList().remove(position);
//        //删除当前用户下我的应用
//        dbManager.deleteMyApplication(Constants.userId, funtion_id);
//        ApplyFragment.getDataAdapter();
//    }

}
