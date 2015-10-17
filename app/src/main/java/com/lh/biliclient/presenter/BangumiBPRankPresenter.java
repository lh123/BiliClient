package com.lh.biliclient.presenter;
import android.content.*;
import android.os.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.model.*;
import com.lh.biliclient.fragment.*;

public class BangumiBPRankPresenter
{
	private BPRankObj mBPRank;
	private Context mContext;
	private Handler mHandler;
	private IBangumiBPRankFragmentModel mModel;
	private IBangumiAtyBPFragment mFragment;
	private RefreshRunnable mRefreahRunnable;
	public BangumiBPRankPresenter(Context context,IBangumiAtyBPFragment fragment)
	{
		mContext=context;
		mFragment=fragment;
		mModel=new BangumiBPRankFragmentModel();
		mHandler=new Handler();
		mRefreahRunnable=new RefreshRunnable();
	}
	
	public void getBPRank(String aid)
	{
		if(mBPRank==null)
		{
			refreshBPRank(aid);
		}
		else
		{
			mFragment.onBPRankDataRefresh(mBPRank);
		}
	}

	public void refreshBPRank(String aid)
	{
		mRefreahRunnable.mAid=aid;
		new Thread(mRefreahRunnable).start();
	}
	
	class RefreshRunnable implements Runnable
	{
		private String mAid;
		
		@Override
		public void run()
		{
			mBPRank= mModel.getBpRankObj(mAid);
			mHandler.post(new Runnable(){

					@Override
					public void run()
					{
						mFragment.onBPRankDataRefresh(mBPRank);
					}
				});
		}
	}
}
