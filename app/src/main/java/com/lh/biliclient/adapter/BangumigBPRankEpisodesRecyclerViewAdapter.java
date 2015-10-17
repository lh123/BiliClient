package com.lh.biliclient.adapter;

import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.activity.*;
import com.lh.biliclient.bean.*;
import java.util.*;
import android.graphics.*;
import android.view.View.*;
import android.support.v7.app.*;

public class BangumigBPRankEpisodesRecyclerViewAdapter extends RecyclerView.Adapter
{
	private View view;
	public int position;
	private CallBack callBack;
	private BangumiDetailObj detail;

	public BangumigBPRankEpisodesRecyclerViewAdapter(BangumiDetailObj detail)
	{
		this.detail = detail;
	}
	
	public void setPosition(int position)
	{
		this.position = position;
	}


	public void setCallBack(CallBack callBack)
	{
		this.callBack = callBack;
	}
	
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		view=LayoutInflater.from(p1.getContext()).inflate(R.layout.bangumi_episod_item,p1,false);
		return new EpisodesViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		EpisodesViewHolder holder=(BangumigBPRankEpisodesRecyclerViewAdapter.EpisodesViewHolder) p1;
		List<BangumiDetailObj.Episodes> list=detail.getResult().getEpisodes();
		int index=p2,lastIndex=list.size()-1;
		if("1".equals(detail.getResult().getIsFinish()))
		{
			index=lastIndex-p2;
		}
		BangumiDetailObj.Episodes obj=list.get(index);
		holder.title.setText(obj.getIndex());
		holder.obj=obj;
		if(p2==position)
		{
			holder.title.setBackgroundColor(p1.itemView.getContext().getResources().getColor(R.color.primary));
			holder.title.setTextColor(Color.WHITE);
		}
		else
		{
			holder.title.setBackgroundColor(Color.WHITE);
			holder.title.setTextColor(Color.BLACK);
		}
	}

	@Override
	public int getItemCount()
	{
		return detail.getResult().getEpisodes().size();
	}
	
	class EpisodesViewHolder extends RecyclerView.ViewHolder implements OnClickListener
	{
		private TextView title,badge2;
		private BangumiDetailObj.Episodes obj;
		private String index;
		
		public EpisodesViewHolder(View view)
		{
			super(view);
			title=(TextView) itemView.findViewById(R.id.title);
			badge2=(TextView) itemView.findViewById(R.id.badge2);
			itemView.setClickable(true);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View p1)
		{
			index=obj.getIndex();
			callBack.click(obj,index,getAdapterPosition());
		}
		
	}
	
	public interface CallBack
	{
		public void click(BangumiDetailObj.Episodes obj,String index,int position);
	}
}
