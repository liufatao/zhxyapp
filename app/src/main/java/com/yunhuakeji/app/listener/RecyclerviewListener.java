package com.yunhuakeji.app.listener;

import android.view.View;

/**
 * RecyclerView 单击监听 长按监听
 */

public interface RecyclerviewListener {
    /**
     * 单击事件
     *
     * @param view    RecyclerView
     * @param position ItemID
     */
    void onItemClick(View view, int position);

    /**
     * 长按事件
     *
     * @param view    RecyclerView
     * @param position ITemID
     */
    void onItemLongClick(View view, int position);

}
