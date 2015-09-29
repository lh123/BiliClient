package com.lh.biliclient.adapter;
import android.support.v4.app.*;
import com.lh.biliclient.fragment.*;

public class ViewPagerAdapter extends FragmentPagerAdapter
{
	//public static final int TAG_COUNT=1;
	private String[] list=new String[]{"番剧","推荐","分区","关注","发现"};
	public ViewPagerAdapter(FragmentManager fm)
	{
		super(fm);
	}
	
	@Override
	public Fragment getItem(int p1)
	{
		switch(p1)
		{
			case 0:
				return new BangumiFragment();
			case 1:
				return new IndexFragment();
		}
		return new Fragment();
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return list[position];
	}
	
	@Override
	public int getCount()
	{
		return list.length;
	}
}
