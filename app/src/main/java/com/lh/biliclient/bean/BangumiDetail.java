package com.lh.biliclient.bean;
import java.util.*;

public class BangumiDetail
{
	private String alias;
	private String allowBp;
	private String allowDownload;
	private String area;
	private String bangumiId;
	private String bangumiTitle;
	private String brief;
	private String coins;
	private String cover;
	private String danmakuCount;
	private ArrayList<Actor> actorList;
	private ArrayList<Episodes> episodesList;
	private String evaluate;
	private String isFinish;
	private String newestEpId;
	private String newestEpIndex;
	private String playCount;
	private String pubTime;
	private String seasonId;
	private String seasonTitle;
	private String shareUrl;
	private String staff;
	private String weekday;
	private String title;

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setWeekday(String weekday)
	{
		this.weekday = weekday;
	}

	public String getWeekday()
	{
		return weekday;
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

	public void setActor(ArrayList<Actor> actorList)
	{
		this.actorList = actorList;
	}

	public ArrayList<Actor> getActor()
	{
		return actorList;
	}

	public void setEpisodesList(ArrayList<Episodes> episodesList)
	{
		this.episodesList = episodesList;
	}

	public ArrayList<Episodes> getEpisodesList()
	{
		return episodesList;
	}

	public void setEvaluate(String evaluate)
	{
		this.evaluate = evaluate;
	}

	public String getEvaluate()
	{
		return evaluate;
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

	public void setStaff(String staff)
	{
		this.staff = staff;
	}

	public String getStaff()
	{
		return staff;
	}
	
	public class Actor
	{
		private String actor;
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
	
	public class Episodes
	{
		private String avId;
		private String coins;
		private String cover;
		private String danmaku;
		private String episodeId;
		private String index;
		private String indexTitle;
		private String isWebPlay;
		private String page;
		private String up;
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

		public void setUp(String up)
		{
			this.up = up;
		}

		public String getUp()
		{
			return up;
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
	public Actor generateActor()
	{
		return new Actor();
	}
	public Episodes generateEpisodes()
	{
		return new Episodes();
	}
}
