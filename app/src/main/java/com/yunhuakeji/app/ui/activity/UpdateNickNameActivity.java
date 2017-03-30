package com.yunhuakeji.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
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

/**
 * 修改用户昵称
 */
public class UpdateNickNameActivity extends AppCompatActivity {

    @BindView(R.id.txt_userinfo_save)
    TextView txtUserinfoSave;
    @BindView(R.id.ly_persona_title)
    RelativeLayout lyPersonaTitle;
    @BindView(R.id.edt_userinfo_nickname)
    ClearEditText edtUserinfoNickname;
    String nickname = null;
    private final int NICKNAME_CODE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_nickname);
        ButterKnife.bind(this);
        nickname = getIntent().getStringExtra("nickename");
        initProcesso();
    }

    /**
     * 处理器
     */
    private void initProcesso() {
        edtUserinfoNickname.setText(nickname);
    }

    /**
     * 提交修改昵称
     * 提交数据
     */
    private void submitNickName(String nickname) {
        Map<String, String> map = new HashMap<>();
        map.put("userid", Constants.userId);
        map.put("ticket", Constants.ticket);
        map.put("petname", nickname);
        VolleyRequest.RequestPost(YunHuaUrl.USERINFO_URL_UPDATASTUDENTPETNAME, "nickname", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
//             成功
                Log.e("修改昵称",result);
                Intent intentnickname=new Intent(UpdateNickNameActivity.this,UserInfoActivity.class);
                intentnickname.putExtra("nickename",edtUserinfoNickname.getText().toString());
                setResult(NICKNAME_CODE,intentnickname);
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
     *
     * @param view
     */
    public void back(View view) {
        finish();
    }

    @OnClick(R.id.txt_userinfo_save)
    public void onClick(View view) {
        switch (view.getId()) {
            //保存提交昵称
            case R.id.txt_userinfo_save:
                nickname = edtUserinfoNickname.getText().toString();
                if (!nickname.isEmpty()) {
                    submitNickName(nickname);
                } else {
                    edtUserinfoNickname.setShakeAnimation();
                    Toast.makeText(this,R.string.str_null,Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
}
