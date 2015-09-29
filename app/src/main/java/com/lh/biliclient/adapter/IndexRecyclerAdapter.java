package com.lh.biliclient.adapter;

import android.graphics.*;
import android.support.v4.view.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.utils.*;
import com.lh.biliclient.widget.*;
import com.nostra13.universalimageloader.core.*;
import android.view.ViewGroup.*;

public class IndexRecyclerAdapter extends RecyclerView.Adapter
{
	public static final int BANNER=0;
	public static final int FOURGRID=1;
	public static final int LANDSCAP=2;
	public static final int MENU=3;
	public static final int ONLINE_LIVE=4;
	public static final int TOPIC=5;

	public PagerAdapter banAdapter;
	public LandScapeRecyclerAdapter lanAdapter;
	private int currentArrayIndex=0;

	public IndexRecyclerAdapter(PagerAdapter banAdapter)
	{
		this.banAdapter = banAdapter;
		lanAdapter = new LandScapeRecyclerAdapter();
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		View view;
		switch (p2)
		{
			case BANNER:
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.banner, p1, false);
				BannerHolder holder=new BannerHolder(view);
				holder.setIsRecyclable(false);
				return holder;
			case FOURGRID:
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.four_item_view, p1, false);
				return new FourViewHolder(view);
			case LANDSCAP:
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.item_landscape, p1, false);
				return new LandScapeRecylerHolder(view);
			case MENU:
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.index_menu_item, p1, false);
				return new MenuViewHolder(view);
			case ONLINE_LIVE:
				view = LayoutInflater.from(p1.getContext()).inflate(R.layout.two_item_view, p1, false);
				return new OnlineViewHolder(view);
			case TOPIC:
				view=LayoutInflater.from(p1.getContext()).inflate(R.layout.topic_view_item,p1,false);
				return new TopicViewHolder(view);
				
		}
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		int type=getItemViewType(p2);
		if (type == FOURGRID&&p2==1)
		{
			FourViewHolder holder=(IndexRecyclerAdapter.FourViewHolder) p1;
			holder.headTitle.setText("热门推荐");
			for (int i=0;i < 4;i++)
			{
				IndexObj temp=BiliData.indexData.getHotRecommend().get(i);
				ImageLoader.getInstance().displayImage(temp.getCover(), holder.imageView[i], ImageLoaderUtils.options);
				holder.title[i].setText(temp.getTitle());
				holder.play[i].setText(temp.getPlay());
				holder.danmaku[i].setText(temp.getDanmaku());
			}
		}
		else if (type == LANDSCAP&&p2==2)
		{
			LandScapeRecylerHolder holder=(IndexRecyclerAdapter.LandScapeRecylerHolder) p1;
			holder.headTitle.setText("番剧更新");
		}
		else if (type == ONLINE_LIVE)
		{
			OnlineViewHolder holder=(IndexRecyclerAdapter.OnlineViewHolder) p1;
			holder.headTitle.setText("直播");
			for (int i=0;i < 2;i++)
			{
				IndexObj obj=BiliData.indexData.getOnline().get(i);
				ImageLoader.getInstance().displayImage(obj.getCover(), holder.cover[i], ImageLoaderUtils.options);
				ImageLoader.getInstance().displayImage(obj.getUp_face(), holder.upFace[i], ImageLoaderUtils.options);
				holder.title[i].setText(obj.getTitle());
				holder.onLine[i].setText(obj.getOnline());
				holder.upName[i].setText(obj.getUp());
			}
		}
		else if(p2==5)
		{
			TopicViewHolder holder=(IndexRecyclerAdapter.TopicViewHolder) p1;
			IndexObj obj=BiliData.indexData.getTopic().get(0);
			ImageLoader.getInstance().displayImage(obj.getCover(),holder.cover,ImageLoaderUtils.options);
			holder.headTitle.setText("话题");
			holder.title.setText(obj.getTitle());
		}
		else if(p2==6)
		{
			FourViewHolder holder=(IndexRecyclerAdapter.FourViewHolder) p1;
			holder.headTitle.setText("动漫区");
			for (int i=0;i < 4;i++)
			{
				IndexObj temp=BiliData.indexData.getCartoon().get(i);
				ImageLoader.getInstance().displayImage(temp.getCover(), holder.imageView[i], ImageLoaderUtils.options);
				holder.title[i].setText(temp.getTitle());
				holder.play[i].setText(temp.getPlay());
				holder.danmaku[i].setText(temp.getDanmaku());
			}
		}
	}

	@Override
	public int getItemCount()
	{
		if (BiliData.indexData == null)
			return 0;
		return 7;
	}

	@Override
	public int getItemViewType(int position)
	{
		switch (position)
		{
			case 0:
				return BANNER;
			case 1:
				return FOURGRID;
			case 2:
				return LANDSCAP;
			case 3:
				return MENU;
			case 4:
				return ONLINE_LIVE;
			case 5:
				return TOPIC;
			case 6:
				return FOURGRID;
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
			//banner.startAutoLoop(2000);
		}
	}

	public class LandScapeRecylerHolder extends RecyclerView.ViewHolder
	{

		public RecyclerView container;
		public ImageView headimage;
		public TextView headTitle,headMore;
		public LandScapeRecylerHolder(View view)
		{
			super(view);
			container = (RecyclerView) itemView.findViewById(R.id.my_recycler_view_landscape);
			headimage = (ImageView) itemView.findViewById(R.id.headImageView);
			headTitle = (TextView) itemView.findViewById(R.id.head_title);
			headMore = (TextView) itemView.findViewById(R.id.head_more);
			MyLayoutManager lm=new MyLayoutManager(itemView.getContext());
			lm.setOrientation(LinearLayoutManager.HORIZONTAL);
			container.setLayoutManager(lm);
			//container.setHasFixedSize(true);
			container.setAdapter(lanAdapter);
		}
	}


	public class FourViewHolder extends RecyclerView.ViewHolder
	{
		//public int tag;
		public View[] card;
		public ImageView[] imageView;
		public TextView[] title;
		public TextView[] play;
		public TextView[] danmaku;
		public ImageView headimage;
		public TextView headTitle,headMore;
		public FourViewHolder(View view)
		{
			super(view);
			//this.tag=tag;
			card = new View[4];
			imageView = new ImageView[4];
			title = new TextView[4];
			play = new TextView[4];
			danmaku = new TextView[4];
			headimage = (ImageView) itemView.findViewById(R.id.headImageView);
			headTitle = (TextView) itemView.findViewById(R.id.head_title);
			headMore = (TextView) itemView.findViewById(R.id.head_more);
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
				play[i] = (TextView) card[i].findViewById(R.id.tv_play);
				danmaku[i] = (TextView) card[i].findViewById(R.id.tv_danmaku);
				title[i].setMaxLines(2);
			}
		}
	}

	public class MenuViewHolder extends RecyclerView.ViewHolder
	{
		public MenuViewHolder(View view)
		{
			super(view);
		}
	}

	public class OnlineViewHolder extends RecyclerView.ViewHolder
	{
		public ImageView headImage;
		public ImageView[] cover;
		public CircleImageView[] upFace;
		public TextView[] title,upName,onLine;
		public TextView headTitle,headMore;
		public View[] card;
		public OnlineViewHolder(View view)
		{
			super(view);
			upName = new TextView[2];
			title = new TextView[2];
			card = new View[2];
			upFace = new CircleImageView[2];
			onLine = new TextView[2];
			cover = new ImageView[2];
			headImage = (ImageView) itemView.findViewById(R.id.headImageView);
			headTitle = (TextView) itemView.findViewById(R.id.head_title);
			headMore = (TextView) itemView.findViewById(R.id.head_more);
			for (int i=0;i < 2;i++)
			{
				switch (i)
				{
					case 0:
						card[i] = itemView.findViewById(R.id.cardview1);
						break;
					case 1:
						card[i] = itemView.findViewById(R.id.cardview2);
						break;
				}
				upFace[i] = (CircleImageView) card[i].findViewById(R.id.up_face);
				upName[i] = (TextView) card[i].findViewById(R.id.up_name);
				onLine[i] = (TextView) card[i].findViewById(R.id.online);
				title[i] = (TextView) card[i].findViewById(R.id.title);
				cover[i] = (ImageView) card[i].findViewById(R.id.imageView);
			}
		}
	}

	public class TopicViewHolder extends RecyclerView.ViewHolder
	{
		//public int tag;
		public ImageView headImage;
		public TextView headTitle,headMore,title;
		public ImageView cover;
		public TopicViewHolder(View view)
		{
			super(view);
			//this.tag=tag;
			headImage = (ImageView) itemView.findViewById(R.id.headImageView);
			headTitle = (TextView) itemView.findViewById(R.id.head_title);
			headMore = (TextView) itemView.findViewById(R.id.head_more);
			title=(TextView) itemView.findViewById(R.id.titleView);
			cover=(ImageView) itemView.findViewById(R.id.imageView);
		}
	}
}
