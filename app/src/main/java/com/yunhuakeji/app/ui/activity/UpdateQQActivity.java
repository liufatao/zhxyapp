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
import com.yunhuakeji.app.widget.ClearEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateQQActivity extends AppCompatActivity {

    @BindView(R.id.txt_userinfo_save)
    TextView txtUserinfoSave;
    @BindView(R.id.edt_userinfo_qq)
    ClearEditText edtUserinfoQq;
    private String qq = null;


    private final int QQ_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_qq);
        ButterKnife.bind(this);
        qq = getIntent().getStringExtra("qq");
        initProcesso();
    }

    /**
     * 处理器
     */
    private void initProcesso() {
        edtUserinfoQq.setText(qq);
    }

    /**
     * 提交修改QQ
     * 提交数据
     */
    private void submitNickName(String qq) {
        Map<String, String> map = new HashMap<>();
        map.put("userid", Constants.userId);
        map.put("ticket", Constants.ticket);
        map.put("QQ", qq);
        VolleyRequest.RequestPost(YunHuaUrl.USERINFO_URL_UPDATESTUDENTQQ, "qq", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
//                        成功
                Intent intentqq=new Intent();
                intentqq.putExtra("qq",edtUserinfoQq.getText().toString());
                setResult(QQ_CODE,intentqq);
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
                qq = edtUserinfoQq.getText().toString();
                if (!qq.isEmpty()){
                    submitNickName(qq);
                }else {
                    edtUserinfoQq.setShakeAnimation();
                    Toast.makeText(this,R.string.str_null,Toast.LENGTH_LONG).show();
                }

                break;
        }

    }
}
