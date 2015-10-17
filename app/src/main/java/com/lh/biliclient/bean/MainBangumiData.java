package com.lh.biliclient.bean;

import java.util.*;

public class MainBangumiData
{
	private OnlineListObj onlineObj;
	private BangumiRecommendObj recommendObj;
	private BangumiBannerObj bangumiBannerObj;
	

	public void setOnlineObj(OnlineListObj onlineObj)
	{
		this.onlineObj = onlineObj;
	}

	public OnlineListObj getOnlineObj()
	{
		return onlineObj;
	}

	public void setRecommendObj(BangumiRecommendObj recommendObj)
	{
		this.recommendObj = recommendObj;
	}

	public BangumiRecommendObj getRecommendObj()
	{
		return recommendObj;
	}

	public void setBangumiBannerObj(BangumiBannerObj bangumiBannerObj)
	{
		this.bangumiBannerObj = bangumiBannerObj;
	}

	public BangumiBannerObj getBangumiBannerObj()
	{
		return bangumiBannerObj;
	}
	
}
