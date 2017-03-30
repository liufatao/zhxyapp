package com.yunhuakeji.app.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.view.MyActivity;

/**
 * 设置
 */
public class SetActivity extends MyActivity implements View.OnClickListener
{

    private android.widget.RelativeLayout mRlSetUpdatepwd;
    private android.widget.RelativeLayout mRlSetHide;
    private android.widget.RelativeLayout mRlSetFeedback;
    private android.widget.RelativeLayout mRlSetAbout;

    @Override
    public void initActivity() {
        setContentView(R.layout.activity_set);
    }

    @Override
    public void initView() {
        //修改密码
        mRlSetUpdatepwd = (RelativeLayout) findViewById(R.id.rl_set_updatepwd);
        mRlSetUpdatepwd.setOnClickListener(this);
//        隐私
        mRlSetHide = (RelativeLayout) findViewById(R.id.rl_set_hide);
        mRlSetHide.setOnClickListener(this);
//        意见反馈
        mRlSetFeedback = (RelativeLayout) findViewById(R.id.rl_set_feedback);
        mRlSetFeedback.setOnClickListener(this);
//        关于
        mRlSetAbout = (RelativeLayout) findViewById(R.id.rl_set_about);
        mRlSetAbout.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initProcessor() {

    }

    //关闭当前
    public void back(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.rl_set_about:
                Toast.makeText(this, "关于", Toast.LENGTH_LONG).show();
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.rl_set_feedback:
                Toast.makeText(this, "意见反馈", Toast.LENGTH_LONG).show();
                Intent feedbackIntent = new Intent(this, FeedBackActivity.class);
                startActivity(feedbackIntent);
                break;
            case R.id.rl_set_hide:
                Toast.makeText(this, "隐私", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_set_updatepwd:
                Toast.makeText(this, "修改密码", Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }
    }
}
