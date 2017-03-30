package com.yunhuakeji.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.constants.YunHuaUrl;
import com.yunhuakeji.app.http.VolleyInterface;
import com.yunhuakeji.app.http.VolleyRequest;
import com.yunhuakeji.app.util.StringUtil;
import com.yunhuakeji.app.widget.ClearEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdatePhoneActivity extends AppCompatActivity {

    @BindView(R.id.txt_userinfo_save)
    TextView txtUserinfoSave;
    @BindView(R.id.edt_userinfo_phonenumber)
    ClearEditText edtUserinfoPhonenumber;
    private String phonenumber = null;

    private final int PHONENUMBER_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_phone);
        ButterKnife.bind(this);
        phonenumber = getIntent().getStringExtra("phonenumber");
        initProcesso();
    }

    /**
     * 处理器
     */
    private void initProcesso() {
        edtUserinfoPhonenumber.setText(phonenumber);
    }

    /**
     * 提交修改电话号码
     * 提交数据
     */
    private void submitNickName(String phonenumber) {
        Map<String, String> map = new HashMap<>();
        map.put("userid", Constants.userId);
        map.put("ticket", Constants.ticket);
        map.put("phonenumber", phonenumber);
        VolleyRequest.RequestPost(YunHuaUrl.USERINFO_URL_UPDATESTUDENTPHONENUMBER, "phone", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
//              成功
                Intent intentphonenumber=new Intent();
                intentphonenumber.putExtra("phonenumber",edtUserinfoPhonenumber.getText().toString());
                setResult(PHONENUMBER_CODE,intentphonenumber);
                finish();
            }

            @Override
            public void onMyError(VolleyError error) {
//                      失败
            }
        });
    }

    /**
     * 退出当前
     * @param view
     */
    public void back(View view) {
        finish();
    }

    @OnClick(R.id.txt_userinfo_save)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_userinfo_save:
                phonenumber = edtUserinfoPhonenumber.getText().toString();
                if (StringUtil.isPhoneNumber(phonenumber)){
                    submitNickName(phonenumber);
                }else {
                    //晃动窗体
                    edtUserinfoPhonenumber.setShakeAnimation();
                    Toast.makeText(this,R.string.str_phone_error,Toast.LENGTH_LONG).show();
                }


                break;
        }
    }
}
