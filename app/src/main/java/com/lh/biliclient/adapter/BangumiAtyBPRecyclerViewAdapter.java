package com.lh.biliclient.adapter;

import android.content.*;
import android.graphics.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.activity.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.utils.*;
import com.lh.biliclient.widget.*;
import com.nostra13.universalimageloader.core.*;

public class BangumiAtyBPRecyclerViewAdapter extends RecyclerView.Adapter
{
	public static final int HEAD=0;
	public static final int NORMAL=1;
	private int title=1,count=0;
	private RecyclerView recyclerView;
	private GridLayoutManager gl;

	private BangumigEpisodesRecyclerViewAdapter adapter;
	
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int type)
	{
		View view;
		if(type==HEAD)
		{
			view=LayoutInflater.from(p1.getContext()).inflate(R.layout.bangumi_bp_head,p1,false);
			return new BPHeadViewHolder(view);
		}
		else if(type==NORMAL)
		{
			view=LayoutInflater.from(p1.getContext()).inflate(R.layout.bangumi_bp_item,p1,false);
			return new BPViewHolder(view);
		}
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		if(p2==0)
		{
			BPHeadViewHolder holder=(BangumiAtyBPRecyclerViewAdapter.BPHeadViewHolder) p1;
			holder.title.setText(String.format("第%02d话",title));
			count=BangumiDetailAty.bpRank.get(0).getUsers();
			holder.count.setText(count+"人");
		}
		else
		{
			int index=p2-1;
			BPViewHolder holder=(BangumiAtyBPRecyclerViewAdapter.BPViewHolder) p1;
			BPRankObj obj=BangumiDetailAty.bpRank.get(index);
			ImageLoader.getInstance().displayImage(obj.getFace(),holder.avatar,ImageLoaderUtils.options);
			holder.name.setText(obj.getUname());
			if(index<3)
			{
				holder.rank.setTextColor(p1.itemView.getContext().getResources().getColor(R.color.primary));
			}
			else
			{
				holder.rank.setTextColor(Color.BLACK);
			}
			if(obj.getMessage()!=null)
			{
				holder.message.setVisibility(View.VISIBLE);
				holder.message.setText(obj.getMessage());
			}
			else
			{
				holder.message.setVisibility(View.GONE);
			}
			holder.rank.setText(obj.getRank());
		}
	}

	@Override
	public int getItemCount()
	{
		if(BangumiDetailAty.bpRank==null)
			return 1;
		else
			return BangumiDetailAty.bpRank.size()+1;
	}

	@Override
	public int getItemViewType(int position)
	{
		if(position==0)
			return HEAD;
		else
			return NORMAL;
	}
	
	class BPHeadViewHolder extends RecyclerView.ViewHolder implements OnClickListener
	{
		private TextView title,count,chooseEpisode;
		
		public BPHeadViewHolder(View view)
		{
			super(view);
			title=(TextView) itemView.findViewById(R.id.title);
			count=(TextView) itemView.findViewById(R.id.count);
			chooseEpisode=(TextView) itemView.findViewById(R.id.choose_episode);
			initView();
		}
		private void initView()
		{
			chooseEpisode.setEnabled(true);
			chooseEpisode.setOnClickListener(this);
		}

		@Override
		public void onClick(View p1)
		{
			Toast.makeText(p1.getContext(),"test",Toast.LENGTH_SHORT).show();
			recyclerView=(RecyclerView) LayoutInflater.from(p1.getContext()).inflate(R.layout.recyclerview,null);
			gl=new GridLayoutManager(p1.getContext(),4);
			adapter=new BangumigEpisodesRecyclerViewAdapter();
			recyclerView.setLayoutManager(gl);
			recyclerView.setAdapter(adapter);
			AlertDialog.Builder builder=new AlertDialog.Builder(p1.getContext());
			builder.setTitle("集数选择");
			builder.setView(recyclerView);
			adapter.notifyDataSetChanged();
			builder.show();
		}
		
	}
	class BPViewHolder extends RecyclerView.ViewHolder
	{
		private TextView rank,name,message;
		private CircleImageView avatar;
		public BPViewHolder(View view)
		{
			super(view);
			rank=(TextView) itemView.findViewById(R.id.rank);
			name=(TextView) itemView.findViewById(R.id.name);
			message=(TextView) itemView.findViewById(R.id.message);
			avatar=(CircleImageView) itemView.findViewById(R.id.avatar);
		}
	}
}
