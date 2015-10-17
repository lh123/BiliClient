package com.lh.biliclient.fragment;
import android.os.*;
import android.support.v4.widget.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.adapter.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.fragment.base.*;
import com.lh.biliclient.presenter.*;

public class BangumiFragment extends MainBaseFragment implements SwipeRefreshLayout.OnRefreshListener,IMainBangumiFragment
{
	public static final int REFRESHING=1;
	public static final int REFRESH_SUCCESS=2;
	public static final int REFRESH_FAIL=3;
	private View view;
	private SwipeRefreshLayout refreshLayout;
	private RecyclerView recyclerView;
	public BangumiRecyclerAdapter bangumiAdapter;
	public BangumiBannerAdapter banAdapter;
	private BangumiItemDecoration decoration;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view=inflater.inflate(R.layout.fragment_bangumi,container,false);
		initFragment();
		return view;
	}
	
	private void initFragment()
	{
		MainDataPresenter.getInstance().registerMainBangumiDataObserver(this);
		banAdapter=new BangumiBannerAdapter();
		bangumiAdapter=new BangumiRecyclerAdapter(banAdapter,getActivity());
		decoration=new BangumiItemDecoration(getActivity().getResources().getDimensionPixelSize(R.dimen.item_margin_center),getActivity().getResources().getDimensionPixelSize(R.dimen.item_margin_edg));
		recyclerView=(RecyclerView) view.findViewById(R.id.my_recycler_view);
		refreshLayout=(SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);	
		StaggeredGridLayoutManager lm=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
		lm.setOrientation(GridLayoutManager.VERTICAL);
		//lm.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
		recyclerView.setLayoutManager(lm);
		recyclerView.addItemDecoration(decoration);
		recyclerView.setAdapter(bangumiAdapter);
		refreshLayout.setOnRefreshListener(this);
		MainDataPresenter.getInstance().getMainBangumiData();
	}

	@Override
	public void onBangumiDataRefresh(MainBangumiData data,boolean status)
	{
		//System.out.println("refresh_______");
		if(status==false)
		{
			Toast.makeText(getActivity(),"加载失败",Toast.LENGTH_SHORT).show();
		}
		refreshLayout.setRefreshing(false);
		banAdapter.setData(data.getBangumiBannerObj());
		bangumiAdapter.setData(data);
		banAdapter.notifyDataSetChanged();
		bangumiAdapter.notifyDataSetChanged();
	}
	
	@Override
	public void onRefresh()
	{
		refreshLayout.setRefreshing(true);
		MainDataPresenter.getInstance().refreshMainBangumiData();
	}
	
	@Override
	public String getTitle()
	{
		return "番剧";
	}
	
}
