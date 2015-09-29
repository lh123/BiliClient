package com.lh.biliclient.adapter;
import android.support.v4.view.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.utils.*;
import com.nostra13.universalimageloader.core.*;
import java.util.*;

public class BangumiBannerAdapter extends PagerAdapter
{
	private int position;
	@Override
	public Object instantiateItem(ViewGroup container, int position)
	{
		this.position=position;
		ImageView img=new ImageView(container.getContext());
		ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
		img.setLayoutParams(lp);
		img.setScaleType(ImageView.ScaleType.FIT_XY);
		if(position==0)
		{
			ImageLoader.getInstance().displayImage(BiliData.bangumiBannerList.get(BiliData.bangumiBannerList.size()-1).getImg(),img,ImageLoaderUtils.options);
		}
		else if(position==BiliData.bangumiBannerList.size()+1)
		{
			ImageLoader.getInstance().displayImage(BiliData.bangumiBannerList.get(0).getImg(),img,ImageLoaderUtils.options);
		}
		else
		{
			ImageLoader.getInstance().displayImage(BiliData.bangumiBannerList.get(position-1).getImg(),img,ImageLoaderUtils.options);
		}
		container.addView(img);
		return img;
	}
	
	@Override
	public int getCount()
	{
		if(BiliData.bangumiBannerList==null)
			return 0;
		else
			return BiliData.bangumiBannerList.size()+2;
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
