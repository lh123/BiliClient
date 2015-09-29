package com.lh.biliclient.fragment;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.widget.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.adapter.*;
import com.lh.biliclient.bilibili.*;
import android.content.*;
import java.util.*;
import com.lh.biliclient.bean.*;

public class BangumiFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener
{
	public static final int REFRESHING=1;
	public static final int REFRESH_SUCCESS=2;
	public static final int REFRESH_FAIL=3;
	private View view;
	private SwipeRefreshLayout refreshLayout;
	private RecyclerView recyclerView;
	public BangumiRecyclerAdapter bangumiAdapter;
	public BangumiBannerAdapter banAdapter;
	public static RefreshHandler handler;
	private ViewItemDecoration decoration;

	@Override
	public void onAttach(Context context)
	{
		handler=new RefreshHandler();
		banAdapter=new BangumiBannerAdapter();
		bangumiAdapter=new BangumiRecyclerAdapter(banAdapter);
		decoration=new ViewItemDecoration(getActivity().getResources().getDimensionPixelSize(R.dimen.recommend_margin_center),getActivity().getResources().getDimensionPixelSize(R.dimen.recommend_margin_edg));
		super.onAttach(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view=inflater.inflate(R.layout.fragment_bangumi,container,false);
		initFragment();
		return view;
	}

	@Override
	public void onStart()
	{
		
		super.onStart();
	}
	
	private void initFragment()
	{
		recyclerView=(RecyclerView) view.findViewById(R.id.my_recycler_view);
		refreshLayout=(SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);	
		StaggeredGridLayoutManager lm=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
		lm.setOrientation(GridLayoutManager.VERTICAL);
		//lm.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
		recyclerView.setLayoutManager(lm);
		recyclerView.addItemDecoration(decoration);
		recyclerView.setAdapter(bangumiAdapter);
		refreshLayout.setOnRefreshListener(this);
	}

	@Override
	public void onRefresh()
	{
		refreshLayout.setRefreshing(true);
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					BiliData.onlineList=BiliApi.getInstance().getOnlineList();
					BiliData.bangumiBannerList=BiliApi.getInstance().getBangumiBannerList();
					BiliData.recommendList=BiliApi.getInstance().getRecommendList();
					if(BiliData.onlineList==null)
						handler.sendEmptyMessage(REFRESH_FAIL);
					else
						handler.sendEmptyMessage(REFRESH_SUCCESS);
				}}).start();
	}
	
	public class RefreshHandler extends Handler
	{
		@Override
		public void handleMessage(Message msg)
		{
			switch(msg.what)
			{
				case REFRESH_SUCCESS:
					refreshLayout.setRefreshing(false);
					bangumiAdapter.notifyDataSetChanged();
					banAdapter.notifyDataSetChanged();
					break;
				case REFRESH_FAIL:
					refreshLayout.setRefreshing(false);
					bangumiAdapter.notifyDataSetChanged();
					banAdapter.notifyDataSetChanged();
					Toast.makeText(getActivity(),"加载失败",Toast.LENGTH_SHORT).show();
					break;
			}
		}
		
	}
}
