package com.lh.biliclient.adapter;

import android.content.*;
import android.graphics.*;
import android.support.v4.view.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.activity.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.utils.*;
import com.lh.biliclient.widget.*;
import android.net.*;

public class BangumiRecyclerAdapter extends RecyclerView.Adapter
{
	public static final int BANNER=0;
	public static final int ONLINELIST_HEAD=1;
	public static final int ONLINEVIEW=2;
	public static final int RECOMMEND_HEAD=3;
	public static final int RECOMNEND=4;

	private BangumiBannerAdapter banAdapter;
	private Context context;
	private int onlineViewPosition = 0,recommendPostion = 0;
	private MainBangumiData mData;

	public BangumiRecyclerAdapter(BangumiBannerAdapter banAdapter, Context context)
	{
		this.banAdapter = banAdapter;
		this.context = context;
	}

	public void setData(MainBangumiData data)
	{
		mData=data;
	}
	
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int type)
	{
		View view;
		switch (type)
		{
			case BANNER:
				//System.out.println("creat banner");
				view = LayoutInflater.from(context).inflate(R.layout.banner, p1, false);
				BannerViewHolder holer=new BannerViewHolder(view);
				holer.setIsRecyclable(false);
				return new BannerViewHolder(view);
			case ONLINELIST_HEAD:
				//System.out.println("creat online head");
				view = LayoutInflater.from(context).inflate(R.layout.item_headview, p1, false);
				return new HeadViewHolder(view);
			case ONLINEVIEW:
				//System.out.println("creat online");
				view = LayoutInflater.from(context).inflate(R.layout.bangumi_grid_online_item, p1, false);
				return new OnlineViewHolder(view);
			case RECOMMEND_HEAD:
				//System.out.println("creat recommend head");
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.item_headview, p1, false);
				return new HeadViewHolder(view);
			case RECOMNEND:
				//System.out.println("creat recommend");
				view = LayoutInflater.from(context).inflate(R.layout.bangumi_stagged_grid_item, p1, false);
				return new RecommendViewHolder(view);
		}
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		if (p1.getItemViewType() == BANNER)
		{
			StaggeredGridLayoutManager.LayoutParams lp=(StaggeredGridLayoutManager.LayoutParams) p1.itemView.getLayoutParams();
			lp.setFullSpan(true);
			//holder.banner.setCurrentItem(1,false);
		}
		else if (p1.getItemViewType() == ONLINELIST_HEAD)
		{
			StaggeredGridLayoutManager.LayoutParams lp=(StaggeredGridLayoutManager.LayoutParams) p1.itemView.getLayoutParams();
			lp.setFullSpan(true);
			//onlineViewPosition=lp.getViewLayoutPosition()+1;
			TextView txt=(TextView) p1.itemView.findViewById(R.id.bangumi_headviewTextView);
			TextView txt2=(TextView) p1.itemView.findViewById(R.id.bangumi_headviewTextView2);
			txt.setText("大家都在看");
			txt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_header_online,0,0,0);
			txt2.setText("进入看看");
		}
		else if (p1.getItemViewType() == ONLINEVIEW)
		{
			//StaggeredGridLayoutManager.LayoutParams lp=(StaggeredGridLayoutManager.LayoutParams) p1.itemView.getLayoutParams();
			//lp.setFullSpan(true);
			OnlineViewHolder holder=(BangumiRecyclerAdapter.OnlineViewHolder) p1;
			OnlineListObj.InnerVideo temp=mData.getOnlineObj().getList().get(p2-2);
			holder.cover.setImageURI(Uri.parse(temp.getPic()));
			holder.title.setText(temp.getTitle());
			holder.onLineText.setText(temp.getOnline() + "");
		}
		else if (p1.getItemViewType() == RECOMMEND_HEAD)
		{
			StaggeredGridLayoutManager.LayoutParams lp=(StaggeredGridLayoutManager.LayoutParams) p1.itemView.getLayoutParams();
			lp.setFullSpan(true);
			//recommendPostion=lp.getViewLayoutPosition()+1;
			TextView txt=(TextView) p1.itemView.findViewById(R.id.bangumi_headviewTextView);
			TextView txt2=(TextView) p1.itemView.findViewById(R.id.bangumi_headviewTextView2);
			txt.setText("番剧推荐");
			txt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_header_hot,0,0,0);
			txt2.setText("更多");
		}
		else if (p1.getItemViewType() == RECOMNEND)
		{
			RecommendViewHolder holder=(BangumiRecyclerAdapter.RecommendViewHolder) p1;
			BangumiRecommendObj.InnerRecommend temp=mData.getRecommendObj().getList().get(p2 - recommendPostion);
			//holder.temp=temp;
			holder.obj = temp;
			ViewGroup.LayoutParams lp=holder.cover.getLayoutParams();
			lp.height =temp.getHeight();
			holder.cover.setLayoutParams(lp);
			ViewGroup.LayoutParams edlp=holder.endepcount.getLayoutParams();
			if (temp.getEndepcount() == -1)
			{
				holder.endepcount.setVisibility(View.INVISIBLE);
				edlp.height = 0;
				holder.endepcount.setLayoutParams(edlp);
			}
			else
			{
				holder.endepcount.setVisibility(View.VISIBLE);
				edlp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
				holder.endepcount.setLayoutParams(edlp);
				holder.endepcount.setText(temp.getEndepcount() + "话[完结]");
			}
			holder.cover.setImageURI(Uri.parse(temp.getImageurl()));
			holder.title.setText(temp.getTitle());
		}
	}

	@Override
	public int getItemViewType(int position)
	{
		if (mData.getOnlineObj() == null)
		{
			switch (position)
			{
				case 0:
					return BANNER;
				case 1:
					recommendPostion = 2;
					return RECOMMEND_HEAD;
				default:
					return RECOMNEND;
			}
		}
		else
		{
			switch (position)
			{
				case 0:
					return BANNER;
				case 1:
					onlineViewPosition = 2;
					return ONLINELIST_HEAD;
				case 2:case 3:case 4:case 5:
					return ONLINEVIEW;
				case 6:
					recommendPostion = 7;
					return RECOMMEND_HEAD;
				default:
					return RECOMNEND;
			}
		}
	}

	@Override
	public int getItemCount()
	{
		int count=0;
		if(mData==null)
		{
			return count;
		}
		if (mData.getBangumiBannerObj() != null)
			count += 1;
		if (mData.getOnlineObj() != null)
			count += 5;
		if (mData.getRecommendObj() != null)
			count += mData.getRecommendObj().getList().size() + 1;
		return count;
	}

	public class HeadViewHolder extends RecyclerView.ViewHolder
	{
		public HeadViewHolder(View view)
		{
			super(view);
		}
	}

	public class OnlineViewHolder extends RecyclerView.ViewHolder
	{
		public ScalableImageView cover;
		public TextView title;
		public TextView onLineText;
		public OnlineViewHolder(View view)
		{
			super(view);
			cover = (ScalableImageView) itemView.findViewById(R.id.cover);
			title = (TextView) itemView.findViewById(R.id.title);
			onLineText = (TextView) itemView.findViewById(R.id.info_online);
		}
	}
	
	public class RecommendViewHolder extends RecyclerView.ViewHolder implements OnClickListener
	{
		public ScalableImageView cover;
		public TextView title,endepcount;
		public BangumiRecommendObj.InnerRecommend obj;
		public RecommendViewHolder(View view)
		{
			super(view);
			cover = (ScalableImageView) itemView.findViewById(R.id.cover);
			title = (TextView) itemView.findViewById(R.id.title);
			endepcount = (TextView) itemView.findViewById(R.id.text1);
			title.setMaxLines(2);
			cover.setScaleType(ScalableImageView.ScaleType.CENTER_CROP);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View p1)
		{
			Intent i=new Intent();
			i.setClass(itemView.getContext(), BangumiDetailAty.class);
			i.putExtra("spid", obj.getSpid());
			p1.getContext().startActivity(i);
		}

	}
	
	public class BannerViewHolder extends RecyclerView.ViewHolder
	{
		public BannerViewPager banner;
		public LinearLayout linear;

		public BannerViewHolder(View view)
		{
			super(view);
			banner = (BannerViewPager) itemView.findViewById(R.id.bangumi_banneViewPager);
			banner.setAdapter(banAdapter);
			banner.refreshDot(itemView);
			//banner.startAutoLoop(2000);
		}
	}

	@Override
	public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder)
	{
		if (holder.getItemViewType() == BANNER)
		{
			BannerViewHolder h=(BangumiRecyclerAdapter.BannerViewHolder) holder;
			h.banner.stopAutoLoop();
		}
		super.onViewDetachedFromWindow(holder);
	}

	@Override
	public void onViewAttachedToWindow(RecyclerView.ViewHolder holder)
	{
		if (holder.getItemViewType() == BANNER)
		{
			BannerViewHolder h=(BangumiRecyclerAdapter.BannerViewHolder) holder;
			h.banner.startAutoLoop(5000);
		}
		super.onViewAttachedToWindow(holder);
	}

	@Override
	public void onViewRecycled(RecyclerView.ViewHolder holder)
	{
		if (holder.getItemViewType() == RECOMNEND)
		{
			RecommendViewHolder reHolder=(BangumiRecyclerAdapter.RecommendViewHolder) holder;
			reHolder.cover.setImageResource(R.drawable.white);
		}
		super.onViewRecycled(holder);
	}
}
