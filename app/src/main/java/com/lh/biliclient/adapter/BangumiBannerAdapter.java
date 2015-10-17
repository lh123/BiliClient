package com.lh.biliclient.adapter;

import android.net.*;
import android.support.v4.view.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.widget.*;
import java.util.*;

public class BangumiBannerAdapter extends PagerAdapter
{
	private int position;
	private BangumiBannerObj mObj;
	
	public void setData(BangumiBannerObj list)
	{
		mObj=list;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position)
	{
		this.position=position;
		ScalableImageView img=new ScalableImageView(container.getContext());
		ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
		img.setLayoutParams(lp);
		if(position==0)
		{
			//ImageLoader.getInstance().displayImage(BiliData.bangumiBannerList.get(BiliData.bangumiBannerList.size()-1).getImg(),img,ImageLoaderUtils.options);
			img.setImageURI(Uri.parse(mObj.getResult().getBanners().get((mObj.getResult().getBanners().size()-1)).getImg()));
		}
		else if(position==mObj.getResult().getBanners().size()+1)
		{
			img.setImageURI(Uri.parse(mObj.getResult().getBanners().get(0).getImg()));
			//ImageLoader.getInstance().displayImage(BiliData.bangumiBannerList.get(0).getImg(),img,ImageLoaderUtils.options);
		}
		else
		{
			img.setImageURI(Uri.parse(mObj.getResult().getBanners().get(position-1).getImg()));
			//ImageLoader.getInstance().displayImage(BiliData.bangumiBannerList.get(position-1).getImg(),img,ImageLoaderUtils.options);
		}
		container.addView(img);
		return img;
	}
	
	@Override
	public int getCount()
	{
		if(mObj==null)
			return 0;
		else
			return mObj.getResult().getBanners().size()+2;
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
