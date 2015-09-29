package com.lh.biliclient.widget;

import android.content.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.support.v7.widget.RecyclerView.*;

public class MyLayoutManager extends LinearLayoutManager
{
	public MyLayoutManager(Context context)
	{
		super(context);
	}

	private int[] mMeasuredDimension = new int[2];
	@Override
	public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec)
	{
		final int widthMode = View.MeasureSpec.getMode(widthSpec);
		final int heightMode = View.MeasureSpec.getMode(heightSpec);
		final int widthSize = View.MeasureSpec.getSize(widthSpec);
		final int heightSize = View.MeasureSpec.getSize(heightSpec);

		measureScrapChild(recycler, 0,
						  View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
						  View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
						  mMeasuredDimension);

		int width = mMeasuredDimension[0];
		int height = mMeasuredDimension[1];

		switch (widthMode) {
			case View.MeasureSpec.EXACTLY:
			case View.MeasureSpec.AT_MOST:
				width = widthSize;
				break;
			case View.MeasureSpec.UNSPECIFIED:
		}

		switch (heightMode) {
			case View.MeasureSpec.EXACTLY:
			case View.MeasureSpec.AT_MOST:
				height = heightSize;
				break;
			case View.MeasureSpec.UNSPECIFIED:
		}

		setMeasuredDimension(width, height);
	}

	private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec,
								   int heightSpec, int[] measuredDimension) {
		View view = recycler.getViewForPosition(position);
		if (view != null) {
			RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
			int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec,
															   getPaddingLeft() + getPaddingRight(), p.width);
			int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
																getPaddingTop() + getPaddingBottom(), p.height);
			view.measure(childWidthSpec, childHeightSpec);
			measuredDimension[0] = view.getMeasuredWidth();
			measuredDimension[1] = view.getMeasuredHeight();
			recycler.recycleView(view);
		}
	}
}
