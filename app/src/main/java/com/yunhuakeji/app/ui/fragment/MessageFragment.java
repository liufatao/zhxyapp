package com.yunhuakeji.app.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunhuakeji.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 消息
 */
public class MessageFragment extends Fragment {


    @BindView(R.id.txt_message_message)
    TextView txtMessageMessage;
    @BindView(R.id.txt_message_addressbook)
    TextView txtMessageAddressbook;
    @BindView(R.id.img_message_addfriend)
    ImageView imgMessageAddfriend;
    @BindView(R.id.fl_message)
    FrameLayout rlMessage;
    Unbinder unbinder;
    private FragmentManager fragmentManager;
    private NewsFragment newsFragment;
    private Address_book_Fragment address_book_fragment;
    private FragmentTransaction transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initFragment(0);

        imgMessageAddfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @OnClick({R.id.txt_message_message, R.id.txt_message_addressbook, R.id.img_message_addfriend})
    public void onClick(View view) {
        onRecover();
        switch (view.getId()) {
            case R.id.txt_message_message:
                initFragment(0);
                txtMessageMessage.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_radius_border_left_white));
                txtMessageMessage.setTextColor(ContextCompat.getColor(getContext(), R.color.color_black));

                break;
            case R.id.txt_message_addressbook:
                initFragment(1);
                txtMessageAddressbook.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_radius_border_right_white));
                txtMessageAddressbook.setTextColor(ContextCompat.getColor(getContext(), R.color.color_black));
                break;

        }
    }

    /**
     * 恢复按钮效果
     */
    private void onRecover() {
        txtMessageMessage.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_radius_border_left_blue));
        txtMessageAddressbook.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_radius_border_right_blue));
        txtMessageMessage.setTextColor(ContextCompat.getColor(getContext(), R.color.color_white));
        txtMessageAddressbook.setTextColor(ContextCompat.getColor(getContext(), R.color.color_white));
    }

    /**
     * 根据游标切换相应的界面
     */
    private void initFragment(int i) {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i) {
            case 0:
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();

                    transaction.add(R.id.fl_message, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }
                break;
            case 1:
                if (address_book_fragment == null) {
                    address_book_fragment = new Address_book_Fragment();
                    transaction.add(R.id.fl_message, address_book_fragment);
                } else {
                    transaction.show(address_book_fragment);
                }
                break;
        }
        transaction.commit();
    }

    /***
     * 隐藏Fragment
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (address_book_fragment != null) {
            transaction.hide(address_book_fragment);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
