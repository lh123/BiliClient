package com.lh.biliclient.utils;

public class StringUtils
{
	public static String generateTime(String p0)
	{
		String week = null;
		switch(p0)
		{
			case "0":
				week="日";
				break;
			case "1":
				week="一";
				break;
			case "2":
				week="二";
				break;
			case "3":
				week="三";
				break;
			case "4":
				week="四";
				break;
			case "5":
				week="五";
				break;
			case "6":
				week="六";
				break;
		}
		return "连载中,每周"+week+"更新";
	}
	
	public static String formateNumber(String num)
	{
		int n=Integer.parseInt(num);
		String result;
		if(n>=10000)
		{
			result=String.format("%.1f万",n/10000.0);
		}
		else
		{
			result=num;
		}
		return result;
	}
	
	public static String formateIndex(String index)
	{
		if(index.indexOf(".")>0)
			return "第"+index+"话";
		int mIndex=0;
		try
		{
			mIndex = Integer.parseInt(index);
		}
		catch (NumberFormatException e)
		{
			return index;
		}
		return String.format("第%02d话", mIndex);
	}
}
