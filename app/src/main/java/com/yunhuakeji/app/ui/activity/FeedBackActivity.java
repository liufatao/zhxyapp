package com.yunhuakeji.app.ui.activity;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.constants.YunHuaUrl;
import com.yunhuakeji.app.http.VolleyInterface;
import com.yunhuakeji.app.http.VolleyRequest;
import com.yunhuakeji.app.util.StringUtil;
import com.yunhuakeji.app.view.MyActivity;
import com.yunhuakeji.app.widget.ClearEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 意见反馈
 */
public class FeedBackActivity extends MyActivity implements View.OnClickListener {


    @BindView(R.id.rg_feedback_rdmanage)
    RadioGroup rgFeedbackRdmanage;
    @BindView(R.id.et_feedback_idea)
    TextInputEditText etFeedbackIdea;
    @BindView(R.id.txt_feedback_phone)
    TextView txtFeedbackPhone;
    @BindView(R.id.til_feedback_phone)
    TextInputLayout tilFeedbackPhone;
    @BindView(R.id.btn_feedback_submit)
    Button btnFeedbackSubmit;
    @BindView(R.id.til_feedback_idea)
    TextInputLayout tilFeedbackIdea;
    @BindView(R.id.et_feedback_phone)
    ClearEditText etFeedbackPhone;
    @BindView(R.id.activity_feed_back)
    LinearLayout activityFeedBack;
    private String phonenumber;//反馈电话号码
    private String grade="非常满意";//评分
    private String suggest="";//建议
    @Override
    public void initActivity() {
        setContentView(R.layout.activity_feed_back);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        btnFeedbackSubmit.setOnClickListener(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initProcessor() {


        tilFeedbackIdea.getEditText().addTextChangedListener(new MinLengthWatch(getResources().getString(R.string.str_feedback_maxlength), tilFeedbackIdea));
        tilFeedbackIdea.setCounterEnabled(true);//开启计时器
        tilFeedbackIdea.setCounterMaxLength(200);
        rgFeedbackRdmanage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                int rbId = group.getCheckedRadioButtonId();// 取得获取焦点的RadionButton控件Id
                RadioButton radioButton = (RadioButton) findViewById(rbId);// 获得相应的RadioButton控件
                grade=radioButton.getText().toString();
                Toast.makeText(FeedBackActivity.this, radioButton.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_feedback_submit:
                if(StringUtil.isPhoneNumber(etFeedbackPhone.getText()+"")){
                    setSubmit();
                 }else {
                    etFeedbackPhone.setShakeAnimation();
                }
                break;
        }
    }

    /**
     * 提交反馈
     */
    private void setSubmit(){
        phonenumber=etFeedbackPhone.getText().toString();
        suggest=etFeedbackIdea.getText().toString();

        Map<String,String> map=new HashMap<>();
        map.put("userid", Constants.userId);
        map.put("ticket",Constants.ticket);
        map.put("phonenumber",phonenumber);
        map.put("degreeofsatisfaction",grade);
        map.put("suggestions",suggest);

        VolleyRequest.RequestPost(YunHuaUrl.SET_URL_FEEDBACKSUGGESTIONS, "feedback", map, new VolleyInterface(VolleyInterface.mListener,VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
              //
                Toast.makeText(FeedBackActivity.this,R.string.str_feedback_succeed,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMyError(VolleyError error) {
                Toast.makeText(FeedBackActivity.this,R.string.str_feedback_error,Toast.LENGTH_LONG).show();
            }
        });
    }
    public void back(View view) {
        finish();
    }


}

class MinLengthWatch implements TextWatcher {
    private String errstr;
    private TextInputLayout textInputLayout;

    MinLengthWatch(String errstr, TextInputLayout textInputLayout) {
        this.errstr = errstr;
        this.textInputLayout = textInputLayout;

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        //检查长度是否符合标准
        if (textInputLayout.getEditText().getText().toString().length() <= 200) {

        } else {

            textInputLayout.setError(errstr);
        }
    }
}
