package com.lh.biliclient.presenter;
import android.os.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.fragment.*;
import com.lh.biliclient.model.*;

public class MainDataPresenter
{
	private static MainDataPresenter mMainDataPresenter;
	private IMainBangumiFragment mBangumiFragment;
	private IMainBanguiFragmentModel mBangumiModel;
	
	private IMainIndexFragmentModel mIndexModel;
	private IIndexFragment mIndexFragment;
	
	private Handler mHandler;
	
	private MainBangumiData mMainBangumiData;
	private IndexData mIndexData;
	
	private boolean isRefreshMainBangumiData=false;
	private boolean isRefreshIndexData=false;

	private MainDataPresenter()
	{
		mBangumiModel = new MainBangumiFragmentModel();
		mIndexModel=new MainIndexFragmentModel();
		mHandler = new Handler();
	}

	public static MainDataPresenter getInstance()
	{
		if (mMainDataPresenter == null)
		{
			synchronized (MainDataPresenter.class)
			{
				if (mMainDataPresenter == null)
				{
					mMainDataPresenter = new MainDataPresenter();
				}
			}
		}
		return mMainDataPresenter;
	}

	public void registerMainBangumiDataObserver(IMainBangumiFragment o)
	{
		mBangumiFragment = o;
	}

	public void registerIndexDataObserver(IIndexFragment o)
	{
		mIndexFragment = o;
	}
	
	public void getMainBangumiData()
	{
		if (mMainBangumiData != null)
		{
			notifyMainBangumiDataChange();
		}
		else
		{
			refreshMainBangumiData();
		}
	}

	public void getIndexData()
	{
		if (mIndexData != null)
		{
			notifyIndexDataChange();
		}
		else
		{
			refreshIndexData();
		}
	}

	public void refreshIndexData()
	{
		if (isRefreshIndexData == true)
			return;
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					isRefreshIndexData = true;
					mIndexData = mIndexModel.getIndexData();
					isRefreshIndexData = false;
					mHandler.post(new Runnable(){

							@Override
							public void run()
							{
								notifyIndexDataChange();
							}
						});
				}
			}).start();
	}

	public void refreshMainBangumiData()
	{
		if (isRefreshMainBangumiData == true)
			return;
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					isRefreshMainBangumiData = true;
					mMainBangumiData = mBangumiModel.getMainData();
					isRefreshMainBangumiData = false;
					mHandler.post(new Runnable(){

							@Override
							public void run()
							{
								notifyMainBangumiDataChange();
							}
						});
				}
			}).start();
	}
	
	private void notifyMainBangumiDataChange()
	{
		if(mBangumiFragment==null)
			return;
		if (mMainBangumiData.getOnlineObj() == null)
		{
			mBangumiFragment.onBangumiDataRefresh(mMainBangumiData, false);
		}
		else
		{
			mBangumiFragment.onBangumiDataRefresh(mMainBangumiData, true);
		}
	}
	
	private void notifyIndexDataChange()
	{
		if(mIndexFragment==null)
			return;
		if (mIndexData.getBannerObj() == null||mIndexData.getIndexObj()==null)
		{
			mIndexFragment.onRefreshError();
		}
		else
		{
			mIndexFragment.onIndexObjRefresh(mIndexData);
		}
	}
	
}
