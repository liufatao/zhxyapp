package com.yunhuakeji.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yunhuakeji.app.R;

import java.util.List;

/**
 * Created by liufatao on 2017/3/9.
 */

public class TicketOutDateAdapter extends RecyclerView.Adapter<TicketOutDateAdapter.MyViewHolder> {
    private List<String > list;
    private Context context;
    private LayoutInflater inflater;

    public TicketOutDateAdapter(Context context, List<String > list){
        this.list=list;
        this.context=context;
        inflater= LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder=new MyViewHolder(inflater.inflate(R.layout.item_ticket_outdate_recyclerview,parent,false));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txtTicketSeat.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTicketSeat;
        TextView txtTicketCathedraname;
        TextView txtTicketCathedrtime;
        TextView txtTicketCathedradder;
        TextView txtTicketState;
        LinearLayout lyTicket;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTicketSeat = (TextView) itemView.findViewById(R.id.txt_ticket_seat);
            txtTicketCathedraname = (TextView) itemView.findViewById(R.id.txt_ticket_cathedraname);
            txtTicketCathedrtime = (TextView) itemView.findViewById(R.id.txt_ticket_cathedrtime);
            txtTicketCathedradder = (TextView) itemView.findViewById(R.id.txt_ticket_cathedradder);
            txtTicketState = (TextView) itemView.findViewById(R.id.txt_ticket_state);
            lyTicket = (LinearLayout) itemView.findViewById(R.id.ly_ticket);

        }
    }


    // 如果设置了回调，则设置点击事件
//        if (mOnItemClickLitener != null)
//    {
//        holder.itemView.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                int pos = holder.getLayoutPosition();
//                mOnItemClickLitener.onItemClick(holder.itemView, pos);
//            }
//        });
//
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
//        {
//            @Override
//            public boolean onLongClick(View v)
//            {
//                int pos = holder.getLayoutPosition();
//                mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
//                return false;
//            }
//        });
//    }

//    public interface OnItemClickLitener
//    {
//        void onItemClick(View view, int position);
//        void onItemLongClick(View view , int position);
//    }
//
//    private OnItemClickLitener mOnItemClickLitener;
//
//    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
//    {
//        this.mOnItemClickLitener = mOnItemClickLitener;
//    }
}
