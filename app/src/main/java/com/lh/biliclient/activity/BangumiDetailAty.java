package com.lh.biliclient.activity;
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
import com.lh.biliclient.utils.*;
import com.lh.biliclient.widget.*;
import com.nostra13.universalimageloader.core.*;
import java.util.*;

import android.support.v7.widget.Toolbar;

public class BangumiDetailAty extends AppCompatActivity
{
	private Toolbar toolbar;
	private TabLayout tabLayout;
	private ViewPager viewPager;
	private BangumiRecommendObj obj;
	private ImageView cover;
	private TextView title,infoViews,infoDanmakus,infoDate;
	public static BangumiDetail detail;
	public static ArrayList<BPRankObj> bpRank;
	private BangumiDetailViewPagerAdapter adapter;
	private ScrollableLayout scrollableLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bangumi_detail_aty);
		obj=(BangumiRecommendObj) getIntent().getSerializableExtra("data");
		initToolbar();
		initView();
		initData();
	}

	private void initView()
	{
		//ll=(LinearLayout) findViewById(R.id.bangumi_linearlayout);
		cover=(ImageView) findViewById(R.id.cover);
		title=(TextView) findViewById(R.id.title);
		infoViews=(TextView) findViewById(R.id.info_views);
		infoDanmakus=(TextView) findViewById(R.id.info_danmakus);
		infoDate=(TextView) findViewById(R.id.info_date);
		tabLayout=(TabLayout) findViewById(R.id.tab_layout);
		viewPager=(ViewPager) findViewById(R.id.viewpager);
		scrollableLayout=(ScrollableLayout) findViewById(R.id.bangumi_scrollablelayout);
	}

	private void initData()
	{
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					detail=BiliApi.getInstance().getBangumiDetail(obj.getSpid());
					bpRank=BiliApi.getInstance().getBPRankList(detail.getEpisodesList().get(0).getAvId());
					toolbar.post(new Runnable(){

							@Override
							public void run()
							{
								adapter=new BangumiDetailViewPagerAdapter(getSupportFragmentManager(),scrollableLayout);
								if(bpRank==null||bpRank.size()==0)
									adapter.isBPRank=false;
								viewPager.setAdapter(adapter);
								tabLayout.setupWithViewPager(viewPager);
								infoViews.setText(StringUtils.generateStringNum(detail.getPlayCount()));
								infoDanmakus.setText(StringUtils.generateStringNum(detail.getDanmakuCount()));
								infoDate.setText(StringUtils.generateTime(detail.getWeekday()));
								title.setText(detail.getTitle());
								ImageLoader.getInstance().displayImage(detail.getCover(),cover,ImageLoaderUtils.options);
							}
						});
				}
			}).start();
		
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

}
