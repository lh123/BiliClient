package com.lh.biliclient.adapter;

import android.support.v4.view.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.widget.*;
import android.net.*;
import android.view.ViewGroup.*;
import android.graphics.*;

public class IndexRecyclerAdapter extends RecyclerView.Adapter
{
	public static final int BANNER=0;
	public static final int HEAD=1;
	public static final int VIDEO_GRID=2;
	public static final int FOOTER_NO_BTN=3;
	public static final int FOOTER=4;
	public static final int FULL_ITEM=5;
	public static final int MENU=6;
	public static final int HORISCROLL=7;

	public PagerAdapter banAdapter;
	private IndexData data;

	public IndexRecyclerAdapter(PagerAdapter banAdapter)
	{
		this.banAdapter = banAdapter;
	}

	public void setData(IndexData data)
	{
		this.data = data;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		View view;
		RecyclerView.ViewHolder holder;
		LayoutInflater minflate=LayoutInflater.from(p1.getContext());
		switch (p2)
		{
			case BANNER:
				view = minflate.inflate(R.layout.banner, p1, false);
				holder=new BannerHolder(view);
				holder.setIsRecyclable(false);
				return holder;
			case HEAD:
				view = minflate.inflate(R.layout.item_headview,p1,false);
				holder=new HeadHolder(view);
				return holder;
			case VIDEO_GRID:
				view=minflate.inflate(R.layout.index_grid_item_video,p1,false);
				holder=new VideoGridHolder(view);
				return holder;
			case FOOTER_NO_BTN:
				view=minflate.inflate(R.layout.index_recommend_more,p1,false);
				holder=new FooterNoBtnHolder(view);
				return holder;
			case HORISCROLL:
				view=minflate.inflate(R.layout.index_item_horizontal,p1,false);
				holder=new ScrollHolder(view);
				return holder;
			case MENU:
				view=minflate.inflate(R.layout.item_menu,p1,false);
				holder=new MenuHolder(view);
				return holder;
		}
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		int type=getItemViewType(p2);
		IndexObj.ResultObj result;
		IndexObj.Body body;
		if(type==HEAD&&p2==1)
		{
			result=data.getIndexObj().getResult().get(0);
			HeadHolder holder=(IndexRecyclerAdapter.HeadHolder) p1;
			holder.leftText.setText(result.getHead().getTitle());
		}
		else if(type==VIDEO_GRID&&p2>=2&&p2<=5)
		{
			result=data.getIndexObj().getResult().get(0);
			body=result.getBody().get(p2-2);
			VideoGridHolder holder=(IndexRecyclerAdapter.VideoGridHolder) p1;
			holder.cover.setImageURI(Uri.parse(body.getCover()));
			holder.title.setText(body.getTitle());
			holder.infoView.setText(body.getPlay());
			holder.infoDanmakus.setText(body.getDanmaku());
		}
		else if(type==HEAD&&p2==7)
		{
			result=data.getIndexObj().getResult().get(1);
			HeadHolder holder=(IndexRecyclerAdapter.HeadHolder) p1;
			holder.leftText.setText(result.getHead().getTitle());
		}
		else if(type==HORISCROLL&&p2==8)
		{
			result=data.getIndexObj().getResult().get(1);
			ScrollHolder holder=(IndexRecyclerAdapter.ScrollHolder) p1;
			int marginEdg=holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.item_margin_edg);
			int marginCenter=holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.item_margin_center);
			holder.container.removeAllViews();
			for (int i=0;i<result.getBody().size();i++)
			{
				IndexObj.Body b=result.getBody().get(i);
				View view=LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.index_bangumi_item,holder.container,false);
				LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams) view.getLayoutParams();
				lp.width=b.getWidth()+40;
				if(i==0)
				{
					lp.leftMargin=marginEdg;
					lp.rightMargin=marginCenter/2;
				}
				else if(i==result.getBody().size()-1)
				{
					lp.leftMargin=marginCenter/2;
					lp.rightMargin=marginEdg;
				}
				else
				{
					lp.leftMargin=marginCenter/2;
					lp.rightMargin=marginCenter/2;
				}
				view.setLayoutParams(lp);
				ScalableImageView cover=(ScalableImageView) view.findViewById(R.id.cover);
				TextView title=(TextView) view.findViewById(R.id.title);
				TextView title1=(TextView) view.findViewById(R.id.text1);
				TextView badge2=(TextView) view.findViewById(R.id.badge2);
				badge2.setTextColor(getColor(b.getBadgeColor()));
				badge2.setBackgroundColor(getColor(b.getBadgeBg()));
				badge2.setVisibility(View.VISIBLE);
				cover.setImageURI(Uri.parse(b.getCover()));
				title.setText(b.getTitle());
				title1.setText(b.getDesc1());
				badge2.setText(b.getBadge2());
				holder.container.addView(view);
			}
		}
		
	}

	@Override
	public int getItemCount()
	{
		if (data==null||data.getIndexObj() == null)
			return 0;
		return 10;
	}

	@Override
	public int getItemViewType(int position)
	{
		switch (position)
		{
			case 0:
				return BANNER;
			case 1:case 7:
				return HEAD;
			case 2:case 3:case 4:case 5:
				return VIDEO_GRID;
			case 6:
				return FOOTER_NO_BTN;
			case 8:
				return HORISCROLL;
			case 9:
				return MENU;
		}
		return -1;
	}


	public class BannerHolder extends RecyclerView.ViewHolder
	{
		public BannerViewPager banner;
		public LinearLayout linear;

		public BannerHolder(View view)
		{
			super(view);
			banner = (BannerViewPager) itemView.findViewById(R.id.bangumi_banneViewPager);
			banner.setAdapter(banAdapter);
			banner.refreshDot(itemView);
		}
	}

	public class HeadHolder extends RecyclerView.ViewHolder
	{
		public TextView leftText,rightText;
		
		public HeadHolder(View view)
		{
			super(view);
			leftText = (TextView) itemView.findViewById(R.id.bangumi_headviewTextView);
			rightText = (TextView) itemView.findViewById(R.id.bangumi_headviewTextView2);
		}
	}
	
	public class VideoGridHolder extends RecyclerView.ViewHolder
	{
		public ScalableImageView cover;
		public TextView title,infoView,infoDanmakus;
		public VideoGridHolder(View view)
		{
			super(view);
			cover=(ScalableImageView) itemView.findViewById(R.id.cover);
			title=(TextView) itemView.findViewById(R.id.title);
			infoView=(TextView) itemView.findViewById(R.id.info_views);
			infoDanmakus=(TextView) itemView.findViewById(R.id.info_danmakus);
		}
	}
	
	public class FooterNoBtnHolder extends RecyclerView.ViewHolder
	{
		public TextView refreshTips;
		public ImageView refresh;
		public FooterNoBtnHolder(View view)
		{
			super(view);
			refreshTips=(TextView) itemView.findViewById(R.id.refresh_tips);
			refresh=(ImageView) itemView.findViewById(R.id.refresh);
			refreshTips.setText("换一波推荐");
			refresh.setColorFilter(refresh.getContext().getResources().getColor(R.color.pink));
		}
	}
	
	public class MenuHolder extends RecyclerView.ViewHolder
	{
		public ImageView bgTimeLine,bgIndex;
		public MenuHolder(View view)
		{
			super(view);
			bgTimeLine=(ImageView) itemView.findViewById(R.id.bangumu_timeline);
			bgIndex=(ImageView) itemView.findViewById(R.id.bangumi_index);
		}
	}
	
	public class ScrollHolder extends RecyclerView.ViewHolder
	{
		public LinearLayout container;
		
		public ScrollHolder(View view)
		{
			super(view);
			container=(LinearLayout) itemView.findViewById(R.id.container);
		}
	}
	
	public class SpanLookUp extends GridLayoutManager.SpanSizeLookup
	{
		@Override
		public int getSpanSize(int position)
		{
			switch (position)
			{
				case 0:case 1:case 6:case 7:case 8:case 9:
					return 2;
			}
			return 1;
		}
	}
	
	private int getColor(String color)
	{
		String[] rgb=color.split(",");
		int r=Integer.parseInt(rgb[0]);
		int g=Integer.parseInt(rgb[1]);
		int b=Integer.parseInt(rgb[2]);
		return Color.rgb(r,g,b);
	}
}
