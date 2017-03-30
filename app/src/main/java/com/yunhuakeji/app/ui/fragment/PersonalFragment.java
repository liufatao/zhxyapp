package com.yunhuakeji.app.ui.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.ui.activity.SetActivity;
import com.yunhuakeji.app.ui.activity.TicketActivity;
import com.yunhuakeji.app.ui.activity.UserInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人中心
 */
public class PersonalFragment extends Fragment {


    @BindView(R.id.txt_personal_username)
    TextView txtPersonalUsername;
    @BindView(R.id.txt_personal_userId)
    TextView txtPersonalUserId;
    @BindView(R.id.img_personal_right)
    ImageView imgPersonalRight;
    @BindView(R.id.rl_personal_info)
    RelativeLayout rlPersonalInfo;
    @BindView(R.id.rl_personal_share)
    RelativeLayout rlPersonalShare;
    @BindView(R.id.rl_persona_ticket)
    RelativeLayout rlPersonaTicket;
    @BindView(R.id.rl_persona_set)
    RelativeLayout rlPersonaSet;

    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
    }

    @OnClick({R.id.img_personal_head, R.id.txt_personal_username, R.id.txt_personal_userId, R.id.img_personal_right, R.id.rl_personal_info, R.id.rl_personal_share, R.id.rl_persona_ticket, R.id.rl_persona_set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_personal_head:
                break;
            case R.id.txt_personal_username:
                break;
            case R.id.txt_personal_userId:
                break;
            case R.id.img_personal_right:
                break;
            case R.id.rl_personal_info:
                Intent userinfointent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(userinfointent);
                Toast.makeText(activity, "个人中心", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_personal_share:
                Toast.makeText(activity, "分享", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_persona_ticket:
                Toast.makeText(activity, "抢票", Toast.LENGTH_LONG).show();
                Intent ticketintent = new Intent(activity, TicketActivity.class);
                startActivity(ticketintent);
                break;
            case R.id.rl_persona_set:
                Toast.makeText(activity, "设置", Toast.LENGTH_LONG).show();
                Intent setintent = new Intent(activity, SetActivity.class);
                startActivity(setintent);
                break;

        }
    }
}
