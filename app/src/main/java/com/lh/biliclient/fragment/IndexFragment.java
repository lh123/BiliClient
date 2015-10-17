package com.lh.biliclient.fragment;
import android.content.*;
import android.os.*;
import android.support.v4.widget.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.adapter.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.fragment.base.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.presenter.*;

public class IndexFragment extends MainBaseFragment implements SwipeRefreshLayout.OnRefreshListener,IIndexFragment
{
	public static final int REFRESHING=1;
	public static final int REFRESH_SUCCESS=2;
	public static final int REFRESH_FAIL=3;
	
	private View view;
	private IndexBannerAdapter banAdapter;
	private IndexRecyclerAdapter indexAdapter;

	private RecyclerView recyclerView;

	private SwipeRefreshLayout refreshLayout;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_index,container,false);
		banAdapter=new IndexBannerAdapter();
		indexAdapter=new IndexRecyclerAdapter(banAdapter);
		initFragment();
		return view;
	}
	
	private void initFragment()
	{
		MainDataPresenter.getInstance().registerIndexDataObserver(this);
		recyclerView=(RecyclerView) view.findViewById(R.id.my_recycler_view);
		refreshLayout=(SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);
		GridLayoutManager lm=new GridLayoutManager(getActivity(),2);
		lm.setOrientation(LinearLayoutManager.VERTICAL);
		lm.setSpanSizeLookup(indexAdapter.new SpanLookUp());
		IndexItemDecoration decoration=new IndexItemDecoration(getActivity().getResources().getDimensionPixelSize(R.dimen.item_margin_edg));
		recyclerView.addItemDecoration(decoration);
		recyclerView.setLayoutManager(lm);
		recyclerView.setAdapter(indexAdapter);
		refreshLayout.setOnRefreshListener(this);
		MainDataPresenter.getInstance().getIndexData();
	}

	@Override
	public void onIndexObjRefresh(IndexData data)
	{
		refreshLayout.setRefreshing(false);
		banAdapter.setData(data);
		indexAdapter.setData(data);
		indexAdapter.notifyDataSetChanged();
		banAdapter.notifyDataSetChanged();
	}

	@Override
	public void onRefreshError()
	{
		refreshLayout.setRefreshing(false);
		indexAdapter.notifyDataSetChanged();
		banAdapter.notifyDataSetChanged();
		Toast.makeText(getActivity(),"加载失败",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onRefresh()
	{
		refreshLayout.setRefreshing(true);
		MainDataPresenter.getInstance().refreshIndexData();
	}

	@Override
	public String getTitle()
	{
		return "推荐";
	}
}
