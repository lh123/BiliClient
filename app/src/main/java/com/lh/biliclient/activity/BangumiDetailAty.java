package com.lh.biliclient.activity;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.bean.*;

import android.support.v7.widget.Toolbar;
import com.nostra13.universalimageloader.core.*;
import com.lh.biliclient.utils.*;

public class BangumiDetailAty extends AppCompatActivity
{
	private Toolbar toolbar;
	private BangumiRecommendObj obj;
	private ImageView cover;
	private TextView title,infoViews,infoDanmakus,infoDate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bangumi_detail_aty);
		obj=(BangumiRecommendObj) getIntent().getSerializableExtra("data");
		initToolbar();
		initData();
	}

	private void initData()
	{
		cover=(ImageView) findViewById(R.id.cover);
		title=(TextView) findViewById(R.id.title);
		infoViews=(TextView) findViewById(R.id.info_views);
		infoDanmakus=(TextView) findViewById(R.id.info_danmakus);
		infoDate=(TextView) findViewById(R.id.info_date);
		ImageLoader.getInstance().displayImage(obj.getImageurl(),cover,ImageLoaderUtils.options);
		title.setText(obj.getTitle());
	}

	private void initToolbar()
	{
		toolbar=(Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle(obj.getTitle());
		toolbar.setNavigationOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					finish();
				}
			});
	}
}
