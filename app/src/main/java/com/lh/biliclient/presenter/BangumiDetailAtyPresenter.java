package com.lh.biliclient.presenter;
import android.content.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.activity.*;
import com.lh.biliclient.model.*;
import android.os.*;

public class BangumiDetailAtyPresenter
{
	private BangumiDetailObj mObj;
	private IBangumiDetailAty mAty;
	private IBangumiDetailAtyModel mModel;
	private Handler mHandler;
	private RefreshRunnable mRunnable;

	public BangumiDetailAtyPresenter(IBangumiDetailAty aty)
	{
		mAty=aty;
		mModel=new BangumiDetailAtyModel();
		mHandler=new Handler();
		mRunnable=new RefreshRunnable();
	}
	
	public void getBangumiDetailData(int spid, String seasonId)
	{
		if(mObj==null)
		{
			refreshBangumiDetailData(spid,seasonId);
		}
		else
		{
			mAty.onBangumiDataChange(mObj);
		}
	}

	public void refreshBangumiDetailData(int spid, String seasonId)
	{
		mRunnable.spid=spid;
		mRunnable.seasonId=seasonId;
		new Thread(mRunnable).start();
	}
	
	class RefreshRunnable implements Runnable
	{
		private int spid;
		private String seasonId;
		@Override
		public void run()
		{
			mObj=mModel.getBangumiDetaiObj(spid,seasonId);
			if(mObj!=null)
			{
				mHandler.post(new Runnable(){

						@Override
						public void run()
						{
							mAty.onBangumiDataChange(mObj);
						}
					});
			}
			else
			{
				mHandler.post(new Runnable(){

						@Override
						public void run()
						{
							mAty.onBangumiDataError();
						}
					});
			}
		}
	}
}
