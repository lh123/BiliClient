package com.lh.biliclient.widget;
import android.content.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;

public class WrapGridLayoutManager extends GridLayoutManager
{
	public WrapGridLayoutManager(Context context, int spanCount)
	{
        super(context, spanCount);
    }

	private int[] mMeasuredDimension = new int[2];

	@Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state,
                          int widthSpec, int heightSpec)
	{
        final int widthSize = View.MeasureSpec.getSize(widthSpec);
		final int heightSize=View.MeasureSpec.getSize(heightSpec);
        int height = 0;

        for (int i = 0; i < getItemCount(); i++)
		{

            measureScrapChild(recycler, i,
							  View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
							  View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
							  mMeasuredDimension);
			if (i % getSpanCount() == 0)
			{
				height = height + mMeasuredDimension[1];
			}
        }
		if(height<getMinimumHeight())
			height=getMinimumHeight();
		else if(height>heightSize&&heightSize!=0)
			height=heightSize;
        setMeasuredDimension(widthSize, height);
    }

    private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec, int heightSpec, int[] measuredDimension)
	{

        View view = recycler.getViewForPosition(position);

        if (view != null)
		{

            RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();

            int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec,
															   getPaddingLeft() + getPaddingRight(), p.width);
            int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
																getPaddingTop() + getPaddingBottom(), p.height);

            view.measure(childWidthSpec, childHeightSpec);

            measuredDimension[0] = view.getMeasuredWidth() + p.leftMargin + p.rightMargin;
            measuredDimension[1] = view.getMeasuredHeight() + p.bottomMargin + p.topMargin;

            recycler.recycleView(view);
        }
    }
}
