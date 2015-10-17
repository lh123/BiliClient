package com.lh.biliclient.fragment;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import com.lh.biliclient.*;
import com.lh.biliclient.activity.*;
import com.lh.biliclient.adapter.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.fragment.base.*;
import com.lh.biliclient.presenter.*;
import com.lh.biliclient.widget.*;

public class BangumiAtyBPFragment extends BangumiDetailBaseFragment implements IBangumiAtyBPFragment,BangumigBPRankEpisodesRecyclerViewAdapter.CallBack,BangumiAtyBPRecyclerViewAdapter.Callback
{
	private View view;
	private RecyclerView recyclerView;
	private BangumiBPRankPresenter mPresenter;
	private BangumiAtyBPRecyclerViewAdapter adapter;
	private BangumigBPRankEpisodesRecyclerViewAdapter mEpiaodesAdapter;
	private AlertDialog dialog;
	public BangumiDetailObj mDetail;
	private int mPosition;

	public BangumiAtyBPFragment()
	{
		title = "承包商排行";
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mPresenter = new BangumiBPRankPresenter(getActivity(), this);
		mDetail=(BangumiDetailObj) getArguments().getSerializable("data");
		view = inflater.inflate(R.layout.bangumi_aty_bprank, container, false);
		mEpiaodesAdapter = new BangumigBPRankEpisodesRecyclerViewAdapter(mDetail);
		if("1".equals(mDetail.getResult().getIsFinish()))
		{
			mPosition=mDetail.getResult().getEpisodes().size()-1;
		}
		adapter = new BangumiAtyBPRecyclerViewAdapter(mEpiaodesAdapter,mDetail);
		initRecyclerView();
		return view;
	}

	private void initRecyclerView()
	{
		recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		scrollableView = recyclerView;
		LinearLayoutManager lm=new LinearLayoutManager(getActivity());
		lm.setOrientation(LinearLayoutManager.VERTICAL);
		adapter.setCallback(this);
		mEpiaodesAdapter.setCallBack(this);
		recyclerView.setLayoutManager(lm);
		recyclerView.setAdapter(adapter);
		mPresenter.getBPRank(mDetail.getResult().getEpisodes().get(0).getAvId());
	}

	@Override
	public void onBPRankDataRefresh(BPRankObj obj)
	{
		adapter.bpRank = obj;
		adapter.notifyDataSetChanged();
	}

	@Override
	public void click(BangumiDetailObj.Episodes obj, String index, int position)
	{
		mPosition=position;
		dialog.dismiss();
		adapter.setIndex(index);
		adapter.notifyItemChanged(0);
		mPresenter.refreshBPRank(obj.getAvId());
	}

	@Override
	public void onHeadClick()
	{
		View dialogView=LayoutInflater.from(getActivity()).inflate(R.layout.dialog_recyclerview, null);
		recyclerView = (RecyclerView) dialogView.findViewById(R.id.my_recycler_view);
		WrapGridLayoutManager gl = new WrapGridLayoutManager(getActivity(), 4);
		mEpiaodesAdapter.setPosition(mPosition);
		recyclerView.setLayoutManager(gl);
		recyclerView.setAdapter(mEpiaodesAdapter);
		AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
		builder.setTitle("集数选择");
		builder.setView(dialogView);
		//adapter.notifyDataSetChanged();
		dialog = builder.create();
		dialog.show();
	}

}
