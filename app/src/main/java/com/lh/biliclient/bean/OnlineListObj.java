package com.lh.biliclient.bean;
import java.io.*;
import java.util.*;
import com.alibaba.fastjson.annotation.*;

public class OnlineListObj implements Serializable
{
	private int code;
	private List<InnerVideo> list;

	public void setCode(int code)
	{
		this.code = code;
	}

	public int getCode()
	{
		return code;
	}

	public void setList(List<InnerVideo> list)
	{
		this.list = list;
	}

	public List<InnerVideo> getList()
	{
		return list;
	}
	
	public static class InnerVideo implements Serializable
	{
		private String aid;
		private int typeid;
		private String title;
		private String pic;
		private String play;
		@JSONField(name="video_review")
		private String videoReview;
		private String author;
		private String copyright;
		private String typename;
		private String subtitle;
		private int review;
		private int favorites;
		private int mid;
		private String description;
		private String create;
		private int credit;
		private int coins;
		private String duration;
		private int online;


		public void setAid(String aid)
		{
			this.aid = aid;
		}

		public String getAid()
		{
			return aid;
		}

		public void setTypeid(int typeid)
		{
			this.typeid = typeid;
		}

		public int getTypeid()
		{
			return typeid;
		}

		public void setTitle(String title)
		{
			this.title = title;
		}

		public String getTitle()
		{
			return title;
		}

		public void setPic(String pic)
		{
			this.pic = pic;
		}

		public String getPic()
		{
			return pic;
		}

		public void setPlay(String play)
		{
			this.play = play;
		}

		public String getPlay()
		{
			return play;
		}

		public void setVideoReview(String videoReview)
		{
			this.videoReview = videoReview;
		}

		public String getVideoReview()
		{
			return videoReview;
		}

		public void setAuthor(String author)
		{
			this.author = author;
		}

		public String getAuthor()
		{
			return author;
		}

		public void setCopyright(String copyright)
		{
			this.copyright = copyright;
		}

		public String getCopyright()
		{
			return copyright;
		}

		public void setTypename(String typename)
		{
			this.typename = typename;
		}

		public String getTypename()
		{
			return typename;
		}

		public void setSubtitle(String subtitle)
		{
			this.subtitle = subtitle;
		}

		public String getSubtitle()
		{
			return subtitle;
		}

		public void setReview(int review)
		{
			this.review = review;
		}

		public int getReview()
		{
			return review;
		}

		public void setFavorites(int favorites)
		{
			this.favorites = favorites;
		}

		public int getFavorites()
		{
			return favorites;
		}

		public void setMid(int mid)
		{
			this.mid = mid;
		}

		public int getMid()
		{
			return mid;
		}

		public void setDescription(String description)
		{
			this.description = description;
		}

		public String getDescription()
		{
			return description;
		}

		public void setCreate(String create)
		{
			this.create = create;
		}

		public String getCreate()
		{
			return create;
		}

		public void setCredit(int credit)
		{
			this.credit = credit;
		}

		public int getCredit()
		{
			return credit;
		}

		public void setCoins(int coins)
		{
			this.coins = coins;
		}

		public int getCoins()
		{
			return coins;
		}

		public void setDuration(String duration)
		{
			this.duration = duration;
		}

		public String getDuration()
		{
			return duration;
		}

		public void setOnline(int online)
		{
			this.online = online;
		}

		public int getOnline()
		{
			return online;
		}
	}
}
