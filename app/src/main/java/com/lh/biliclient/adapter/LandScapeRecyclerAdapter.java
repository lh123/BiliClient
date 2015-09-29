package com.lh.biliclient.adapter;

import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.utils.*;
import com.nostra13.universalimageloader.core.*;
import com.lh.biliclient.bilibili.*;

public class LandScapeRecyclerAdapter extends RecyclerView.Adapter
{

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		View view=LayoutInflater.from(p1.getContext()).inflate(R.layout.index_landscape_item,p1,false);
		return new UpdateViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		UpdateViewHolder holder=(LandScapeRecyclerAdapter.UpdateViewHolder) p1;
		holder.setData(BiliData.indexData.getUpdateBangumi().get(p2));
	}

	@Override
	public int getItemCount()
	{
		if(BiliData.indexData.getUpdateBangumi()==null)
			return 0;
		return 6;
	}
	
	public class UpdateViewHolder extends RecyclerView.ViewHolder
	{
		public ImageView img;
		public TextView title,desc,badge;
		public UpdateViewHolder(View view)
		{
			super(view);
			img=(ImageView) itemView.findViewById(R.id.imageView);
			title=(TextView) itemView.findViewById(R.id.titleView);
			desc=(TextView) itemView.findViewById(R.id.descView);
			badge=(TextView) itemView.findViewById(R.id.badge);
		}
		public void setData(IndexObj data)
		{
			//ViewGroup.LayoutParams lp=img.getLayoutParams();
			img.setScaleType(ImageView.ScaleType.FIT_XY);
			ImageLoader.getInstance().displayImage(data.getCover(), img, ImageLoaderUtils.options);
			title.setText(data.getTitle());
			badge.setText(data.getBadge2());
			desc.setText(data.getDesc1());
		}
	}
}
