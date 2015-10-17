package com.lh.biliclient.model;
import com.alibaba.fastjson.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.utils.*;

public class BangumiBPRankFragmentModel implements IBangumiBPRankFragmentModel
{

	@Override
	public BPRankObj getBpRankObj(String aid)
	{
		String json=HttpUtils.getHttpsCommonContent(BiliUtils.getBpList(aid));
		BPRankObj obj=JSON.parseObject(json,BPRankObj.class);
		return obj;
	}
	
}
