package com.yunhuakeji.app.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.adapter.TicketFragmentPagerAdapter;
import com.yunhuakeji.app.ui.fragment.TicketOutDateFragment;
import com.yunhuakeji.app.ui.fragment.TicketUnusedFragment;
import com.yunhuakeji.app.view.MyActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的门票
 */
public class TicketActivity extends MyActivity implements View.OnClickListener {

    @BindView(R.id.txt_ticket_goto)
    TextView txtTicketGoto;//去抢票
    @BindView(R.id.txt_ticket_workable)
    TextView txtTicketWorkable;//未使用
    @BindView(R.id.txt_ticket_outdata)
    TextView txtTicketOutdata;//已使用
    @BindView(R.id.vp_ticket)
    ViewPager vpTicket;
    private List<Fragment> fragmentList;
    private TicketUnusedFragment ticketUnusedFragment;
    private TicketOutDateFragment ticketOutDateFragment;
    private TicketFragmentPagerAdapter fragmentPagerAdapter;

    @Override
    public void initActivity() {
        setContentView(R.layout.activity_ticket);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        txtTicketGoto.setOnClickListener(this);
        txtTicketOutdata.setOnClickListener(this);
        txtTicketWorkable.setOnClickListener(this);


    }

    @Override
    public void initData() {
        fragmentList = new ArrayList<>();
        ticketOutDateFragment = new TicketOutDateFragment();
        ticketUnusedFragment = new TicketUnusedFragment();

        fragmentList.add(ticketUnusedFragment);
        fragmentList.add(ticketOutDateFragment);
        fragmentPagerAdapter = new TicketFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        vpTicket.setAdapter(fragmentPagerAdapter);


    }

    @Override
    public void initProcessor() {
        vpTicket.setOffscreenPageLimit(2);//设置缓存两个页面
        vpTicket.setCurrentItem(0);//默认打开第一页
        vpTicket.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
       /*

       当页面在滑动的时候会调用此方法，在滑动被停止之前，此方法回
       position 当前页面，及你点击滑动的页面
       positionoffset 当前页面偏移的百分比
       positionoffsetpixels 当前页面偏移的像素位置
        */
            }

            @Override
            public void onPageSelected(int position) {
                //完成时调用
                if (position == 0) {
                    txtTicketWorkable.setTextColor(ContextCompat.getColor(getContext(), R.color.color_bleu));
                    txtTicketOutdata.setTextColor(ContextCompat.getColor(getContext(), R.color.color_black));
                }
                if (position == 1) {
                    txtTicketOutdata.setTextColor(ContextCompat.getColor(getContext(), R.color.color_bleu));
                    txtTicketWorkable.setTextColor(ContextCompat.getColor(getContext(), R.color.color_black));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
         /*
          state 三个状态 0，1，2
          0 表示页面没有动
          1 正在动
          2 完成滑动
          */
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_ticket_goto:
                Toast.makeText(getContext(), "去抢票", Toast.LENGTH_LONG).show();
                break;
            case R.id.txt_ticket_workable:
                txtTicketWorkable.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                txtTicketOutdata.setTextColor(ContextCompat.getColor(this, R.color.color_black));
                vpTicket.setCurrentItem(0);
                Toast.makeText(this, "未使用", Toast.LENGTH_LONG).show();
                break;
            case R.id.txt_ticket_outdata:
                txtTicketOutdata.setTextColor(ContextCompat.getColor(this, R.color.color_bleu));
                txtTicketWorkable.setTextColor(ContextCompat.getColor(this, R.color.color_black));
                vpTicket.setCurrentItem(1);
                Toast.makeText(this, "已使用", Toast.LENGTH_LONG).show();
                break;
        }
    }

    /**
     * 结束当前
     *
     * @param view
     */
    public void back(View view) {
        finish();
    }

    //
}
