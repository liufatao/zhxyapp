package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.model.DataReportModel;

import java.util.List;

/**
 * 数据报告Gridview适配器
 * 
 * @author Administrator
 *
 */
public class DataReportGridViewAdapter extends BaseAdapter
{
	private List<DataReportModel.ContentBean.OtherAppBean.ListBeanX> list;
	private Context context;
	private LayoutInflater inflater;

	public DataReportGridViewAdapter(Context context, List<DataReportModel.ContentBean.OtherAppBean.ListBeanX> list)
	{
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.list = list;
	}

	@Override
	public int getCount()
	{
		return list.size();
	}

	@Override
	public Object getItem(int position)
	{
		return list.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder;
		if (convertView == null)
		{
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.scrollgridview_datareport_item, parent, false);
			holder.mImg_DataReport_apply = (ImageView) convertView.findViewById(R.id.img_datareport_appimg);
			holder.mTxt_DataReport_appName = (TextView) convertView.findViewById(R.id.txt_datareport_appname);
			convertView.setTag(holder);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		setViewData(holder, position);
		return convertView;
	}

	private class ViewHolder
	{
		ImageView mImg_DataReport_apply;
		TextView mTxt_DataReport_appName;
	}

	/**
	 * 数据绑定
	 * 
	 * @param holder
	 * @param position
	 */
	private void setViewData(ViewHolder holder, int position)
	{
		DataReportModel.ContentBean.OtherAppBean.ListBeanX bean = list.get(position);
		if (!TextUtils.isEmpty(bean.getFunction_name()))
		{
			holder.mTxt_DataReport_appName.setText(bean.getFunction_name());
			Glide.with(context).load(bean.getFunction_face()).placeholder(R.mipmap.ico_load_little).error(R.mipmap.ico_load_little).into(holder.mImg_DataReport_apply);
		}

	}

}
