package com.yunhuakeji.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MyListview extends ListView
{

	public MyListview(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyListview(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public MyListview(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
