package com.lh.biliclient.utils;
import java.security.*;

public class BiliUtils
{
	public static final String APPKEY="27eb53fc9058f8c3";
	public static final String SECRETKEY="c2ed53a74eeefe3cf99fbd01d8c9c375";
	public static final String ACCESS_KEY="6d7912b084e9a92d24553f2cea9dcedc";
	private static final String ONLINE_LIST="http://api.bilibili.com/online_list";
	private static final String MODULE="http://app.bilibili.com/bangumi/operation_module";
	private static final String BANGUMIBANNER="http://app.bilibili.com/api/region2/13.json";
	private static final String BANGUMI="http://app.bilibili.com/bangumi/season";
	private static final String BP="https://api.bilibili.com/bp/info";
	
	public static String getOnlineListApi()
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&appkey=c1b107428d337928&build=405001&platform=android&typeid=13
		String params="_device=android"+"&access_key="+ACCESS_KEY+"&appkey="+APPKEY+"&platform=andrlid&typeid=13";
		return ONLINE_LIST+"?"+params+getSign(params);
	}
	
	public static String getBangumiRecommenfListApi()
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&appkey=c1b107428d337928&build=405001&channel=xiaomi&module=bangumi&platform=android&screen=xhdpi&test=0&ts=1442879779000&sign=960b348cf92bb0765de7f95868baa4ca
		String params="_device=android"+"&access_key="+ACCESS_KEY+"&appkey="+APPKEY+"&module=bangumi"+"&platform=android"+"&screen=xhdpi&"+"&test=0"+"&ts="+System.currentTimeMillis();
		return MODULE+"?"+params+getSign(params);
	}
	
	public static String getSplashApi()
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&appkey=c1b107428d337928&build=405001&channel=xiaomi&module=bangumi&platform=android&screen=xhdpi&test=0&ts=1442879779000&sign=960b348cf92bb0765de7f95868baa4ca
		String params="_device=android"+"&appkey="+APPKEY+"&module=splash"+"&platform=android"+"&screen=xhdpi&"+"&test=0"+"&ts="+System.currentTimeMillis();
		return MODULE+"?"+params+getSign(params);
	}
	
	public static String getIndexBannerApi()
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&appkey=c1b107428d337928&build=405001&channel=xiaomi&module=bangumi&platform=android&screen=xhdpi&test=0&ts=1442879779000&sign=960b348cf92bb0765de7f95868baa4ca
		String params="_device=android"+"&appkey="+APPKEY+"&module=banner"+"&platform=android"+"&screen=xhdpi&"+"&test=0"+"&ts="+System.currentTimeMillis();
		return MODULE+"?"+params+getSign(params);
	}
	public static String getBannerListApi()
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&appkey=c1b107428d337928&build=405001&channel=xiaomi&module=bangumi&platform=android&screen=xhdpi&test=0&ts=1442879779000&sign=960b348cf92bb0765de7f95868baa4ca
		String params="_device=android"+"&appkey="+APPKEY+"&module=bangumi"+"&platform=android"+"&ts="+System.currentTimeMillis();
		return BANGUMIBANNER+"?"+params+getSign(params);
	}
	public static String getIndexApi()
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&appkey=c1b107428d337928&build=405001&channel=xiaomi&module=bangumi&platform=android&screen=xhdpi&test=0&ts=1442879779000&sign=960b348cf92bb0765de7f95868baa4ca
		String params="_device=android"+"&appkey="+APPKEY+"&module=index"+"&platform=android"+"&screen=xhdpi&"+"&test=0"+"&ts="+System.currentTimeMillis();
		return MODULE+"?"+params+getSign(params);
	}
	
	public static String getBangumiDetailBySpidApi(int spid)
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&appkey=c1b107428d337928&build=405001&platform=android&sp_id=43628&ts=1443437898000&type=sp&sign=fa8dc879fd95ddc0880a16f0243dcef9
		String params="_device=android"+"&_ulv=10000&access_key="+ACCESS_KEY+"&appkey="+APPKEY+"&build=405001&platform=android"+"&sp_id="+spid+"&ts="+System.currentTimeMillis()+"&type=sp";
		return BANGUMI+"?"+params+getSign(params);
	}
	
	public static String getBangumiDetailBySeasonidApi(String seasonId)
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&appkey=c1b107428d337928&build=405001&platform=android&season_id=1509&ts=1444281789000&type=bangumi&sign=ddc62cf238c57eb71074a6a0de758276 
		String params="_device=android"+"&_ulv=10000&access_key="+ACCESS_KEY+"&appkey="+APPKEY+"&build=405001&platform=android"+"&season_id="+seasonId+"&ts="+System.currentTimeMillis()+"&type=bangumi";
		return BANGUMI+"?"+params+getSign(params);
	}
	
	public static String getBpList(String aid)
	{
		//_device=android&_hwid=0a5cec7cde29d8d0&_ulv=10000&access_key=6d7912b084e9a92d24553f2cea9dcedc&aid=2862151&appkey=c1b107428d337928&build=405001&platform=android
		String params="_device=android&_ulv=10000&access_key="+ACCESS_KEY+"&aid="+aid+"&appkey="+APPKEY+"&build=405001&platform=android";
		return BP+"?"+params+getSign(params);
	}
	public static String getSign(String params)
	{
		try
		{
			params+=SECRETKEY;
			MessageDigest md=MessageDigest.getInstance("md5");
			StringBuffer sb=new StringBuffer();
			byte[] temp=md.digest(params.getBytes());
			for(int i=0;i<temp.length;i++)
			{
				String s=Integer.toHexString(temp[i]&0xff);
				if(s.length()<2)
					sb.append(0);
				sb.append(s);
			}
			return "&sign="+sb.toString();
		}
		catch (NoSuchAlgorithmException e)
		{}
		return null;
	}
}
