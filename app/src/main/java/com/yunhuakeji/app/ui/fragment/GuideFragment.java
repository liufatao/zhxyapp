package com.yunhuakeji.app.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yunhuakeji.app.MainActivity;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.ui.activity.GuideActivity;

/**
 * Guide 最后一页
 */
public class GuideFragment extends Fragment implements View.OnClickListener {


    Button btnInto;//点击进入应用
    GuideActivity guideActivity;//用于关闭引导页

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnInto = (Button) getView().findViewById(R.id.btn_into);
        btnInto.setOnClickListener(this);
        guideActivity = new GuideActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_into:
                Intent mainintent = new Intent(getContext(), MainActivity.class);
                startActivity(mainintent);
                guideActivity.entryApp();
                getActivity().finish();
                break;
        }
    }
}
