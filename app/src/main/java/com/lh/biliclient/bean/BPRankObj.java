package com.lh.biliclient.bean;

import com.alibaba.fastjson.annotation.*;
import java.util.*;

public class BPRankObj
{
	private int code;
	private Data data;

	public void setCode(int code)
	{
		this.code = code;
	}

	public int getCode()
	{
		return code;
	}

	public void setData(Data data)
	{
		this.data = data;
	}

	public Data getData()
	{
		return data;
	}
	
	public static class Data
	{
		private int bp;
		private int percent;
		@JSONField(name="ep_bp")
		private int epBp;
		@JSONField(name="ep_percent")
		private int epPercent;
		private int users;
		private boolean mine;
		private List<ListObj> list;

		public void setBp(int bp)
		{
			this.bp = bp;
		}

		public int getBp()
		{
			return bp;
		}

		public void setPercent(int percent)
		{
			this.percent = percent;
		}

		public int getPercent()
		{
			return percent;
		}

		public void setEpBp(int epBp)
		{
			this.epBp = epBp;
		}

		public int getEpBp()
		{
			return epBp;
		}
		
		public void setEpPercent(int epPercent)
		{
			this.epPercent = epPercent;
		}

		public int getEpPercent()
		{
			return epPercent;
		}

		public void setUsers(int users)
		{
			this.users = users;
		}

		public int getUsers()
		{
			return users;
		}

		public void setMine(boolean mine)
		{
			this.mine = mine;
		}

		public boolean isMine()
		{
			return mine;
		}
		
		public void setList(List<ListObj> list)
		{
			this.list = list;
		}

		public List<ListObj> getList()
		{
			return list;
		}
	}
	
	public static class ListObj
	{
		private String uid;
		private String hidden;
		private String rank;
		private String message;
		private String uname;
		private String face;


		public void setUid(String uid)
		{
			this.uid = uid;
		}

		public String getUid()
		{
			return uid;
		}

		public void setHidden(String hidden)
		{
			this.hidden = hidden;
		}

		public String getHidden()
		{
			return hidden;
		}

		public void setRank(String rank)
		{
			this.rank = rank;
		}

		public String getRank()
		{
			return rank;
		}

		public void setMessage(String message)
		{
			this.message = message;
		}

		public String getMessage()
		{
			return message;
		}

		public void setUname(String uname)
		{
			this.uname = uname;
		}

		public String getUname()
		{
			return uname;
		}

		public void setFace(String face)
		{
			this.face = face;
		}

		public String getFace()
		{
			return face;
		}
	}
}
