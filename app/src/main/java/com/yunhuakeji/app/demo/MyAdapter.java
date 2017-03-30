package com.yunhuakeji.app.demo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.model.AddressModel;

import java.util.ArrayList;


public class MyAdapter extends BaseAdapter {

	private final ArrayList<AddressModel> persons;
	private final Context context;

	public MyAdapter(ArrayList<AddressModel> persons, Context context) {
		this.persons = persons;
		this.context = context;
	}

	@Override
	public int getCount() {
		return persons.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		if(convertView == null){
			view = View.inflate(context, R.layout.item_addressbook, null);
		}else {
			view = convertView;
		}
		
		ViewHolder holder = ViewHolder.getHolder(view);
		AddressModel goodMan = persons.get(position);
		
		// 进行分组, 比较上一个拼音的首字母和自己是否一致, 如果不一致, 就显示tv_index
		
		String currentLetter = goodMan.getPinyin().charAt(0) + "";
		String indexStr = null;
		if(position == 0){
			// 1. 如果是第一位
			indexStr = currentLetter;
		}else {
			// 获取上一个拼音
			String preLetter = persons.get(position - 1).getPinyin().charAt(0) + "";
			if(!TextUtils.equals(currentLetter, preLetter)){
				// 2. 当跟上一个不同时, 赋值, 显示
				indexStr = currentLetter;
			}
		}
		
		holder.tv_index.setVisibility(indexStr == null ? View.GONE : View.VISIBLE);
		holder.tv_index.setText(indexStr);
		
		holder.tv_name.setText(goodMan.getName());
		return view;
	}
	
	static class ViewHolder {
		public TextView tv_index;
		public TextView tv_name;

		public static ViewHolder getHolder(View view) {
			ViewHolder holder = (ViewHolder) view.getTag();
			
			if(holder == null){
				holder = new ViewHolder();
				holder.tv_index = (TextView) view.findViewById(R.id.txt_addressbook_index);
				holder.tv_name = (TextView) view.findViewById(R.id.txt_addressbook_name);
				view.setTag(holder);
			}
			return holder;
		}
	}

}
