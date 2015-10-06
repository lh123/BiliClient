package com.lh.biliclient.fragment;
import android.os.*;
import android.support.v4.app.*;
import android.support.v7.widget.*;
import android.view.*;
import com.lh.biliclient.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.widget.*;
import com.lh.biliclient.bean.*;
import java.util.*;
import com.lh.biliclient.adapter.*;
import com.lh.biliclient.activity.*;

public class BangumiAtyBPFragment extends Fragment implements ScrollableHelper.ScrollableContainer
{
	private View view;
	private RecyclerView recyclerView;
	public MyHandler handler;

	private BangumiAtyBPRecyclerViewAdapter adapter;
	public BangumiAtyBPFragment()
	{
		handler=new MyHandler();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view=inflater.inflate(R.layout.bangumi_aty_recommend,container,false);
		recyclerView=(RecyclerView) view.findViewById(R.id.my_recycler_view);
		LinearLayoutManager lm=new LinearLayoutManager(getActivity());
		lm.setOrientation(LinearLayoutManager.VERTICAL);
		adapter=new BangumiAtyBPRecyclerViewAdapter();
		recyclerView.setLayoutManager(lm);
		recyclerView.setAdapter(adapter);
		return view;
	}


	@Override
	public View getScrollableView()
	{
		return recyclerView;
	}
	class MyHandler extends Handler
	{
		@Override
		public void handleMessage(Message msg)
		{
			adapter.notifyDataSetChanged();
		}
	}
}
