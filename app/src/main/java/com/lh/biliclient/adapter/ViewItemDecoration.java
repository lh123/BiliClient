package com.lh.biliclient.adapter;

import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView.*;
import android.graphics.*;
import android.view.*;

public class ViewItemDecoration extends RecyclerView.ItemDecoration
{
	private int marginCenter,marginEdge;

	public ViewItemDecoration(int marginCenter, int marginEdge)
	{
		this.marginCenter = marginCenter;
		this.marginEdge = marginEdge;
	}
	
	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
	{
		super.getItemOffsets(outRect, view, parent, state);
		int position=parent.getChildAdapterPosition(view);
		int spanIndex=((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
		int type=parent.getAdapter().getItemViewType(position);
		if(type==BangumiRecyclerAdapter.RECOMNEND)
		{
			outRect.bottom=marginEdge;
			if(spanIndex==0)
			{
				outRect.left=marginEdge;
				outRect.right=marginCenter/2;
			}
			else
			{
				outRect.left=marginCenter/2;
				outRect.right=marginEdge;
			}
		}
	}
}
