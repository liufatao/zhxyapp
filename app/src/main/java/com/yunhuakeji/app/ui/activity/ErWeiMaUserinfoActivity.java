package com.yunhuakeji.app.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.WriterException;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.constants.YunHuaUrl;
import com.yunhuakeji.app.view.MyActivity;
import com.yunhuakeji.app.zxingerweima.ErWeiMaUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 用户二维码页面
 * 二维码添加好友
 */
public class ErWeiMaUserinfoActivity extends MyActivity {

    @BindView(R.id.img_userinfo_erweima_userphoto)
    ImageView imgUserinfoErweimaUserphoto;
    @BindView(R.id.txt_userinfo_erweima_username)
    TextView txtUserinfoErweimaUsername;
    @BindView(R.id.img_erweima_erweima)
    ImageView imgErweimaErweima;
    private Bitmap erweimabitmap;

    @Override
    protected void initActivity() {
        setContentView(R.layout.activity_er_wei_ma_userinfo);
        ButterKnife.bind(this);

    }

    @Override
    protected void initView() {
        //二维码中间logo
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ico_logo);
//        Bitmap bitmap =ErWeiMaUtil.decodeBitmap(Environment.getExternalStorageDirectory().toString()+"/hand.jpg",252,252);
        //二维码背景图片
        Bitmap bitmapbg = BitmapFactory.decodeResource(getResources(), R.mipmap.ico_erweimabg);
        try {
            erweimabitmap = ErWeiMaUtil.addBackground(ErWeiMaUtil.makeQRImageCaise(bitmap, YunHuaUrl.USERINFO_URL_ERWEIMA+ Constants.userId, 300, 300), bitmapbg);
            imgErweimaErweima.setImageBitmap(erweimabitmap);
        } catch (WriterException e) {
            Log.e("生成二维码异常", e.toString());
        }


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initProcessor() {

    }

    /**
     * 退出当前
     *
     * @param view
     */
    public void back(View view) {
        finish();
    }


}
