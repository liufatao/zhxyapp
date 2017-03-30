package com.yunhuakeji.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.view.MyActivity;

/**
 * 个人中心
 */
public class PersonalActivity extends MyActivity implements View.OnClickListener{


    private RelativeLayout mRlPersonalInfo;
    private ImageView mImgPersonalHead;
    private TextView mTxtPersonalUsername;
    private TextView mTxtPersonalUserId;
    private ImageView mImgPersonalRight;
    private RelativeLayout mRlPersonalShare;
    private RelativeLayout mRlPersonaTicket;
    private RelativeLayout mRlPersonaSet;
    private Button mBtnPersonaOut;


    @Override
    public void initActivity() {
        setContentView(R.layout.activity_personal);
    }

    @Override
    public void initView() {
        //个人资料
        mRlPersonalInfo = (RelativeLayout) findViewById(R.id.rl_personal_info);
        mRlPersonalInfo.setOnClickListener(this);
//        头像
        mImgPersonalHead = (ImageView) findViewById(R.id.img_personal_head);
//        昵称
        mTxtPersonalUsername = (TextView) findViewById(R.id.txt_personal_username);
//        用户账号
        mTxtPersonalUserId = (TextView) findViewById(R.id.txt_personal_userId);
//        我的分享
        mRlPersonalShare = (RelativeLayout) findViewById(R.id.rl_personal_share);
        mRlPersonalShare.setOnClickListener(this);
//        我的抢票
        mRlPersonaTicket = (RelativeLayout) findViewById(R.id.rl_persona_ticket);
        mRlPersonaTicket.setOnClickListener(this);
//        设置
        mRlPersonaSet = (RelativeLayout) findViewById(R.id.rl_persona_set);
        mRlPersonaSet.setOnClickListener(this);
//        退出登陆
        mBtnPersonaOut = (Button) findViewById(R.id.btn_persona_out);
        mBtnPersonaOut.setOnClickListener(this);
    }


    @Override
    public void initData() {

    }

    @Override
    public void initProcessor() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_persona_out:
                Toast.makeText(this, "退出", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_persona_ticket:
                Toast.makeText(this, "抢票", Toast.LENGTH_LONG).show();
                Intent ticketintent=new Intent(this,TicketActivity.class);
                startActivity(ticketintent);
                break;
            case R.id.rl_persona_set:
                Toast.makeText(this, "设置", Toast.LENGTH_LONG).show();
                Intent setintent = new Intent(this, SetActivity.class);
                startActivity(setintent);
                break;
            case R.id.rl_personal_share:
                Toast.makeText(this, "分享", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_personal_info:
                Toast.makeText(this, "个人中心", Toast.LENGTH_LONG).show();
                break;

        }
    }

}
