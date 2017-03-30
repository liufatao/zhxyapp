package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.application.YunHuaApplication;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.greendaomodel.MyApplication;
import com.yunhuakeji.app.greendaoutil.DBManager;
import com.yunhuakeji.app.model.ApplyModel;
import com.yunhuakeji.app.ui.fragment.ApplyFragment;
import com.yunhuakeji.app.view.ScrollGridview;

import java.util.List;


/**
 * 应用主页推荐应用ListView适配器 用于装推荐应用数据
 *
 * @author lft
 */
public class OtherApplyAdapter extends BaseAdapter {
    private List<ApplyModel.OtherAppBean> list;
    private Context context;
    private LayoutInflater inflater;
    private OtherApplyGridViewAdapter gridViewAdapter;
    private static List<MyApplication> myapplist;// 用于数据库装填
    private static boolean isOut = true;
    private MyApplication application;
    private DBManager dbManager = YunHuaApplication.getInstance().getDBManager();

    public OtherApplyAdapter(Context context, List<ApplyModel.OtherAppBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
        final ApplyModel.OtherAppBean applyModel = list.get(position);
        gridViewAdapter = new OtherApplyGridViewAdapter(applyModel.getList(), context);
        viewHolder.mGdv_list_item.setAdapter(gridViewAdapter);
        if (!applyModel.getName().isEmpty()) {
            viewHolder.mTxt_GroupName.setText(applyModel.getName());
            // 用户点击管理时为true刷新数据
            if (Constants.isMagan) {
                gridViewAdapter.notifyDataSetChanged();
            }
        }

        viewHolder.mGdv_list_item.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Constants.isMagan) {
                    // 管理状态
                    setManage(view, applyModel, position);

                } else {
                    // 正常状态
                    Toast.makeText(context,applyModel.getList().get(position).getFunction_name(),Toast.LENGTH_LONG).show();
                }
            }
        });
        viewHolder.mGdv_list_item.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                ApplyFragment.getManage();
                return false;
            }
        });
    }

    /**
     *  动态添加数据到我的应用list view
     * @param view
     * @param applyModel
     * @param position
     */
    private void setManage(View view, ApplyModel.OtherAppBean applyModel, int position) {
        ImageView imageView = (ImageView) view.findViewById(R.id.img_manage);
        imageView.setImageResource(R.mipmap.ico_apply_added);
        //查询我的应用数据
        myapplist = dbManager.queryMyApplicationList(Constants.userId);

        for (MyApplication item:myapplist){
            application =item;
            if (applyModel.getList().get(position).getFunction_id().equals(application.getFunction_id())) {
                //如果在我的应用中找到相同的应用停止循环
                isOut = false;
                break;
            } else {
                isOut = true;
            }
        }
        // 把我的应用数据添加数据库
        onAddMyApplication(applyModel, position);
        if (isOut){
            ApplyAdapter.addItem();// 动态添加我的应用
            ApplyFragment.getDataAdapter();// 全局刷新
        }


    }

    /**
     * 添加我的应用到数据库
     *
     * @param applyModel
     * @param position
     */
    private void onAddMyApplication(ApplyModel.OtherAppBean applyModel, int position) {
        MyApplication myApplication = new MyApplication();
        myApplication.setType_name(applyModel.getList().get(position).getType_name());
        myApplication.setType_id(Integer.valueOf(applyModel.getList().get(position).getType_id()));
        myApplication.setFunction_face(applyModel.getList().get(position).getFunction_face());
        myApplication.setFunction_name(applyModel.getList().get(position).getFunction_name());
        myApplication.setFunction_id(Integer.valueOf(applyModel.getList().get(position).getFunction_id()));
        myApplication.setUnchange(Integer.valueOf(applyModel.getList().get(position).getUnchange()));
        myApplication.setUserId(Constants.userId);
        dbManager.insertMyApplication(myApplication);

    }
}
