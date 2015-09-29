package com.lh.biliclient.fragment;
import android.os.*;
import android.support.design.widget.*;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.support.v4.widget.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import com.lh.biliclient.*;
import com.lh.biliclient.adapter.*;

import android.support.v7.app.ActionBarDrawerToggle;

public class MainFragment extends Fragment
{
	private Toolbar toolbar;
	private ActionBarDrawerToggle toggle;
	private DrawerLayout drawerLayout;
	private TabLayout tabLayout;
	private ViewPager viewPager;
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main,container,false);
		getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		initToolbar();
		return view;
	}
	
	private void initToolbar()
	{
		AppCompatActivity activity=(AppCompatActivity) getActivity();
		toolbar=(Toolbar) view.findViewById(R.id.toolbar);
		drawerLayout=(DrawerLayout) view.findViewById(R.id.drawerLayout);
		activity.setSupportActionBar(toolbar);
		activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		activity.getSupportActionBar().setHomeButtonEnabled(true);
		toggle=new ActionBarDrawerToggle(activity,drawerLayout,toolbar,R.string.hello_world,R.string.hello_world);
		drawerLayout.setDrawerListener(toggle);
		toggle.syncState();
		tabLayout=(TabLayout) view.findViewById(R.id.pagerSlidingTabStrip);
		tabLayout.setTabMode(TabLayout.MODE_FIXED);
		tabLayout.setTabTextColors(getResources().getColor(R.color.gray),getResources().getColor(R.color.white));
		tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
		viewPager=(ViewPager) view.findViewById(R.id.viewpager);
		ViewPagerAdapter adapter=new ViewPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
	}
	
}
