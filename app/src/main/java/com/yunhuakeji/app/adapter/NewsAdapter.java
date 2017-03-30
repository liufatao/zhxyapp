package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.view.DragPointView;

import java.util.List;

/**
 * 消息适配器
 */

public class NewsAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;
    private ImageView imgNewsItemHead;
    private TextView txtNewsItemNickname;
    private TextView txtNewsItemContent;
    private DragPointView txtNewsItemCount;
    private TextView txtNewsItemTime;

    public NewsAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news_listview, parent, false);
            viewHolder.imgNewsItemHead = (ImageView) convertView.findViewById(R.id.img_news_item_head);
            viewHolder.txtNewsItemNickname = (TextView) convertView.findViewById(R.id.txt_news_item_nickname);
            viewHolder.txtNewsItemContent = (TextView) convertView.findViewById(R.id.txt_news_item_content);
            viewHolder.txtNewsItemCount = (DragPointView) convertView.findViewById(R.id.txt_news_item_count);
            viewHolder.txtNewsItemTime = (TextView) convertView.findViewById(R.id.txt_news_item_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtNewsItemCount.setText(list.get(position));
        return convertView;
    }




    class ViewHolder {
        TextView txtNewsItemNickname, txtNewsItemContent, txtNewsItemCount,txtNewsItemTime;
        ImageView imgNewsItemHead;
    }
}
