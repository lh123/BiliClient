package com.lh.biliclient.fragment;
import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.widget.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.adapter.*;
import com.lh.biliclient.bilibili.*;

public class IndexFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener
{
	public static final int REFRESHING=1;
	public static final int REFRESH_SUCCESS=2;
	public static final int REFRESH_FAIL=3;
	
	private View view;
	private IndexFragment.RefreshHandler handler;
	private IndexBannerAdapter banAdapter;
	private IndexRecyclerAdapter indexAdapter;
	//private ViewItemDecoration decoration;

	private RecyclerView recyclerView;

	private SwipeRefreshLayout refreshLayout;
	
	@Override
	public void onAttach(Context context)
	{
		handler=new RefreshHandler();
		banAdapter=new IndexBannerAdapter();
		indexAdapter=new IndexRecyclerAdapter(banAdapter);
		//decoration=new ViewItemDecoration(getActivity().getResources().getDimensionPixelSize(R.dimen.recommend_margin_center),getActivity().getResources().getDimensionPixelSize(R.dimen.recommend_margin_edg));
		super.onAttach(context);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_index,container,false);
		initFragment();
		return view;
	}
	
	private void initFragment()
	{
		recyclerView=(RecyclerView) view.findViewById(R.id.my_recycler_view);
		refreshLayout=(SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);	
		LinearLayoutManager lm=new LinearLayoutManager(getActivity());
		lm.setOrientation(LinearLayoutManager.VERTICAL);
		//lm.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
		recyclerView.setLayoutManager(lm);
		//recyclerView.addItemDecoration(decoration);
		recyclerView.setAdapter(indexAdapter);
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
					BiliData.indexData=BiliApi.getInstance().getIndexData();
					BiliData.indexBannerList=BiliApi.getInstance().getIndexBannerObj();
					if(BiliData.indexData==null)
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
					indexAdapter.notifyDataSetChanged();
					banAdapter.notifyDataSetChanged();
					indexAdapter.lanAdapter.notifyDataSetChanged();
					break;
				case REFRESH_FAIL:
					refreshLayout.setRefreshing(false);
					indexAdapter.notifyDataSetChanged();
					banAdapter.notifyDataSetChanged();
					Toast.makeText(getActivity(),"加载失败",Toast.LENGTH_SHORT).show();
					break;
			}
		}

	}
}
