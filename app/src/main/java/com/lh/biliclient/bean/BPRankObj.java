package com.lh.biliclient.bean;

public class BPRankObj
{
	private String uid;
	private String hidden;
	private String message;
	private String uname;
	private String face;
	private String rank;
	private int users;

	public void setUsers(int users)
	{
		this.users = users;
	}

	public int getUsers()
	{
		return users;
	}
	public void setRank(String rank)
	{
		this.rank = rank;
	}

	public String getRank()
	{
		return rank;
	}
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
