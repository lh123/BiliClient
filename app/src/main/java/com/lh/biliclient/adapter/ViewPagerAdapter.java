package com.lh.biliclient.adapter;
import android.support.v4.app.*;
import com.lh.biliclient.fragment.*;
import java.util.*;
import com.lh.biliclient.fragment.base.*;

public class ViewPagerAdapter extends FragmentPagerAdapter
{
	//public static final int TAG_COUNT=1;
	//private String[] list=new String[]{"番剧","推荐","分区","关注","发现"};
	private ArrayList<MainBaseFragment> fragmentList;
	public ViewPagerAdapter(FragmentManager fm)
	{
		super(fm);
		fragmentList=new ArrayList<MainBaseFragment>();
		fragmentList.add(new BangumiFragment());
		fragmentList.add(new IndexFragment());
	}
	
	@Override
	public Fragment getItem(int p1)
	{
		return fragmentList.get(p1);
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return fragmentList.get(position).getTitle();
	}
	
	@Override
	public int getCount()
	{
		return fragmentList.size();
	}
}
