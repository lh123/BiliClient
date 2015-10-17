package com.lh.biliclient.fragment;

import android.content.*;
import android.os.*;
import android.support.v4.widget.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.activity.*;
import com.lh.biliclient.adapter.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.fragment.base.*;
import com.lh.biliclient.widget.*;
import java.util.*;
import android.net.*;

public class BangumiAtyDetailFragment extends BangumiDetailBaseFragment
{
	private View view;
	private TextView seasonTitle,seasonTitleMore,seasonDescMore,text,seasonListTitle;
	private HorizontalScrollView seasonListView;
	private TagView tagView;
	private RecyclerView grid;
	private NestedScrollView scrollView;
	private BangumiDetailObj detail;
	private BangumiEpisodesRecyclerViewAdapter adapter;
	private ArrayList<TagView.Tag> tagList;
	
	public BangumiAtyDetailFragment()
	{
		title="番剧详情";
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view=inflater.inflate(R.layout.bangumi_aty_detail,container,false);
		initView();
		initData();
		return view;
	}

	public void initData()
	{
		scrollView.setVisibility(View.VISIBLE);
		adapter = new BangumiEpisodesRecyclerViewAdapter(detail);
		WrapGridLayoutManager wgl=new WrapGridLayoutManager(getActivity(),4);
		grid.setLayoutManager(wgl);
		grid.setAdapter(adapter);
		text.setText(detail.getResult().getEvaluate());
		tagList=new ArrayList<TagView.Tag>();
		for(int i=0;i<detail.getResult().getTags().size();i++)
		{
			BangumiDetailObj.Tag temp=detail.getResult().getTags().get(i);
			TagView.Tag tag=new TagView.Tag(temp.getTagName(),getActivity().getResources().getColor(R.color.gray));
			tagList.add(tag);
		}
		tagView.setTags(tagList," ");
		initSeasonView(detail.getResult().getSeasons());
	}

	private void initSeasonView(List<BangumiDetailObj.InnerSeason> seasonList)
	{
		if(seasonList.size()>0)
		{
			LinearLayout container=new LinearLayout(getActivity());
			container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
			container.setOrientation(LinearLayout.HORIZONTAL);
			seasonListView.setVisibility(View.VISIBLE);
			seasonListTitle.setVisibility(View.VISIBLE);
			seasonListView.addView(container);
			int margin=getActivity().getResources().getDimensionPixelSize(R.dimen.item_half_spacing);
			for(int i=0;i<seasonList.size();i++)
			{
				View view=LayoutInflater.from(getActivity()).inflate(R.layout.bangumi_aty_season_item,container,false);
				LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams) view.getLayoutParams();
				if(i==0)
				{
					lp.leftMargin=0;
					lp.rightMargin=margin;
				}
				else if(i==seasonList.size()-1)
				{
					lp.leftMargin=margin;
					lp.rightMargin=0;
				}
				else
				{
					lp.leftMargin=margin;
					lp.rightMargin=margin;
				}
				view.setLayoutParams(lp);
				TextView title=(TextView) view.findViewById(R.id.title);
				ScalableImageView cover=(ScalableImageView) view.findViewById(R.id.cover);
				BangumiDetailObj.InnerSeason temp = seasonList.get(i);
				view.setTag(temp);
				title.setText(temp.getTitle());
				cover.setBackgroundResource(R.drawable.bili_default_image_tv_12_16);
				cover.setImageURI(Uri.parse(temp.getCover()));
				container.addView(view);
				view.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View p1)
						{
							BangumiDetailObj.InnerSeason temp=(BangumiDetailObj.InnerSeason) p1.getTag();
							Intent i=new Intent();
							i.setClass(getActivity(),BangumiDetailAty.class);
							i.putExtra("seasonId",temp.getSeasonId());
							getActivity().startActivity(i);
						}
					});
			}
		}
	}

	private void initView()
	{
		detail=(BangumiDetailObj) getArguments().getSerializable("data");
		seasonTitle=(TextView) view.findViewById(R.id.season_title);
		seasonTitleMore=(TextView) view.findViewById(R.id.season_title_more);
		seasonDescMore=(TextView) view.findViewById(R.id.season_desc_more);
		text=(TextView) view.findViewById(R.id.text);
		seasonListTitle=(TextView) view.findViewById(R.id.season_list_title);
		seasonListView=(HorizontalScrollView) view.findViewById(R.id.season_list);
		tagView=(TagView) view.findViewById(R.id.tags);
		grid=(RecyclerView) view.findViewById(R.id.grid);
		scrollView=(NestedScrollView) view.findViewById(R.id.scroll_view);
		scrollableView=scrollView;
	}
}
