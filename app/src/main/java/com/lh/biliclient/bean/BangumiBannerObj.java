package com.lh.biliclient.bean;

import java.util.*;

public class BangumiBannerObj
{
	private int code;
	private Result result;

	public void setCode(int code)
	{
		this.code = code;
	}

	public int getCode()
	{
		return code;
	}

	public void setResult(Result result)
	{
		this.result = result;
	}

	public Result getResult()
	{
		return result;
	}
	
	public static class Result
	{
		private List<Banner> banners;


		public void setBanners(List<Banner> banners)
		{
			this.banners = banners;
		}

		public List<Banner> getBanners()
		{
			return banners;
		}
	
		}
	
	public static class Banner
	{
		private String title;
		private String link;
		private String img;
		private String simg;
		private int aid;
		private String type;
		private int platform;
		private int pid;


		public void setTitle(String title)
		{
			this.title = title;
		}

		public String getTitle()
		{
			return title;
		}

		public void setLink(String link)
		{
			this.link = link;
		}

		public String getLink()
		{
			return link;
		}

		public void setImg(String img)
		{
			this.img = img;
		}

		public String getImg()
		{
			return img;
		}

		public void setSimg(String simg)
		{
			this.simg = simg;
		}

		public String getSimg()
		{
			return simg;
		}

		public void setAid(int aid)
		{
			this.aid = aid;
		}

		public int getAid()
		{
			return aid;
		}

		public void setType(String type)
		{
			this.type = type;
		}

		public String getType()
		{
			return type;
		}

		public void setPlatform(int platform)
		{
			this.platform = platform;
		}

		public int getPlatform()
		{
			return platform;
		}

		public void setPid(int pid)
		{
			this.pid = pid;
		}

		public int getPid()
		{
			return pid;
		}}
}
