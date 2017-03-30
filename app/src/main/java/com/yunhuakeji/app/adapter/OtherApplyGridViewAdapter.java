package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.application.YunHuaApplication;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.greendaomodel.MyApplication;
import com.yunhuakeji.app.greendaomodel.RecommendApplication;
import com.yunhuakeji.app.greendaoutil.DBManager;
import com.yunhuakeji.app.model.ApplyModel;

import java.util.List;


/***
 * 应用页推荐应用GridView item适配器 用于填装应用数据
 *
 * @author lft
 *
 */
public class OtherApplyGridViewAdapter extends BaseAdapter {
    private List<ApplyModel.OtherAppBean.ListBean> list;
    ApplyModel.OtherAppBean.ListBean beanX;
    private Context context;
    private LayoutInflater inflater;
    private ApplyModel.OtherAppBean.ListBean listBean;
    private List<MyApplication> listsrt;// 用于数据库装填
    private List<RecommendApplication> recommendApplications;// 用于数据库装填
    private MyApplication application;
    private boolean isOut = true;// 是否执行数据查询
    private DBManager dbManager = YunHuaApplication.getInstance().getDBManager();

    public OtherApplyGridViewAdapter(List<ApplyModel.OtherAppBean.ListBean> list, Context context) {

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.scrollgridview_item, parent, false);
            viewHolder.mImg_apply = (ImageView) convertView.findViewById(R.id.img_apply);
            viewHolder.mTxt_applyName = (TextView) convertView.findViewById(R.id.txt_applyname);
            viewHolder.mImg_manage = (ImageView) convertView.findViewById(R.id.img_manage);
            viewHolder.mLyout_AppMagan = (LinearLayout) convertView.findViewById(R.id.lyout_appmagan);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bindData(viewHolder, position);
        return convertView;

    }

    private class ViewHolder {
        private ImageView mImg_apply, mImg_manage;
        private TextView mTxt_applyName;
        private LinearLayout mLyout_AppMagan;
    }

    /**
     * 绑定应用数据
     *
     * @param viewHolder
     * @param position
     */
    private void bindData(ViewHolder viewHolder, int position) {
        listBean = list.get(position);

        if (listBean != null) {
            viewHolder.mTxt_applyName.setText(listBean.getFunction_name());
            // 判断用户是否管理应用
            if (Constants.isMagan) {
                setManager(viewHolder);
            } else {
                //隐藏编辑按钮图标
                viewHolder.mImg_manage.setVisibility(View.VISIBLE);
                viewHolder.mLyout_AppMagan.setVisibility(View.VISIBLE);
            }
            //加载推荐应用图片
            Glide.with(context).load(listBean.getFunction_face()).placeholder(R.mipmap.ico_load_little).error(R.mipmap.ico_error_little).into(viewHolder.mImg_apply);


        }
    }

    /**
     * 用户在编辑状态下需要做的事
     *
     * @param viewHolder
     */
    private void setManager(ViewHolder viewHolder) {
        listsrt = dbManager.queryMyApplicationList(Constants.userId);
        //遍历数据库
        for (MyApplication item : listsrt) {
            application = item;
            if (listBean.getFunction_id().equals(application.getFunction_id()) ) {
                //推荐应用有相应的应用改变图标为对号并退出当前循环
                viewHolder.mImg_manage.setImageResource(R.mipmap.ico_apply_added);
                break;
            } else {
                // 推荐应用没有相应的应用改变图标为加号
                viewHolder.mImg_manage.setImageResource(R.mipmap.ico_apply_add);
            }
        }
        //添加矩形边框背景
        viewHolder.mLyout_AppMagan.setBackground(ContextCompat.getDrawable(context, R.drawable.border_square));
    }

}
