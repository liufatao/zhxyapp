package com.yunhuakeji.app.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.yunhuakeji.app.MainActivity;
import com.yunhuakeji.app.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * 开机启动页
 */
public class WelcomeActivity extends AppCompatActivity {
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SharedPreferences sharedPreferences = this.getSharedPreferences("share", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        editor = sharedPreferences.edit();


        if (isFirstRun) {
            editor.putBoolean("isFirstRun", false).commit();
            gotoGuide();
        } else {
            gotoMainActivity();
        }


    }

    /**
     * 转到主页
     */
    private void gotoMainActivity() {

        Observable.timer(3, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(@NonNull Long aLong) throws Exception {
                Intent mainintent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(mainintent);
                finish();
            }
        });
    }

    /**
     * 跳转到引导页
     */
    private void gotoGuide() {

        Intent intentguide = new Intent(this, GuideActivity.class);
        startActivity(intentguide);
        finish();
    }
}
