package com.yunhuakeji.app.ui.activity;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.constants.YunHuaUrl;
import com.yunhuakeji.app.http.VolleyInterface;
import com.yunhuakeji.app.http.VolleyRequest;
import com.yunhuakeji.app.view.MyActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MyActivity {

    @BindView(R.id.et_login_account)
    TextInputEditText etLoginAccount;
    @BindView(R.id.txtinputlayout_login_account)
    TextInputLayout txtinputlayoutLoginAccount;
    @BindView(R.id.et_login_pwd)
    TextInputEditText etLoginPwd;
    @BindView(R.id.txtinputlayout_login_pwd)
    TextInputLayout txtinputlayoutLoginPwd;
    @BindView(R.id.btn_login_submit)
    Button btnLoginSubmit;
    @BindView(R.id.txt_login_seekpassword)
    TextView txtLoginSeekpassword;
    private String user_name = null;
    private String user_password = null;

    @Override
    protected void initActivity() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initProcessor() {
        etLoginAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("输入前", "CharSequence" + s + "start" + start + "count" + count + "after" + after);
                //输入后

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //输入中
                Log.e("输入中", "CharSequence" + s + "start" + start + "count" + count);
                if (s.length() > 0) {
                    txtinputlayoutLoginAccount.setErrorEnabled(false);
                    return;
                } else {
                    txtinputlayoutLoginAccount.setError(getResources().getString(R.string.str_login_account_error));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //输入后
                Log.e("输入中", "CharSequence" + s);
            }
        });
        etLoginPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 6 && s.length() <= 16) {
                    txtinputlayoutLoginPwd.setErrorEnabled(false);
                    return;
                } else {
                    txtinputlayoutLoginPwd.setError(getResources().getString(R.string.str_login_accountpasswor_error));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    /**
     * 登录
     */
    private void onLogin() {
        user_name = etLoginAccount.getText().toString();
        user_password = etLoginPwd.getText().toString();

        //判断用户名和密码是否为空

        if (TextUtils.isEmpty(user_name)) {
            //用户名为空给用户提示
            txtinputlayoutLoginAccount.setError(getResources().getString(R.string.str_login_account_error));
            return;
        } else {
            //关闭消息提示
            txtinputlayoutLoginAccount.setErrorEnabled(false);


        }
        if (TextUtils.isEmpty(user_password)) {
            //用户名密码为空给用户提示
            txtinputlayoutLoginPwd.setError(getResources().getString(R.string.str_login_accountpasswor_error));
            return;
        } else {
            //关闭消息提示
            txtinputlayoutLoginPwd.setErrorEnabled(false);
        }
        Map<String, String> map = new HashMap<>();
        map.put("userid",user_name);
        map.put("password",user_password);
        VolleyRequest.RequestPost(YunHuaUrl.USERINFO_URL_GETSTUDENTINFO, "login", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                //成功
                Log.d("登录成",result);
                Toast.makeText(LoginActivity.this,"成功",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMyError(VolleyError error) {
                //失败
                Toast.makeText(LoginActivity.this,"失败",Toast.LENGTH_LONG).show();
            }
        });
    }

    @OnClick({R.id.btn_login_submit, R.id.txt_login_seekpassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login_submit:
                //登录
                onLogin();
                Toast.makeText(this,"登录",Toast.LENGTH_LONG).show();
                break;
            case R.id.txt_login_seekpassword:
//                找回密码
                break;
        }
    }
}
