package com.lh.biliclient.bilibili;

import com.alibaba.fastjson.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.utils.*;
import java.util.*;
import org.json.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BiliApi
{
	private static BiliApi mBiliApi;
	public static BiliApi getInstance()
	{
		if(mBiliApi==null)
		{
			synchronized(BiliApi.class)
			{
				if(mBiliApi==null)
				{
					mBiliApi=new BiliApi();
				}
			}
		}
		return mBiliApi;
	}
	
	public SplashObj getSplashObj()
	{
		try{
			String json=HttpUtils.getHttpContentWithCache(BiliUtils.getSplashApi(), "splash", "splash.json",true);
			if(json==null)
				return null;
			JSONObject jsobj=new JSONObject(json);
			if (jsobj.optString("message").equals("success"))
			{
				JSONArray array=jsobj.getJSONArray("result");
				JSONObject temp=array.getJSONObject(0);
				SplashObj obj=new SplashObj();
				obj.setAnimation(temp.optString("animation"));
				obj.setDuration(temp.optString("duration"));
				obj.setEnd(temp.optLong("end"));
				obj.setHeight(temp.optInt("height"));
				obj.setImage(temp.optString("image"));
				obj.setStart(temp.optLong("start"));
				obj.setWidth(temp.optInt("width"));
				obj.setVer(temp.optInt("ver"));
				return obj;
			}
		}
		catch (JSONException e)
		{}
		return null;
	}
	
	public BPRankObj getBPRankList(String aid)
	{
		String json=HttpUtils.getHttpsCommonContent(BiliUtils.getBpList(aid));
		BPRankObj obj=JSON.parseObject(json,BPRankObj.class);
		return obj;
	}
}
