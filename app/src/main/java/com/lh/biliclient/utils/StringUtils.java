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
	
	public static String generateStringNum(String num)
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
}
