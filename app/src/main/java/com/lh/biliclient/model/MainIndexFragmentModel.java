package com.lh.biliclient.model;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.utils.*;
import com.alibaba.fastjson.*;

public class MainIndexFragmentModel implements IMainIndexFragmentModel
{
	@Override
	public IndexData getIndexData()
	{
		IndexData data=new IndexData();
		data.setBannerObj(getIndexBannerObj());
		data.setIndexObj(getIndexObj());
		return data;
	}
	
	public IndexBannerObj getIndexBannerObj()
	{
		String json=HttpUtils.getHttpContentWithCache(BiliUtils.getIndexBannerApi(),"data","index_banner.json",true);
		if(json==null)
			return null;
		IndexBannerObj obj=JSON.parseObject(json,IndexBannerObj.class);
		return obj;
	}
	
	public IndexObj getIndexObj()
	{
		String json=HttpUtils.getHttpContentWithCache(BiliUtils.getIndexApi(), "data", "index.json", false);
		if(json==null)
			return null;
		IndexObj obj=JSON.parseObject(json,IndexObj.class);
		return obj;
	}
}
