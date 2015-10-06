package com.lh.biliclient.adapter;

import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.activity.*;
import com.lh.biliclient.bean.*;
import java.util.*;

public class BangumigEpisodesRecyclerViewAdapter extends RecyclerView.Adapter
{
	
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		return new EpisodesViewHolder(new TextView(p1.getContext()));
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		EpisodesViewHolder holder=(BangumigEpisodesRecyclerViewAdapter.EpisodesViewHolder) p1;
		TextView v=(TextView) holder.itemView;
		ArrayList<BangumiDetail.Episodes> list=BangumiDetailAty.detail.getEpisodesList();
		BangumiDetail.Episodes obj=list.get(p2);
		v.setText(obj.getIndex());
	}

	@Override
	public int getItemCount()
	{
		return BangumiDetailAty.detail.getEpisodesList().size();
	}
	
	class EpisodesViewHolder extends RecyclerView.ViewHolder
	{
		public EpisodesViewHolder(View view)
		{
			super(view);
		}
	}
}
