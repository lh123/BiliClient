package com.lh.biliclient.model;
import com.alibaba.fastjson.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.utils.*;

public class BangumiDetailAtyModel implements IBangumiDetailAtyModel
{
	@Override
	public BangumiDetailObj getBangumiDetaiObj(int spid, String seasonId)
	{
		String json = null;
		if(spid!=-1)
			json=HttpUtils.getHttpCommonContent(BiliUtils.getBangumiDetailBySpidApi(spid));
		else if(seasonId!=null)
			json=HttpUtils.getHttpCommonContent(BiliUtils.getBangumiDetailBySeasonidApi(seasonId));
		if(json == null)
			return null;
		BangumiDetailObj obj=JSON.parseObject(json,BangumiDetailObj.class);
		return obj;
	}
	
}
