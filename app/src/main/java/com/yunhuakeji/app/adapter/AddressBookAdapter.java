package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.model.AddressModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 通讯录适配器
 */

public class AddressBookAdapter extends BaseAdapter {
    private List<AddressModel> list;
    private Context context;
    private LayoutInflater inflater;

    public AddressBookAdapter(Context context, List<AddressModel> list) {
        this.list = list;
        this.context = context;
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
            convertView = inflater.inflate(R.layout.item_addressbook, parent, false);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 进行分组, 比较上一个拼音的首字母和自己是否一致, 如果不一致, 就显示tv_index
        String currentLetter = list.get(position).getPinyin().charAt(0) + "";
        String indexStr = null;
        if (position == 0) {
            // 1. 如果是第一位
            indexStr = currentLetter;
        } else {
            // 获取上一个拼音
            String preLetter = list.get(position - 1).getPinyin().charAt(0) + "";
            if (!TextUtils.equals(currentLetter, preLetter)) {
                // 2. 当跟上一个不同时, 赋值, 显示
                indexStr = currentLetter;
            }
        }

        viewHolder.txtAddressbookIndex.setVisibility(indexStr == null ? View.GONE : View.VISIBLE);
        viewHolder.txtAddressbookIndex.setText(indexStr);
        viewHolder.txtAddressbookName.setText(list.get(position).getName());
        viewHolder.imgAddressbookUserphoto.setImageResource(R.mipmap.ico_userhand);

        return convertView;
    }


    class ViewHolder {
        @BindView(R.id.txt_addressbook_index)
        TextView txtAddressbookIndex;
        @BindView(R.id.img_addressbook_userphoto)
        ImageView imgAddressbookUserphoto;
        @BindView(R.id.txt_addressbook_name)
        TextView txtAddressbookName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
