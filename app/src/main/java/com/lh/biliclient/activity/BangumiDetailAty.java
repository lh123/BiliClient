package com.lh.biliclient.activity;
import android.net.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v4.view.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.adapter.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.fragment.*;
import com.lh.biliclient.fragment.base.*;
import com.lh.biliclient.utils.*;
import com.lh.biliclient.widget.*;
import java.util.*;

import android.support.v7.widget.Toolbar;
import com.lh.biliclient.presenter.*;

public class BangumiDetailAty extends AppCompatActivity implements ViewPager.OnPageChangeListener,IBangumiDetailAty
{
	public static final int INITDATA_SUCCESS=0;
	public static final int INITDATA_FAIL=1;
	
	private Toolbar toolbar;
	private TabLayout tabLayout;
	private ViewPager viewPager;
	private ScalableImageView cover;
	private TextView title,infoViews,infoDanmakus,infoDate;
	//private BangumiDetailObj detail;
	private BangumiDetailViewPagerAdapter adapter;
	private ScrollableLayout scrollableLayout;
	private int spid;
	private String seasonId=null;
	private BangumiDetailAtyPresenter mPresenter;
	
	private BangumiAtyDetailFragment bangumiAtyDetailFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bangumi_detail_aty);
		spid=getIntent().getIntExtra("spid",-1);
		seasonId=getIntent().getStringExtra("seasonId");
		mPresenter=new BangumiDetailAtyPresenter(this);
		initToolbar();
		initView();
	}

	private void initView()
	{
		cover=(ScalableImageView) findViewById(R.id.cover);
		title=(TextView) findViewById(R.id.title);
		infoViews=(TextView) findViewById(R.id.info_views);
		infoDanmakus=(TextView) findViewById(R.id.info_danmakus);
		infoDate=(TextView) findViewById(R.id.info_date);
		tabLayout=(TabLayout) findViewById(R.id.tab_layout);
		viewPager=(ViewPager) findViewById(R.id.viewpager);
		scrollableLayout=(ScrollableLayout) findViewById(R.id.bangumi_scrollablelayout);
		mPresenter.getBangumiDetailData(spid,seasonId);
	}

	@Override
	public void onBangumiDataChange(BangumiDetailObj obj)
	{
		postData(obj);
	}

	@Override
	public void onBangumiDataError()
	{
		Toast.makeText(this,"加载失败",Toast.LENGTH_SHORT).show();
	}

	private void initToolbar()
	{
		toolbar=(Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("番剧详情");
		toolbar.setNavigationOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					finish();
				}
			});
	}
	
	private void postData(BangumiDetailObj detail)
	{
		Bundle data=new Bundle();
		data.putSerializable("data",detail);
		adapter=new BangumiDetailViewPagerAdapter(getSupportFragmentManager());
		bangumiAtyDetailFragment = new BangumiAtyDetailFragment();
		bangumiAtyDetailFragment.setArguments(data);
		adapter.fragmentList=new ArrayList<BangumiDetailBaseFragment>();
		scrollableLayout.getHelper().setCurrentScrollableContainer(bangumiAtyDetailFragment);
		int current=0;
		if (detail.getResult().getAllowBp().equals("1"))
		{
			current = 1;
			BangumiAtyBPFragment bangumiAtyBPFragment = new BangumiAtyBPFragment();
			bangumiAtyBPFragment.setArguments(data);
			adapter.fragmentList.add(bangumiAtyBPFragment);
			
		}
		adapter.fragmentList.add(bangumiAtyDetailFragment);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(BangumiDetailAty.this);
		tabLayout.setupWithViewPager(viewPager);
		viewPager.setCurrentItem(current, false);
		infoViews.setText(StringUtils.formateNumber(detail.getResult().getPlayCount()));
		infoDanmakus.setText(StringUtils.formateNumber(detail.getResult().getDanmakuCount()));
		if (detail.getResult().getIsFinish().equals("0"))
			infoDate.setText(StringUtils.generateTime(detail.getResult().getWeekday()));
		else
			infoDate.setText(String.format(getResources().getString(R.string.bangumi_item_end_fmt), detail.getResult().getTotalCount()));
		title.setText(detail.getResult().getTitle());
		cover.setImageURI(Uri.parse(detail.getResult().getCover()));
	}
	
	@Override
	public void onPageScrolled(int p1, float p2, int p3)
	{
	}

	@Override
	public void onPageSelected(int p1)
	{
		scrollableLayout.getHelper().setCurrentScrollableContainer(adapter.fragmentList.get(p1));
	}

	@Override
	public void onPageScrollStateChanged(int p1)
	{
	}
}
