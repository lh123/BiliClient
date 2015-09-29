package com.lh.biliclient.adapter;

import android.graphics.*;
import android.support.v4.view.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.utils.*;
import com.lh.biliclient.widget.*;
import com.nostra13.universalimageloader.core.*;
import android.content.*;
import com.lh.biliclient.activity.*;

public class BangumiRecyclerAdapter extends RecyclerView.Adapter
{
	public static final int BANNER=0;
	public static final int ONLINELIST_HEAD=1;
	public static final int ONLINEVIEW=2;
	public static final int RECOMMEND_HEAD=3;
	public static final int RECOMNEND=4;
	
	private PagerAdapter banAdapter;
	private int onlineViewPosition = 0,recommendPostion = 0;
	
	public BangumiRecyclerAdapter(PagerAdapter banAdapter)
	{
		this.banAdapter = banAdapter;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int type)
	{
		View view;
		switch (type)
		{
			case BANNER:
				//System.out.println("creat banner");
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.banner, p1, false);
				BannerViewHolder holer=new BannerViewHolder(view);
				holer.setIsRecyclable(false);
				return new BannerViewHolder(view);
			case ONLINELIST_HEAD:
				//System.out.println("creat online head");
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.item_headview, p1, false);
				return new HeadViewHolder(view);
			case ONLINEVIEW:
				//System.out.println("creat online");
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.bangumi_online, p1, false);
				//view=new GridLayout(p1.getContext());
				//StaggeredGridLayoutManager.LayoutParams lp=new StaggeredGridLayoutManager.LayoutParams(StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT,StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT);
				//view.setLayoutParams(lp);
				return new OnlineViewHolder(view);
			case RECOMMEND_HEAD:
				//System.out.println("creat recommend head");
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.item_headview, p1, false);
				return new HeadViewHolder(view);
			case RECOMNEND:
				//System.out.println("creat recommend");
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.recycler_item, p1, false);
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
			txt2.setText("更多");
		}
		else if (p1.getItemViewType() == ONLINEVIEW)
		{
			StaggeredGridLayoutManager.LayoutParams lp=(StaggeredGridLayoutManager.LayoutParams) p1.itemView.getLayoutParams();
			lp.setFullSpan(true);
			OnlineViewHolder holder=(BangumiRecyclerAdapter.OnlineViewHolder) p1;
			for (int i=0;i < 4;i++)
			{
				VideoObj temp=BiliData.onlineList.get(i);
				ImageLoader.getInstance().displayImage(temp.getPic(), holder.imageView[i], ImageLoaderUtils.options);
				holder.title[i].setText(temp.getTitle());
				holder.onLineText[i].setText(temp.getOnline() + "");
			}
		}
		else if (p1.getItemViewType() == RECOMMEND_HEAD)
		{
			StaggeredGridLayoutManager.LayoutParams lp=(StaggeredGridLayoutManager.LayoutParams) p1.itemView.getLayoutParams();
			lp.setFullSpan(true);
			//recommendPostion=lp.getViewLayoutPosition()+1;
			TextView txt=(TextView) p1.itemView.findViewById(R.id.bangumi_headviewTextView);
			TextView txt2=(TextView) p1.itemView.findViewById(R.id.bangumi_headviewTextView2);
			txt.setText("番剧推荐");
			txt2.setText("更多");
		}
		else if (p1.getItemViewType() == RECOMNEND)
		{
			RecommendViewHolder holder=(BangumiRecyclerAdapter.RecommendViewHolder) p1;
			BangumiRecommendObj temp=BiliData.recommendList.get(p2 - recommendPostion);
			//holder.temp=temp;
			holder.obj=temp;
			ViewGroup.LayoutParams lp=holder.imageView.getLayoutParams();
			lp.height = BiliData.recommendList.get(p2 - recommendPostion).getHeight();
			holder.imageView.setLayoutParams(lp);
			ViewGroup.LayoutParams edlp=holder.endepcount.getLayoutParams();
			if(temp.getEndepcount()==-1)
			{
				holder.endepcount.setVisibility(View.INVISIBLE);
				edlp.height=0;
				holder.endepcount.setLayoutParams(edlp);
			}
			else
			{
				holder.endepcount.setVisibility(View.VISIBLE);
				edlp.height=ViewGroup.LayoutParams.WRAP_CONTENT;
				holder.endepcount.setLayoutParams(edlp);
				holder.endepcount.setText(temp.getEndepcount()+"话[完结]");
			}
			ImageLoader.getInstance().displayImage(temp.getImageurl(), holder.imageView, ImageLoaderUtils.options);
			holder.title.setText(temp.getTitle());
		}
