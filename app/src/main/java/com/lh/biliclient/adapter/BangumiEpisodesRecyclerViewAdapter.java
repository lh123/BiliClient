package com.lh.biliclient.adapter;

import android.graphics.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.activity.*;
import com.lh.biliclient.bean.*;
import java.util.*;

public class BangumiEpisodesRecyclerViewAdapter extends RecyclerView.Adapter
{
	private View view;
	public int position=0;
	private CallBack callBack;
	private BangumiDetailObj detail;

	public BangumiEpisodesRecyclerViewAdapter(BangumiDetailObj detail)
	{
		this.detail = detail;
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
		EpisodesViewHolder holder=(BangumiEpisodesRecyclerViewAdapter.EpisodesViewHolder) p1;
		List<BangumiDetailObj.Episodes> list=detail.getResult().getEpisodes();
		int index=p2,lastIndex=list.size()-1;
		if("1".equals(detail.getResult().getIsFinish()))
		{
			index=lastIndex-p2;
		}
		BangumiDetailObj.Episodes obj=list.get(index);
		if(p2==47)
		{
			holder.title.setText("...");
			position=47;
		}
		else
		{
			holder.title.setText(obj.getIndex());
		}
		holder.obj=obj;
		String newIndex=detail.getResult().getNewestEpIndex();
		if(detail.getResult().getIsFinish().equals("0")&&obj.getIndex().equals(newIndex))
		{
			holder.badge2.setVisibility(View.VISIBLE);
		}
		else
		{
			holder.badge2.setVisibility(View.GONE);
		}
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
		if(detail==null)
			return 0;
		if(detail.getResult().getEpisodes().size()>47)
			return 48;
		else
			return detail.getResult().getEpisodes().size();
	}

	class EpisodesViewHolder extends RecyclerView.ViewHolder implements OnClickListener
	{
		private TextView title,badge2;
		private BangumiDetailObj.Episodes obj;

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
			Toast.makeText(p1.getContext(),obj.getIndex(),Toast.LENGTH_SHORT).show();
			//callBack.click(obj,index,getAdapterPosition());
		}

	}
	interface CallBack
	{
		public void click(BangumiDetailObj.Episodes obj);
	}
}
