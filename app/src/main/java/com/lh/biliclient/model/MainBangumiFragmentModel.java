package com.lh.biliclient.model;

import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.utils.*;
import com.alibaba.fastjson.*;

public class MainBangumiFragmentModel implements IMainBanguiFragmentModel
{

	@Override
	public MainBangumiData getMainData()
	{
		MainBangumiData data=new MainBangumiData();
		data.setBangumiBannerObj(getBangumiBannerObj());
		data.setOnlineObj(getOnlineListObj());
		data.setRecommendObj(getRecommendObj());
		return data;
	}
	
	public OnlineListObj getOnlineListObj()
	{
		String json=HttpUtils.getHttpCommonContent(BiliUtils.getOnlineListApi());
		if(json==null)
			return null;
		OnlineListObj obj=JSON.parseObject(json,OnlineListObj.class);
		return obj;
	}
	
	public BangumiRecommendObj getRecommendObj()
	{
		String json=HttpUtils.getHttpContentWithCache(BiliUtils.getBangumiRecommenfListApi(),"data",HttpUtils.RECOMMEND,false);
		if(json==null)
			return null;
		BangumiRecommendObj obj=JSON.parseObject(json,BangumiRecommendObj.class);
		return obj;
	}
	
	public BangumiBannerObj getBangumiBannerObj()
	{
		String json=HttpUtils.getHttpContentWithCache(BiliUtils.getBannerListApi(),"data",HttpUtils.BANGUMI_BANNER,false);
		if(json==null)
			return null;
		BangumiBannerObj obj=JSON.parseObject(json,BangumiBannerObj.class);
		return obj;
	}
	
}
