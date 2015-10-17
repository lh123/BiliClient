package com.lh.biliclient.bean;
import java.util.*;
import java.io.*;
import com.alibaba.fastjson.annotation.*;

public class BangumiDetailObj implements Serializable
{
	private String code;
	private String message;
	private Result result;
	
	public void setCode(String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

	public void setResult(Result result)
	{
		this.result = result;
	}

	public Result getResult()
	{
		return result;
	}
	
	public static class Result implements Serializable
	{
		private List<Actor> actor;
		private List<Episodes> episodes;
		private List<InnerSeason> seasons;
		private List<Tag> tags;
		private String alias;
		@JSONField(name="allow_bp")
		private String allowBp;
		@JSONField(name="allow_download")
		private String allowDownload;
		private String area;
		private int arealimit;
		@JSONField(name="bangumi_id")
		private String bangumiId;
		@JSONField(name="bangumi_title")
		private String bangumiTitle;
		private String brief;
		private String coins;
		private String cover;
		@JSONField(name="danmaku_count")
		private String danmakuCount;
		private String evaluate;
		private String favorites;
		@JSONField(name="is_finish")
		private String isFinish;
		@JSONField(name="newest_ep_id")
		private String newestEpId;
		@JSONField(name="newest_ep_index")
		private String newestEpIndex;
		@JSONField(name="play_count")
		private String playCount;
		@JSONField(name="pub_time")
		private String pubTime;
		@JSONField(name="season_id")
		private String seasonId;
		@JSONField(name="season_title")
		private String seasonTitle;
		@JSONField(name="share_url")
		private String shareUrl;
		private String squareCover;
		private String staff;
		//private String tag2s;
		private String title;
		@JSONField(name="total_count")
		private String totalCount;
		private String weekday;


		public void setActor(List<Actor> actor)
		{
			this.actor = actor;
		}

		public List<Actor> getActor()
		{
			return actor;
		}

		public void setEpisodes(List<Episodes> episodes)
		{
			this.episodes = episodes;
		}

		public List<Episodes> getEpisodes()
		{
			return episodes;
		}

		public void setSeasons(List<InnerSeason> seasons)
		{
			this.seasons = seasons;
		}

		public List<InnerSeason> getSeasons()
		{
			return seasons;
		}

		public void setTags(List<Tag> tags)
		{
			this.tags = tags;
		}

		public List<Tag> getTags()
		{
			return tags;
		}

		public void setAlias(String alias)
		{
			this.alias = alias;
		}

		public String getAlias()
		{
			return alias;
		}

		public void setAllowBp(String allowBp)
		{
			this.allowBp = allowBp;
		}

		public String getAllowBp()
		{
			return allowBp;
		}

		public void setAllowDownload(String allowDownload)
		{
			this.allowDownload = allowDownload;
		}

		public String getAllowDownload()
		{
			return allowDownload;
		}

		public void setArea(String area)
		{
			this.area = area;
		}

		public String getArea()
		{
			return area;
		}

		public void setArealimit(int arealimit)
		{
			this.arealimit = arealimit;
		}

		public int getArealimit()
		{
			return arealimit;
		}

		public void setBangumiId(String bangumiId)
		{
			this.bangumiId = bangumiId;
		}

		public String getBangumiId()
		{
			return bangumiId;
		}

		public void setBangumiTitle(String bangumiTitle)
		{
			this.bangumiTitle = bangumiTitle;
		}

		public String getBangumiTitle()
		{
			return bangumiTitle;
		}

		public void setBrief(String brief)
		{
			this.brief = brief;
		}

		public String getBrief()
		{
			return brief;
		}

		public void setCoins(String coins)
		{
			this.coins = coins;
		}

		public String getCoins()
		{
			return coins;
		}

		public void setCover(String cover)
		{
			this.cover = cover;
		}

		public String getCover()
		{
			return cover;
		}

		public void setDanmakuCount(String danmakuCount)
		{
			this.danmakuCount = danmakuCount;
		}

		public String getDanmakuCount()
		{
			return danmakuCount;
		}

		public void setEvaluate(String evaluate)
		{
			this.evaluate = evaluate;
		}

		public String getEvaluate()
		{
			return evaluate;
		}

		public void setFavorites(String favorites)
		{
			this.favorites = favorites;
		}

		public String getFavorites()
		{
			return favorites;
		}

		public void setIsFinish(String isFinish)
		{
			this.isFinish = isFinish;
		}

		public String getIsFinish()
		{
			return isFinish;
		}

		public void setNewestEpId(String newestEpId)
		{
			this.newestEpId = newestEpId;
		}

		public String getNewestEpId()
		{
			return newestEpId;
		}

		public void setNewestEpIndex(String newestEpIndex)
		{
			this.newestEpIndex = newestEpIndex;
		}

		public String getNewestEpIndex()
		{
			return newestEpIndex;
		}

		public void setPlayCount(String playCount)
		{
			this.playCount = playCount;
		}

		public String getPlayCount()
		{
			return playCount;
		}

		public void setPubTime(String pubTime)
		{
			this.pubTime = pubTime;
		}

		public String getPubTime()
		{
			return pubTime;
		}

		public void setSeasonId(String seasonId)
		{
			this.seasonId = seasonId;
		}

		public String getSeasonId()
		{
			return seasonId;
		}

		public void setSeasonTitle(String seasonTitle)
		{
			this.seasonTitle = seasonTitle;
		}

		public String getSeasonTitle()
		{
			return seasonTitle;
		}

		public void setShareUrl(String shareUrl)
		{
			this.shareUrl = shareUrl;
		}

		public String getShareUrl()
		{
			return shareUrl;
		}

		public void setSquareCover(String squareCover)
		{
			this.squareCover = squareCover;
		}

		public String getSquareCover()
		{
			return squareCover;
		}

		public void setStaff(String staff)
		{
			this.staff = staff;
		}

		public String getStaff()
		{
			return staff;
		}

		public void setTitle(String title)
		{
			this.title = title;
		}

		public String getTitle()
		{
			return title;
		}

		public void setTotalCount(String totalCount)
		{
			this.totalCount = totalCount;
		}

		public String getTotalCount()
		{
			return totalCount;
		}

		public void setWeekday(String weekday)
		{
			this.weekday = weekday;
		}

		public String getWeekday()
		{
			return weekday;
		}
	}
	
	public static class Actor implements Serializable
	{
		private String actor;
		@JSONField(name="actor_id")
		private int actorId;
		private String role;


		public void setActor(String actor)
		{
			this.actor = actor;
		}

		public String getActor()
		{
			return actor;
		}

		public void setActorId(int actorId)
		{
			this.actorId = actorId;
		}

		public int getActorId()
		{
			return actorId;
		}

		public void setRole(String role)
		{
			this.role = role;
		}

		public String getRole()
		{
			return role;
		}
	}
	
	public static class Episodes implements Serializable
	{
		@JSONField(name="av_id")
		private String avId;
		private String coins;
		private String cover;
		private String danmaku;
		@JSONField(name="episode_id")
		private String episodeId;
		private String index;
		@JSONField(name="index_title")
		private String indexTitle;
		@JSONField(name="is_webplay")
		private String isWebPlay;
		private String page;
		//private String up;
		@JSONField(name="update_time")
		private String updateTime;


		public void setAvId(String avId)
		{
			this.avId = avId;
		}

		public String getAvId()
		{
			return avId;
		}

		public void setCoins(String coins)
		{
			this.coins = coins;
		}

		public String getCoins()
		{
			return coins;
		}

		public void setCover(String cover)
		{
			this.cover = cover;
		}

		public String getCover()
		{
			return cover;
		}

		public void setDanmaku(String danmaku)
		{
			this.danmaku = danmaku;
		}

		public String getDanmaku()
		{
			return danmaku;
		}

		public void setEpisodeId(String episodeId)
		{
			this.episodeId = episodeId;
		}

		public String getEpisodeId()
		{
			return episodeId;
		}

		public void setIndex(String index)
		{
			this.index = index;
		}

		public String getIndex()
		{
			return index;
		}

		public void setIndexTitle(String indexTitle)
		{
			this.indexTitle = indexTitle;
		}

		public String getIndexTitle()
		{
			return indexTitle;
		}

		public void setIsWebPlay(String isWebPlay)
		{
			this.isWebPlay = isWebPlay;
		}

		public String getIsWebPlay()
		{
			return isWebPlay;
		}

		public void setPage(String page)
		{
			this.page = page;
		}

		public String getPage()
		{
			return page;
		}

		public void setUpdateTime(String updateTime)
		{
			this.updateTime = updateTime;
		}

		public String getUpdateTime()
		{
			return updateTime;
		}
	}
	
	public static class InnerSeason implements Serializable
	{
		private String cover;
		@JSONField(name="is_finish")
		private String isFinish;
		@JSONField(name="newest_ep_id")
		private String newestEpId;
		@JSONField(name="newest_ep_index")
		private String newestEpIndex;
		@JSONField(name="season_id")
		private String seasonId;
		private String title;
		@JSONField(name="total_count")
		private String totalCount;


		public void setCover(String cover)
		{
			this.cover = cover;
		}

		public String getCover()
		{
			return cover;
		}

		public void setIsFinish(String isFinish)
		{
			this.isFinish = isFinish;
		}

		public String getIsFinish()
		{
			return isFinish;
		}

		public void setNewestEpId(String newestEpId)
		{
			this.newestEpId = newestEpId;
		}

		public String getNewestEpId()
		{
			return newestEpId;
		}

		public void setNewestEpIndex(String newestEpIndex)
		{
			this.newestEpIndex = newestEpIndex;
		}

		public String getNewestEpIndex()
		{
			return newestEpIndex;
		}

		public void setSeasonId(String seasonId)
		{
			this.seasonId = seasonId;
		}

		public String getSeasonId()
		{
			return seasonId;
		}

		public void setTitle(String title)
		{
			this.title = title;
		}

		public String getTitle()
		{
			return title;
		}

		public void setTotalCount(String totalCount)
		{
			this.totalCount = totalCount;
		}

		public String getTotalCount()
		{
			return totalCount;
		}
	}
	
	public static class Tag implements Serializable
	{
		private String cover;
		private String index;
		private String orderType;
		@JSONField(name="style_id")
		private String styleId;
		@JSONField(name="tag_id")
		private String tagId;
		@JSONField(name="tag_name")
		private String tagName;
		private String type;


		public void setCover(String cover)
		{
			this.cover = cover;
		}

		public String getCover()
		{
			return cover;
		}

		public void setIndex(String index)
		{
			this.index = index;
		}

		public String getIndex()
		{
			return index;
		}

		public void setOrderType(String orderType)
		{
			this.orderType = orderType;
		}

		public String getOrderType()
		{
			return orderType;
		}

		public void setStyleId(String styleId)
		{
			this.styleId = styleId;
		}

		public String getStyleId()
		{
			return styleId;
		}

		public void setTagId(String tagId)
		{
			this.tagId = tagId;
		}

		public String getTagId()
		{
			return tagId;
		}

		public void setTagName(String tagName)
		{
			this.tagName = tagName;
		}

		public String getTagName()
		{
			return tagName;
		}

		public void setType(String type)
		{
			this.type = type;
		}

		public String getType()
		{
			return type;
		}
	}
	
	public static class UserSeason implements Serializable
	{
		private String attention;
		@JSONField(name="last_ep_id")
		private String lastEpId;
		@JSONField(name="last_ep_index")
		private String lastEpIndex;
		@JSONField(name="last_time")
		private String lastTime;


		public void setAttention(String attention)
		{
			this.attention = attention;
		}

		public String getAttention()
		{
			return attention;
		}

		public void setLastEpId(String lastEpId)
		{
			this.lastEpId = lastEpId;
		}

		public String getLastEpId()
		{
			return lastEpId;
		}

		public void setLastEpIndex(String lastEpIndex)
		{
			this.lastEpIndex = lastEpIndex;
		}

		public String getLastEpIndex()
		{
			return lastEpIndex;
		}

		public void setLastTime(String lastTime)
		{
			this.lastTime = lastTime;
		}

		public String getLastTime()
		{
			return lastTime;
		}
	}
}
