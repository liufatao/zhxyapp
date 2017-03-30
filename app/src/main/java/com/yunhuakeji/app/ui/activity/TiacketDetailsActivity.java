package com.yunhuakeji.app.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.view.MyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的门票详情
 */
public class TiacketDetailsActivity extends MyActivity {


    @BindView(R.id.txt_ticketdetails_cathedraname)
    TextView txtTicketdetailsCathedraname;
    @BindView(R.id.txt_ticketdetails_cathedrtime)
    TextView txtTicketdetailsCathedrtime;
    @BindView(R.id.txt_ticketdetails_cathedradder)
    TextView txtTicketdetailsCathedradder;
    @BindView(R.id.txt_ticketdetails_author)
    TextView txtTicketdetailsAuthor;
    @BindView(R.id.img_ticketdetails_describe)
    ImageView imgTicketdetailsDescribe;
    @BindView(R.id.img_ticketdetails_erweima)
    ImageView imgTicketdetailsErweima;
    @BindView(R.id.txt_ticketdetails_serialnumber)
    TextView txtTicketdetailsSerialnumber;
    @BindView(R.id.txt_ticketdetails_authcode)
    TextView txtTicketdetailsAuthcode;

    @Override
    public void initActivity() {
        setContentView(R.layout.activity_tiacket_details);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initProcessor() {

    }

   public void back(View view){
       finish();
   }
}
