package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.application.YunHuaApplication;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.greendaomodel.MyApplication;
import com.yunhuakeji.app.greendaoutil.DBManager;


/***
 * 应用分组item适配器 用于装填应用GridView item 应用数据
 * 
 * @author lft
 *
 */
public class ApplyGridViewAdapter extends BaseAdapter
{
//	private List<ApplyModel.MyAppBean> list;
	private Context context;
	private LayoutInflater inflater;
//	private ApplyModel.MyAppBean listBean;
    private MyApplication myApplication;
    private DBManager dbManager= YunHuaApplication.getInstance().getDBManager();//获得数据库管理库

//	public ApplyGridViewAdapter(List<ApplyModel.MyAppBean> list, Context context)
//	{
//
//		this.context = context;
//		this.list = list;
//		inflater = LayoutInflater.from(context);
//
//	}

	@Override
	public int getCount()
	{

//		return list.size();
		return 0;
	}

	@Override
	public Object getItem(int position)
	{

//		return list.get(position);
		return null;
	}

	@Override
	public long getItemId(int position)
	{

		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder;
		if (convertView == null)
		{
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.scrollgridview_item, parent, false);
			viewHolder.mImg_apply = (ImageView) convertView.findViewById(R.id.img_apply);
			viewHolder.mTxt_applyName = (TextView) convertView.findViewById(R.id.txt_applyname);
			viewHolder.mImg_manage = (ImageView) convertView.findViewById(R.id.img_manage);
			viewHolder.mLyout_AppMagan = (LinearLayout) convertView.findViewById(R.id.lyout_appmagan);
			convertView.setTag(viewHolder);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		bindData(viewHolder, position);

		return convertView;

	}

	private class ViewHolder
	{
		private ImageView mImg_apply, mImg_manage;
		private TextView mTxt_applyName;
		private LinearLayout mLyout_AppMagan;

	}

	/**
	 * 绑定数据
	 * 
	 * @param viewHolder
	 * @param position
	 */
	private void bindData(ViewHolder viewHolder, int position)
	{
//		listBean = list.get(position);
//		if (listBean != null)
//		{
//
////			viewHolder.mTxt_applyName.setText(listBean.getFunction_name());
//			// 判断用户是否管理应用
//			if (Constants.isMagan)
//			{
//				//管理状态下改变我的应用模块管理图标全为减号
//				viewHolder.mImg_manage.setImageResource(R.mipmap.ico_apply_delete);
//				viewHolder.mLyout_AppMagan.setBackground(ContextCompat.getDrawable(context,R.drawable.border_square));//添加矩形背景边框
//			} else
//			{
//				//隐藏背景边框与编辑图标
//				viewHolder.mImg_manage.setVisibility(View.VISIBLE);
//				viewHolder.mLyout_AppMagan.setVisibility(View.VISIBLE);
//			}
//			//加载我的应用图片资源
////			Glide.with(context).load(listBean.getFunction_face()).placeholder(R.mipmap.ico_load_little).error(R.mipmap.ico_error_little).into(viewHolder.mImg_apply);
//			onAddMyApplication();
//
//		}
	}

	/**
	 * 添加我应用的数据到数据库
	 */
	private void onAddMyApplication(){
//		myApplication=new MyApplication();
//		myApplication.setFunction_face(listBean.getFunction_face());
//		myApplication.setFunction_id(listBean.getFunction_id());
//		myApplication.setFunction_name(listBean.getFunction_name());
//		myApplication.setType_id(listBean.getType_id());
//		myApplication.setType_name(listBean.getType_name());
//		myApplication.setUnchange(listBean.getUnchange());
		myApplication.setUserId(Constants.userId);
		dbManager.insertMyApplication(myApplication);
	}

}
