package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.model.DataReportModel;
import com.yunhuakeji.app.view.ScrollGridview;

import java.util.List;


/**
 * 数据报告Listview 适配器
 *
 * @author Administrator
 */
public class DataReportListviewAdapter extends RecyclerView.Adapter<DataReportListviewAdapter.MyViewHolder> {
    private List<DataReportModel.ContentBean.OtherAppBean> list;
    private Context context;
    private LayoutInflater inflater;

    public DataReportListviewAdapter(Context context, List<DataReportModel.ContentBean.OtherAppBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(inflater.inflate(R.layout.listview_datareport_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        setViewData(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

  class MyViewHolder extends RecyclerView.ViewHolder {
        ScrollGridview msg_datareport_listitem;
        TextView mTxt_datareport_appname;

        public MyViewHolder(View itemView) {
            super(itemView);
            msg_datareport_listitem = (ScrollGridview) itemView.findViewById(R.id.sg_datareport_listitem);
            mTxt_datareport_appname = (TextView) itemView.findViewById(R.id.txt_datareport_appname);
        }
    }

    /**
     * 数据绑定
     *
     * @param holder
     * @param position
     */
    private void setViewData(MyViewHolder holder, int position) {
        DataReportModel.ContentBean.OtherAppBean bean = list.get(position);
        final int p = position;
        if (!TextUtils.isEmpty(bean.getName())) {
            holder.mTxt_datareport_appname.setText(bean.getName());
            // 给listview item条目 GridView 绑定数据
            DataReportGridViewAdapter gridViewAdapter = new DataReportGridViewAdapter(context, bean.getList());
            holder.msg_datareport_listitem.setAdapter(gridViewAdapter);
            holder.msg_datareport_listitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
        }

    }

}
