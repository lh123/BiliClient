package com.lh.biliclient.adapter;

import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView.*;
import android.graphics.*;
import android.view.*;

public class BangumiItemDecoration extends RecyclerView.ItemDecoration
{
	private int marginCenter,marginEdge;

	public BangumiItemDecoration(int marginCenter, int marginEdge)
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
		if(type==BangumiRecyclerAdapter.RECOMNEND||type==BangumiRecyclerAdapter.ONLINEVIEW)
		{
			outRect.top=marginCenter/2;
			outRect.bottom=marginCenter/2;
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
		else if(type==BangumiRecyclerAdapter.BANNER)
		{
			outRect.bottom=marginCenter/2;
		}
		else if(type==BangumiRecyclerAdapter.RECOMMEND_HEAD||type==BangumiRecyclerAdapter.ONLINELIST_HEAD)
		{
			outRect.left=marginEdge;
			outRect.right=marginEdge;
			outRect.top=marginCenter/2;
			outRect.bottom=marginCenter/2;
		}
	}
}
