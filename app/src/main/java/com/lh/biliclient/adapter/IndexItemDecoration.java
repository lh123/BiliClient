package com.lh.biliclient.adapter;

import android.graphics.*;
import android.support.v7.widget.*;
import android.view.*;

public class IndexItemDecoration extends RecyclerView.ItemDecoration
{
	private int margin;

	public IndexItemDecoration(int margin)
	{
		this.margin=margin;
	}

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
	{
		super.getItemOffsets(outRect, view, parent, state);
		int position=parent.getChildAdapterPosition(view);
		int spanIndex=((GridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
		int type=parent.getAdapter().getItemViewType(position);
		if(type==IndexRecyclerAdapter.VIDEO_GRID)
		{
			outRect.top=margin/2;
			outRect.bottom=margin/2;
			if(spanIndex==0)
			{
				outRect.left=margin;
				outRect.right=margin/2;
			}
			else
			{
				outRect.left=margin/2;
				outRect.right=margin;
			}
		}
		else if(type==IndexRecyclerAdapter.BANNER)
		{
			outRect.bottom=margin/2;
		}
		else if(type==IndexRecyclerAdapter.FOOTER||type==IndexRecyclerAdapter.HEAD||type==IndexRecyclerAdapter.HORISCROLL||type==IndexRecyclerAdapter.MENU)
		{
			outRect.top=margin/2;
			outRect.bottom=margin/2;
			outRect.left=margin;
			outRect.right=margin;
		}
	}
}
