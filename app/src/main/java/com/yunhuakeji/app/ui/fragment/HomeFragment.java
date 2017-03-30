package com.yunhuakeji.app.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.yunhuakeji.app.R;
import com.yunhuakeji.app.util.AnimationUtil;
import com.yunhuakeji.app.widget.FloatingDraftButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 主页
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.floatingActionButton)
    FloatingDraftButton floatingActionButton;
    @BindView(R.id.floatingActionButton_liveness)
    FloatingActionButton floatingActionButtonLiveness;
    @BindView(R.id.floatingActionButton_2)
    FloatingActionButton floatingActionButton2;
    Unbinder unbinder;
    @BindView(R.id.rl_floatbutton)
    RelativeLayout rlFloatbutton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        floatingActionButton.registerButton(floatingActionButtonLiveness);
        floatingActionButton.registerButton(floatingActionButton2);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //弹出动态Button
                AnimationUtil.slideButtons(getContext(), floatingActionButton);


            }
        });
        floatingActionButtonLiveness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationUtil.slideButtons(getContext(), floatingActionButton);
                Toast.makeText(getContext(), "liveness", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
