package com.lh.biliclient.adapter;

import android.support.v4.view.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.utils.*;
import com.lh.biliclient.widget.*;
import android.net.*;
import com.lh.biliclient.bean.*;

public class IndexBannerAdapter extends PagerAdapter
{
	private IndexData data;

	public void setData(IndexData data)
	{
		this.data = data;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position)
	{
		ScalableImageView img=new ScalableImageView(container.getContext());
		ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
		img.setLayoutParams(lp);
		img.setScaleType(ImageView.ScaleType.FIT_XY);
		if(position==0)
		{
			img.setImageURI(Uri.parse(data.getBannerObj().getList().get(data.getBannerObj().getList().size()-1).getImageurl()));
		}
		else if(position==data.getBannerObj().getList().size()+1)
		{
			img.setImageURI(Uri.parse(data.getBannerObj().getList().get(0).getImageurl()));
		}
		else
		{
			img.setImageURI(Uri.parse(data.getBannerObj().getList().get(position-1).getImageurl()));
		}
		container.addView(img);
		return img;
	}

	@Override
	public int getCount()
	{
		if(data.getBannerObj().getList()==null)
			return 0;
		else
			return data.getBannerObj().getList().size()+2;
	}

	@Override
	public boolean isViewFromObject(View p1, Object p2)
	{
		return p1==p2;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object)
	{
		//container.removeViewAt(position);
	}

	@Override
	public int getItemPosition(Object object)
	{
		return POSITION_NONE;
	}

}
