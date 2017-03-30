package com.yunhuakeji.app.ui.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.ui.activity.TiacketDetailsActivity;
import com.yunhuakeji.app.adapter.TicketOutDateAdapter;
import com.yunhuakeji.app.listener.RecyclerItemClickListener;
import com.yunhuakeji.app.listener.RecyclerviewListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicketOutDateFragment extends Fragment {


    @BindView(R.id.rv_ticket_data)
    RecyclerView rvTicketData;
    private Activity activity;
    private TicketOutDateAdapter outDateAdapter;
    private List<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ticket_out_date, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        rvTicketData.setLayoutManager(new LinearLayoutManager(activity));

        initData();
    }

    private void initData() {

        list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add("座");
        }
        outDateAdapter = new TicketOutDateAdapter(activity, list);
        rvTicketData.setAdapter(outDateAdapter);

        rvTicketData.addOnItemTouchListener(new RecyclerItemClickListener(activity, new RecyclerviewListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent ticketintent = new Intent(activity, TiacketDetailsActivity.class);
                startActivity(ticketintent);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
    }
}
