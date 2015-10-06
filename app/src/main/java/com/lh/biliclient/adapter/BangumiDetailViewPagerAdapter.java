package com.lh.biliclient.adapter;

import android.support.v4.app.*;
import com.lh.biliclient.fragment.*;
import com.lh.biliclient.widget.*;
import com.lh.biliclient.bean.*;

public class BangumiDetailViewPagerAdapter extends FragmentPagerAdapter
{
	public String[] title=new String[]{"承包商排行","番剧详情","评论"};
	public boolean isBPRank=true;
	private ScrollableLayout layout;
	
	public BangumiDetailViewPagerAdapter(FragmentManager manager,ScrollableLayout layout)
	{
		super(manager);
		this.layout=layout;
	}
	
	@Override
	public Fragment getItem(int p1)
	{
		if(p1==0)
		{
			if(isBPRank)
			{
				BangumiAtyBPFragment bangumiAtyRecommend = new BangumiAtyBPFragment();
				layout.getHelper().setCurrentScrollableContainer(bangumiAtyRecommend);
				return bangumiAtyRecommend;
			}
			else
			{
				return new Fragment();
			}
		}
		return new Fragment();
	}

	@Override
	public int getCount()
	{
		if(isBPRank)
			return title.length;
		else
			return title.length-1;
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		if(isBPRank)
			return title[position];
		else
			return title[position+1];
	}
}