//		if (p2 == 0)
//		{
//			
//		}
//		else if (p2 == 1) 
//		{
//			
//		}
//		else if (p2 > 1 && p2 < 6)
//		{
//			
//		}
//		else if (p2 == 6)
//		{
//			
//		}
//		else
//		{
//			
//		}
	}

	@Override
	public int getItemViewType(int position)
	{
		if (BiliData.onlineList == null)
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
				case 2:
					return ONLINEVIEW;
				case 3:
					recommendPostion = 4;
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
		if (BiliData.bangumiBannerList != null)
			count+=1;
		if(BiliData.onlineList!=null)
			count+=2;
		if(BiliData.recommendList!=null)
			count+=BiliData.recommendList.size()+1;
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
		public View[] card;
		public ImageView[] imageView;
		public TextView[] title;
		public TextView[] onLineText;
		public OnlineViewHolder(View view)
		{
			super(view);
			card = new View[4];
			imageView = new ImageView[4];
			title = new TextView[4];
			onLineText = new TextView[4];
			for (int i=0;i < 4;i++)
			{
				switch (i)
				{
					case 0:
						card[i] = itemView.findViewById(R.id.cardview1);
						break;
					case 1:
						card[i] = itemView.findViewById(R.id.cardview2);
						break;
					case 2:
						card[i] = itemView.findViewById(R.id.cardview3);
						break;
					case 3:
						card[i] = itemView.findViewById(R.id.cardview4);
						break;
				}
				imageView[i] = (ImageView) card[i].findViewById(R.id.imageView);
				title[i] = (TextView) card[i].findViewById(R.id.titleView);
				onLineText[i] = (TextView) card[i].findViewById(R.id.onlineTextView);
				title[i].setMaxLines(2);
				onLineText[i].setTextColor(Color.WHITE);
			}
		}
	}
	public class RecommendViewHolder extends RecyclerView.ViewHolder implements OnClickListener
	{
		public ImageView imageView;
		public TextView title,onLineText,endepcount;
		public BangumiRecommendObj obj;
		public RecommendViewHolder(View view)
		{
			super(view);
			imageView = (ImageView) itemView.findViewById(R.id.imageView);
			title = (TextView) itemView.findViewById(R.id.titleView);
			onLineText = (TextView) itemView.findViewById(R.id.onlineTextView);
			endepcount=(TextView) itemView.findViewById(R.id.endepcount);
			title.setMaxLines(2);
			onLineText.setVisibility(View.INVISIBLE);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View p1)
		{
			//Toast.makeText(p1.getContext(),obj.getTitle()+getLayoutPosition(),Toast.LENGTH_LONG).show();
			Intent i=new Intent();
			i.setClass(itemView.getContext(),BangumiDetailAty.class);
			i.putExtra("data",obj);
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
		if(holder.getItemViewType()==BANNER)
		{
			BannerViewHolder h=(BangumiRecyclerAdapter.BannerViewHolder) holder;
			h.banner.stopAutoLoop();
		}
		super.onViewDetachedFromWindow(holder);
	}

	@Override
	public void onViewAttachedToWindow(RecyclerView.ViewHolder holder)
	{
		if(holder.getItemViewType()==BANNER)
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
			reHolder.imageView.setImageResource(R.drawable.white);
		}
		super.onViewRecycled(holder);
	}
}
