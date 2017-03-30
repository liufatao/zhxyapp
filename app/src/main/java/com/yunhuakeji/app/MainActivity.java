package com.yunhuakeji.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yunhuakeji.app.adapter.HomeFragmentPagerAdapter;
import com.yunhuakeji.app.ui.fragment.ApplyFragment;
import com.yunhuakeji.app.ui.fragment.DataReportFragment;
import com.yunhuakeji.app.ui.fragment.HomeFragment;
import com.yunhuakeji.app.ui.fragment.MessageFragment;
import com.yunhuakeji.app.ui.fragment.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {

    @BindView(R.id.img_home_report)
    ImageView imgHomeReport;
    @BindView(R.id.img_home_apply)
    ImageView imgHomeApply;
    @BindView(R.id.img_home_home)
    ImageView imgHomeHome;
    @BindView(R.id.img_home_message)
    ImageView imgHomeMessage;
    @BindView(R.id.img_home_personal)
    ImageView imgHomePersonal;
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.ly_home_report)
    LinearLayout lyHomeReport;
    @BindView(R.id.ly_home_apply)
    LinearLayout lyHomeApply;
    @BindView(R.id.ly_home_home)
    LinearLayout lyHomeHome;
    @BindView(R.id.ly_home_message)
    LinearLayout lyHomeMessage;
    @BindView(R.id.ly_home_personal)
    LinearLayout lyHomePersonal;
    @BindView(R.id.ly_home_bottom)
    LinearLayout lyHomeBottom;
    @BindView(R.id.txt_home_report)
    TextView txtHomeReport;
    @BindView(R.id.txt_home_apply)
    TextView txtHomeApply;
    @BindView(R.id.txt_home_home)
    TextView txtHomeHome;
    @BindView(R.id.txt_home_message)
    TextView txtHomeMessage;
    @BindView(R.id.txt_home_personal)
    TextView txtHomePersonal;
    private List<Fragment> fragmentList;
    private DataReportFragment reportFragment;//报告
    private ApplyFragment applyFragment;//我的应用
    private HomeFragment homeFragment;//主页
    private MessageFragment messageFragment;//消息
    private PersonalFragment personalFragment;//个人中心
    private HomeFragmentPagerAdapter homeFragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initinitProcessor();
    }


    /**
     * 初始化数据
     */
    private void initData() {
        reportFragment = new DataReportFragment();
        applyFragment = new ApplyFragment();
        homeFragment = new HomeFragment();
        messageFragment = new MessageFragment();
        personalFragment = new PersonalFragment();
        fragmentList = new ArrayList<>();
        fragmentList.add(reportFragment);
        fragmentList.add(applyFragment);
        fragmentList.add(homeFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(personalFragment);
        homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        vpHome.setOffscreenPageLimit(3);//设置缓存多少个
        vpHome.setAdapter(homeFragmentPagerAdapter);
        vpHome.setCurrentItem(2);//默认显示页


    }

    /**
     * 处理器
     */
    private void initinitProcessor() {
        lyHomeApply.setOnClickListener(this);
        lyHomeHome.setOnClickListener(this);
        lyHomeMessage.setOnClickListener(this);
        lyHomeReport.setOnClickListener(this);
        lyHomePersonal.setOnClickListener(this);

        vpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onChangerState(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    /**
     * 恢复所以按钮状态
     */
    private void onRecover() {
        imgHomeReport.setImageResource(R.mipmap.ico_report_normal);
        txtHomeReport.setTextColor(ContextCompat.getColor(this, R.color.color_darkgrey));
        imgHomePersonal.setImageResource(R.mipmap.ico_personal_normal);
        txtHomePersonal.setTextColor(ContextCompat.getColor(this, R.color.color_darkgrey));
        imgHomeMessage.setImageResource(R.mipmap.ico_message_normal);
        txtHomeMessage.setTextColor(ContextCompat.getColor(this, R.color.color_darkgrey));
        imgHomeApply.setImageResource(R.mipmap.ico_apply_normal);
        txtHomeApply.setTextColor(ContextCompat.getColor(this, R.color.color_darkgrey));
        imgHomeHome.setImageResource(R.mipmap.ico_home_normal);
        txtHomeHome.setTextColor(ContextCompat.getColor(this, R.color.color_darkgrey));
    }

    /**
     * 改变底部按钮状态
     */
    private void onChangerState(int state) {
        onRecover();
        switch (state) {
            case 0:
                imgHomeReport.setImageResource(R.mipmap.ico_report_pressed);
                txtHomeReport.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                break;
            case 1:
                imgHomeApply.setImageResource(R.mipmap.ico_apply_presse);
                txtHomeApply.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                break;
            case 2:
                imgHomeHome.setImageResource(R.mipmap.ico_home_pressed);
                txtHomeHome.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                break;
            case 3:
                imgHomeMessage.setImageResource(R.mipmap.ico_message_pressed);
                txtHomeMessage.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                break;
            case 4:
                imgHomePersonal.setImageResource(R.mipmap.ico_personal_presse);
                txtHomePersonal.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                break;
        }
    }

    @Override
    public void onClick(View v) {

        onRecover();
        switch (v.getId()) {
            case R.id.ly_home_report:

                imgHomeReport.setImageResource(R.mipmap.ico_report_pressed);
                txtHomeReport.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                vpHome.setCurrentItem(0,true);

                break;
            case R.id.ly_home_apply:

                imgHomeApply.setImageResource(R.mipmap.ico_apply_presse);
                txtHomeApply.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                vpHome.setCurrentItem(1,true);
                break;
            case R.id.ly_home_home:

                imgHomeHome.setImageResource(R.mipmap.ico_home_pressed);
                txtHomeHome.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                vpHome.setCurrentItem(2, true);
                break;
            case R.id.ly_home_message:

                imgHomeMessage.setImageResource(R.mipmap.ico_message_pressed);
                txtHomeMessage.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                vpHome.setCurrentItem(3, true);
                break;
            case R.id.ly_home_personal:

                imgHomePersonal.setImageResource(R.mipmap.ico_personal_presse);
                txtHomePersonal.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                vpHome.setCurrentItem(4, true);
                break;

        }

    }

}
