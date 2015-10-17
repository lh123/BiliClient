package com.lh.biliclient.bean;
import com.alibaba.fastjson.annotation.*;
import java.util.*;

public class IndexObj
{
	private int code;
	private String message;
	private String screen;
	private String ver;
	private List<ResultObj> result;

	public void setCode(int code)
	{
		this.code = code;
	}

	public int getCode()
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

	public void setScreen(String screen)
	{
		this.screen = screen;
	}

	public String getScreen()
	{
		return screen;
	}

	public void setVer(String ver)
	{
		this.ver = ver;
	}

	public String getVer()
	{
		return ver;
	}

	public void setResult(List<ResultObj> result)
	{
		this.result = result;
	}

	public List<ResultObj> getResult()
	{
		return result;
	}
	
	public static class ResultObj
	{
		private List<Body> body;
		private ResultObjHead head;
		private String type;


		public void setBody(List<Body> body)
		{
			this.body = body;
		}

		public List<Body> getBody()
		{
			return body;
		}

		public void setHead(ResultObjHead head)
		{
			this.head = head;
		}

		public ResultObjHead getHead()
		{
			return head;
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
	
	public static class Body
	{
		private String cover;
		private String danmaku;
		@JSONField(name="goto")
		private String goTo;
		private int height=-1;
		@JSONField(name="is_random")
		private String isRandom;
		@JSONField(name="last_ep")
		private String lastEp;
		private String param;
		private String play;
		@JSONField(name="small_cover")
		private String small_cover;
		private String style;
		private String title;
		private int width=-1;
		private String badge2;
		@JSONField(name="badge_bg")
		private String badgeBg;
		@JSONField(name="badge_color")
		private String badgeColor;
		private String online;
		private String up;
		@JSONField(name="up_face")
		private String upFace;
		private String desc1;
		private String desc2;


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

		public void setGoTo(String goTo)
		{
			this.goTo = goTo;
		}

		public String getGoTo()
		{
			return goTo;
		}

		public void setHeight(int height)
		{
			this.height = height;
		}

		public int getHeight()
		{
			return height;
		}

		public void setIsRandom(String isRandom)
		{
			this.isRandom = isRandom;
		}

		public String getIsRandom()
		{
			return isRandom;
		}

		public void setLastEp(String lastEp)
		{
			this.lastEp = lastEp;
		}

		public String getLastEp()
		{
			return lastEp;
		}

		public void setParam(String param)
		{
			this.param = param;
		}

		public String getParam()
		{
			return param;
		}

		public void setPlay(String play)
		{
			this.play = play;
		}

		public String getPlay()
		{
			return play;
		}

		public void setSmall_cover(String small_cover)
		{
			this.small_cover = small_cover;
		}

		public String getSmall_cover()
		{
			return small_cover;
		}

		public void setStyle(String style)
		{
			this.style = style;
		}

		public String getStyle()
		{
			return style;
		}

		public void setTitle(String title)
		{
			this.title = title;
		}

		public String getTitle()
		{
			return title;
		}

		public void setWidth(int width)
		{
			this.width = width;
		}

		public int getWidth()
		{
			return width;
		}

		public void setBadge2(String badge2)
		{
			this.badge2 = badge2;
		}

		public String getBadge2()
		{
			return badge2;
		}

		public void setBadgeBg(String badgeBg)
		{
			this.badgeBg = badgeBg;
		}

		public String getBadgeBg()
		{
			return badgeBg;
		}

		public void setBadgeColor(String badgeColor)
		{
			this.badgeColor = badgeColor;
		}

		public String getBadgeColor()
		{
			return badgeColor;
		}

		public void setOnline(String online)
		{
			this.online = online;
		}

		public String getOnline()
		{
			return online;
		}

		public void setUp(String up)
		{
			this.up = up;
		}

		public String getUp()
		{
			return up;
		}

		public void setUpFace(String upFace)
		{
			this.upFace = upFace;
		}

		public String getUpFace()
		{
			return upFace;
		}

		public void setDesc1(String desc1)
		{
			this.desc1 = desc1;
		}

		public String getDesc1()
		{
			return desc1;
		}

		public void setDesc2(String desc2)
		{
			this.desc2 = desc2;
		}

		public String getDesc2()
		{
			return desc2;
		}
	}
	
	public static class ResultObjHead
	{
		@JSONField(name="goto")
		private String goTo;
		private String param;
		private String style;
		private String title;


		public void setGoTo(String goTo)
		{
			this.goTo = goTo;
		}

		public String getGoTo()
		{
			return goTo;
		}

		public void setParam(String param)
		{
			this.param = param;
		}

		public String getParam()
		{
			return param;
		}

		public void setStyle(String style)
		{
			this.style = style;
		}

		public String getStyle()
		{
			return style;
		}

		public void setTitle(String title)
		{
			this.title = title;
		}

		public String getTitle()
		{
			return title;
		}
	}
}
