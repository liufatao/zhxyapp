package com.yunhuakeji.app.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.util.PackAganmanger;
import com.yunhuakeji.app.view.MyActivity;

import static com.yunhuakeji.app.util.PackAganmanger.getAppIcon;
import static com.yunhuakeji.app.util.PackAganmanger.getAppName;
import static com.yunhuakeji.app.util.PackAganmanger.getAppVersionName;

/**
 * 关于页面
 */
public class AboutActivity extends MyActivity implements View.OnClickListener {


    private android.widget.ImageView mImgAboutLogo;
    private android.widget.TextView mTxtAboutVersion;
    private android.widget.RelativeLayout mRlAboutScore;
    private android.widget.RelativeLayout mRlAboutFunction;
    private android.widget.RelativeLayout mRlAboutNotic;
    private android.widget.RelativeLayout mRlAboutComplaint;
    private PackAganmanger packAganmanger;
    @Override
    public void initActivity() {
        setContentView(R.layout.activity_about);
    }

    @Override
    public void initView() {
//        应用图标
        mImgAboutLogo = (ImageView) findViewById(R.id.img_about_logo);
//        版本号
        mTxtAboutVersion = (TextView) findViewById(R.id.txt_about_version);
//        去评分
        mRlAboutScore = (RelativeLayout) findViewById(R.id.rl_about_score);
        mRlAboutScore.setOnClickListener(this);
//        功能介绍
        mRlAboutFunction = (RelativeLayout) findViewById(R.id.rl_about_function);
        mRlAboutFunction.setOnClickListener(this);
//        系统通知
        mRlAboutNotic = (RelativeLayout) findViewById(R.id.rl_about_notic);
        mRlAboutNotic.setOnClickListener(this);
//        投诉
        mRlAboutComplaint = (RelativeLayout) findViewById(R.id.rl_about_complaint);
        mRlAboutComplaint.setOnClickListener(this);

        packAganmanger=new PackAganmanger(AboutActivity.this);

    }

    @Override
    public void initData() {
        mImgAboutLogo.setImageDrawable(getAppIcon());
        mTxtAboutVersion.setText(getAppName()+getAppVersionName());

    }

    @Override
    public void initProcessor() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_about_complaint:
                Toast.makeText(this, "投诉", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_about_function:
                Toast.makeText(this, "功能介绍", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_about_notic:
                Toast.makeText(this, "系统通知", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_about_score:
                Toast.makeText(this, "去评分", Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }
    }

    // 退出当前
    public void back(View view) {
        finish();
    }


}
