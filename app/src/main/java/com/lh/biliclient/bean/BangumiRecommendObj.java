package com.lh.biliclient.bean;
import java.io.*;

public class BangumiRecommendObj implements Serializable
{
	private String title;
	private String remark;
	private String remark2;
	private String style;
	private String imagekey;
	private String imageurl;
	private int width;
	private int height;
	private String type;
	private String spname;
	private int spid;
	private String avid;
	private int endepcount;//完结集数
	
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark2(String remark2)
	{
		this.remark2 = remark2;
	}

	public String getRemark2()
	{
		return remark2;
	}

	public void setStyle(String style)
	{
		this.style = style;
	}

	public String getStyle()
	{
		return style;
	}

	public void setImagekey(String imagekey)
	{
		this.imagekey = imagekey;
	}

	public String getImagekey()
	{
		return imagekey;
	}

	public void setImageurl(String imageurl)
	{
		this.imageurl = imageurl;
	}

	public String getImageurl()
	{
		return imageurl;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getWidth()
	{
		return width;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getHeight()
	{
		return height;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return type;
	}

	public void setSpname(String spname)
	{
		this.spname = spname;
	}

	public String getSpname()
	{
		return spname;
	}

	public void setSpid(int spid)
	{
		this.spid = spid;
	}

	public int getSpid()
	{
		return spid;
	}
	
	public void setAvid(String avid)
	{
		this.avid = avid;
	}

	public String getAvid()
	{
		return avid;
	}
	
	public void setEndepcount(int endepcount)
	{
		this.endepcount = endepcount;
	}

	public int getEndepcount()
	{
		return endepcount;
	}
}
