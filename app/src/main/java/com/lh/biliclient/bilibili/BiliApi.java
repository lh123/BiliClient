package com.lh.biliclient.bilibili;
import android.content.*;
import android.graphics.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.utils.*;
import java.io.*;
import java.util.*;
import org.json.*;
import com.lh.biliclient.comparator.*;
import com.lh.biliclient.bean.BangumiDetail.*;

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
	
	public BangumiDetail getBangumiDetail(int spid)
	{
		try
		{
			String json=HttpUtils.getHttpCommonContent(BiliUtils.getBangumiDetailApi(spid));
			if(json == null)
			return null;
			JSONObject jsObj=new JSONObject(json);
			if(!jsObj.optString("code").equals("0"))
				return null;
			JSONObject result=jsObj.getJSONObject("result");
			BangumiDetail detail=new BangumiDetail();
			JSONArray actorArray=result.getJSONArray("actor");
			JSONArray episodesArray=result.getJSONArray("episodes");
			ArrayList<BangumiDetail.Actor> actorList=new ArrayList<BangumiDetail.Actor>();
			ArrayList<BangumiDetail.Episodes> episodesList=new ArrayList<BangumiDetail.Episodes>();
			for (int i=0;i < actorArray.length();i++)
			{
				JSONObject temp=actorArray.getJSONObject(i);
				BangumiDetail.Actor actor=detail.generateActor();
				actor.setActor(temp.optString("actor",null));
				actor.setActorId(temp.optInt("actor_id",-1));
				actor.setRole(temp.optString("role",null));
				actorList.add(actor);
			}
			detail.setActor(actorList);
			for(int i=0;i<episodesArray.length();i++)
			{
				JSONObject temp=episodesArray.getJSONObject(i);
				BangumiDetail.Episodes episodes=detail.generateEpisodes();
				episodes.setAvId(temp.optString("av_id",null));
				episodes.setCoins(temp.optString("coins",null));
				episodes.setCover(temp.optString("cover",null));
				episodes.setDanmaku(temp.optString("danmaku",null));
				episodes.setEpisodeId(temp.optString("episode_id",null));
				episodes.setIndex(temp.optString("index",null));
				episodes.setIndexTitle(temp.optString("index_title",null));
				episodes.setIsWebPlay(temp.optString("is_webplay",null));
				episodes.setPage(temp.optString("page",null));
				episodes.setUpdateTime(temp.optString("update_time",null));
				episodesList.add(episodes);
			}
			detail.setEpisodesList(episodesList);
			detail.setAlias(result.optString("alias",null));
			detail.setAllowBp(result.optString("allow_bp",null));
			detail.setAllowDownload(result.optString("allow_download",null));
			detail.setArea(result.optString("area",null));
			detail.setBangumiId(result.optString("bangumi_id",null));
			detail.setBangumiTitle(result.optString("bangumi_title",null));
			detail.setBrief(result.optString("brief",null));
			detail.setCoins(result.optString("coins",null));
			detail.setCover(result.optString("cover",null));
			detail.setDanmakuCount(result.optString("danmaku_count",null));
			detail.setEvaluate(result.optString("evaluate",null));
			//detail.se
			
		}
		catch (JSONException e)
		{}
		return null;
	}
	public ArrayList<VideoObj> getOnlineList()
	{
		try
		{
			ArrayList<VideoObj> list=new ArrayList<VideoObj>();
			String json=HttpUtils.getHttpCommonContent(BiliUtils.getOnlineListApi());
			if(json==null)
				return null;
			JSONArray array=new JSONObject(json).getJSONArray("list");
			//Iterator<String> it=jsobj.keys();
			for(int i=0;i<array.length();i++)
			{
				//JSONObject temp=it.next().getJSONObject(i);
				JSONObject temp=array.getJSONObject(i);
				VideoObj obj=new VideoObj();
				obj.setAid(temp.getString("aid"));
				obj.setTypeid(temp.getInt("typeid"));
				obj.setTitle(temp.getString("title"));
				obj.setPic(temp.getString("pic"));
				obj.setPlay(temp.getString("play"));
				obj.setVideo_review(temp.getString("video_review"));
				obj.setAuthor(temp.getString("author"));
				obj.setCopyright(temp.getString("copyright"));
				obj.setTypename(temp.getString("typename"));
				obj.setSubtitle(temp.getString("subtitle"));
				obj.setReview(temp.getInt("review"));
				obj.setFavorites(temp.getInt("favorites"));
				obj.setMid(temp.getInt("mid"));
				obj.setDescription(temp.getString("description"));
				obj.setCreate(temp.getString("create"));
				obj.setCredit(temp.getInt("credit"));
				obj.setCoins(temp.getInt("coins"));
				obj.setDuration(temp.getString("duration"));
				obj.setOnline(temp.getInt("online"));
				list.add(obj);
			}
			return list;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BangumiRecommendObj> getRecommendList()
	{
		try
		{
			ArrayList<BangumiRecommendObj> list=new ArrayList<BangumiRecommendObj>();
			String json=HttpUtils.getHttpContentWithCache(BiliUtils.getBangumiRecommenfListApi(),"data",HttpUtils.RECOMMEND,false);
			JSONArray array=new JSONObject(json).getJSONArray("list");
			for(int i=0;i<array.length();i++)
			{
				BangumiRecommendObj obj=new BangumiRecommendObj();
				JSONObject temp=array.getJSONObject(i);
				obj.setTitle(temp.optString("title"));
				obj.setRemark(temp.optString("remark"));
				obj.setRemark2(temp.optString("remark2"));
				obj.setStyle(temp.optString("style"));
				obj.setImagekey(temp.optString("imagekey"));
				obj.setImageurl(temp.optString("imageurl"));
				obj.setWidth(temp.optInt("width"));
				obj.setHeight(temp.optInt("height"));
				obj.setType(temp.optString("type"));
				obj.setSpname(temp.optString("spname"));
				obj.setSpid(temp.optInt("spid"));
				obj.setAvid(temp.optString("avid"));
				obj.setEndepcount(temp.optInt("endepcount",-1));
				list.add(obj);
			}
			Collections.sort(list,new RecommendComparator());
			return list;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BangumiBannerObj> getBangumiBannerList()
	{
		try
		{
			ArrayList<BangumiBannerObj> list=new ArrayList<BangumiBannerObj>();
			String json=HttpUtils.getHttpContentWithCache(BiliUtils.getBannerListApi(),"data",HttpUtils.BANGUMI_BANNER,false);
			
			JSONArray array=new JSONObject(json).getJSONObject("result").getJSONArray("banners");
			for(int i=0;i<array.length();i++)
			{
				BangumiBannerObj obj=new BangumiBannerObj();
				JSONObject temp=array.getJSONObject(i);
				obj.setTitle(temp.optString("title"));
				obj.setLink(temp.optString("link"));
				obj.setImg(temp.optString("img"));
				obj.setSimg(temp.optString("simg"));
				obj.setType(temp.optString("type"));
				obj.setAid(temp.optInt("aid"));
				obj.setPid(temp.optInt("pid"));
				list.add(obj);
			}
			return list;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return null;
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
	
	public IndexData getIndexData()
	{
		try
		{
			String json=HttpUtils.getHttpContentWithCache(BiliUtils.getIndexApi(), "data", "index.json", false);
			JSONObject jsObj=new JSONObject(json);
			if(jsObj.optInt("code",-1)!=0)
				return null;
			JSONArray array=jsObj.getJSONArray("result");
			IndexData data=new IndexData();
			for(int i=0;i<array.length();i++)
			{
				JSONObject jsonTemp = array.getJSONObject(i);
				JSONObject head=jsonTemp.getJSONObject("head");
				String headGoto=head.optString("goto",null);
				String headParam=head.optString("param",null);
				String headStyle=head.optString("style",null);
				String headTitle=head.optString("title",null);
				String headType=jsonTemp.optString("type",null);
				JSONArray tempArray=jsonTemp.getJSONArray("body");
				ArrayList<IndexObj> list=new ArrayList<IndexObj>();
				for(int j=0;j<tempArray.length();j++)
				{
					JSONObject temp=tempArray.getJSONObject(j);
					IndexObj obj=new IndexObj();
					obj.setCover(temp.optString("cover",null));
					obj.setDanmaku(temp.optString("danmaku",null));
					obj.setDesc1(temp.optString("desc1",null));
					obj.setDesc2(temp.optString("desc2",null));
					obj.setGo_to(temp.optString("goto",null));
					obj.setHeight(temp.optInt("height",-1));
					obj.setIs_random(temp.optString("is_random",null));
					obj.setLast_ep(temp.optString("last_ep",null));
					obj.setParam(temp.optString("param",null));
					obj.setOnline(temp.optString("online",null));
					obj.setPlay(temp.optString("play",null));
					obj.setSmall_cover(temp.optString("small_cover",null));
					obj.setStyle(temp.optString("style",null));
					obj.setTitle(temp.optString("title",null));
					obj.setWidth(temp.optInt("width",-1));
					obj.setBadge2(temp.optString("badge2",null));
					obj.setBadge_bg(temp.optString("badge_bg",null));
					obj.setBadge_color(temp.optString("badge_color",null));
					obj.setUp(temp.optString("up",null));
					obj.setUp_face(temp.optString("up_face",null));
					obj.setHead_goto(headGoto);
					obj.setHead_param(headParam);
					obj.setHead_style(headStyle);
					obj.setHead_title(headTitle);
					obj.setHead_type(headType);
					list.add(obj);
				}
				switch(i)
				{
					case 0:
						data.setHotRecommend(list);
						break;
					case 1:
						data.setUpdateBangumi(list);
						break;
					case 2:
						data.setOnline(list);
						break;
					case 3:
						data.setTopic(list);
						break;
					case 4:
						data.setCartoon(list);
						break;
					case 5:
						data.setMusic(list);
						break;
					case 6:
						data.setDance(list);
						break;
					case 7:
						data.setGame(list);
						break;
					case 8:
						data.setTopic2(list);
						break;
					case 9:
						data.setGuichu(list);
						break;
					case 10:
						data.setTechnology(list);
						break;
					case 11:
						data.setAmuse(list);
						break;
					case 12:
						data.setTv(list);
						break;
					case 13:
						data.setMovie(list);
						break;
					case 14:
						data.setMusicTv(list);
						break;
				}
			}
			return data;
		}
		catch (JSONException e)
		{}
		return null;
	}
	
	
	public ArrayList<IndexBannerObj> getIndexBannerObj()
	{
		String json=HttpUtils.getHttpContentWithCache(BiliUtils.getIndexBannerApi(),"data","index_banner.json",true);
		try
		{
			ArrayList<IndexBannerObj> list=new ArrayList<IndexBannerObj>();
			JSONObject parentJs=new JSONObject(json);
			if (parentJs.optInt("code", -1) != 0)
				return null;
			JSONArray array=parentJs.getJSONArray("list");
			for (int i=0;i < array.length();i++)
			{
				JSONObject temp=array.getJSONObject(i);
				IndexBannerObj obj=new IndexBannerObj();
				obj.setTitle(temp.optString("title",null));
				obj.setRemark(temp.optString("remark",null));
				obj.setRemark2(temp.optString("remark2",null));
				obj.setStyle(temp.optString("style",null));
				obj.setImagekey(temp.optString("imagekey",null));
				obj.setImageurl(temp.optString("imageurl",null));
				obj.setWidth(temp.optInt("width",-1));
				obj.setHeight(temp.optInt("height",-1));
				obj.setWeburl(temp.optString("weburl",null));
				obj.setSpname(temp.optString("spname",null));
				obj.setSpid(temp.optInt("spid",-1));
				list.add(obj);
			}
			return list;
		}
		catch (JSONException e)
		{
		}
		return null;
	}
	
}
