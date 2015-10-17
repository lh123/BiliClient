package com.lh.biliclient.adapter;

import android.support.v4.app.*;
import com.lh.biliclient.fragment.base.*;
import com.lh.biliclient.widget.*;
import java.util.*;
import com.lh.biliclient.fragment.*;

public class BangumiDetailViewPagerAdapter extends FragmentPagerAdapter
{
	public ArrayList<BangumiDetailBaseFragment> fragmentList;
	
	public BangumiDetailViewPagerAdapter(FragmentManager manager)
	{
		super(manager);
	}
	
	@Override
	public Fragment getItem(int p1)
	{
		return fragmentList.get(p1);
	}

	@Override
	public int getCount()
	{
		return fragmentList.size();
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return fragmentList.get(position).getTitle();
	}
}
