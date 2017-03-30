package com.yunhuakeji.app.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

import com.chechezhi.ui.guide.AbsGuideActivity;
import com.chechezhi.ui.guide.SinglePage;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.ui.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * app 引导页
 * 使用 guideshowlib 实现
 */
public class GuideActivity extends AbsGuideActivity {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    public List<SinglePage> buildGuideContent() {
        //构建引导页的各个页面，每个页面用SinglePage来描述
        List<SinglePage> singlePages=new ArrayList<>();
        SinglePage page=new SinglePage();
        SinglePage page2=new SinglePage();
        SinglePage pag3=new SinglePage();
        SinglePage pag4=new SinglePage();
        page.mBackground= ContextCompat.getDrawable(this,R.mipmap.ico_guide1);
        page2.mBackground= ContextCompat.getDrawable(this,R.mipmap.ico_guide2);
        pag3.mBackground= ContextCompat.getDrawable(this,R.mipmap.ico_guide3);
        pag4.mCustomFragment=new GuideFragment();
        singlePages.add(page);
        singlePages.add(page2);
        singlePages.add(pag3);
        singlePages.add(pag4);
        return singlePages;
    }

    @Override
    public boolean drawDot() {
//       是否显示dot
        return true;
    }

    @Override
    public Bitmap dotDefault() {
        //设置dot 未选中时的图片
        return BitmapFactory.decodeResource(getResources(),R.mipmap.ic_dot_default);
    }

    @Override
    public Bitmap dotSelected() {
        //设置dot 选中时的图片

        return BitmapFactory.decodeResource(getResources(),R.mipmap.ic_dot_selected);
    }

    @Override
    public int getPagerId() {
        //你需要在资源描述中添加<item name="guide_container" type="id"/>
        return R.id.guide_container;
    }
    public void entryApp(){
       finish();
    }
}
