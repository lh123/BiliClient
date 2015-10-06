package com.lh.biliclient.utils;
import android.content.*;
import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class HttpUtils
{
	public static final String RECOMMEND="recommend.json";
	public static final String BANGUMI_BANNER="bangumi_banner.json";
	private static Context mContext;
	public static void init(Context context)
	{
		mContext = context;
	}
	public static String getHttpCommonContent(String path)
	{
		try
		{
			URL url=new URL(path);
			HttpURLConnection connect=(HttpURLConnection) url.openConnection();
			connect.setConnectTimeout(3000);
			connect.setRequestProperty("User-Agent", "Mozilla/5.0 BiliDroid/4.5.1 (bbcallen@gmail.com)");
			InputStream is=connect.getInputStream();
			int len=-1;
			StringBuilder sb=new StringBuilder();
			byte[] by=new byte[1024];
			while ((len = is.read(by)) != -1)
			{
				sb.append(new String(by, 0, len));
			}
			is.close();
			return sb.toString();
		}
		catch (MalformedURLException e)
		{}
		catch (IOException e)
		{}
		return null;
	}
	
	public static String getHttpsCommonContent(String path)
	{
		try
		{
			URL url=new URL(path);
			HttpsURLConnection connect=(HttpsURLConnection) url.openConnection();
			connect.setConnectTimeout(3000);
			connect.setRequestProperty("User-Agent", "Mozilla/5.0 BiliDroid/4.5.1 (bbcallen@gmail.com)");
			InputStream is=connect.getInputStream();
			int len=-1;
			StringBuilder sb=new StringBuilder();
			byte[] by=new byte[1024];
			while ((len = is.read(by)) != -1)
			{
				sb.append(new String(by, 0, len));
			}
			is.close();
			return sb.toString();
		}
		catch (MalformedURLException e)
		{}
		catch (IOException e)
		{}
		return null;
	}
	
	public static String getHttpContentWithCache(String urlPath, String filePath, String name, boolean match)
	{
		try
		{
			InputStream is=getInputStreamWithCache(urlPath, filePath, name,match);
			if (is == null)
				return null;
			int len=-1;
			StringBuilder sb=new StringBuilder();
			byte[] temp=new byte[1024];
			while ((len = is.read(temp)) != -1)
			{
				sb.append(new String(temp, 0, len));
			}
			return sb.toString();
		}
		catch (IOException e)
		{}
		return null;
	}

	public static InputStream getInputStreamWithCache(String urlPath, String filePath, String name, boolean match)
	{
		SharedPreferences sp=SharedPreferencesUtils.getSharePreferences("cache");
		InputStream is = null;
		try
		{
			File dir=new File(mContext.getExternalFilesDir(null) + "/" + filePath);
			if (!dir.exists())
				dir.mkdirs();
			File file=new File(dir, name);
			if (!file.canRead())
			{
				sp.edit().putLong(name, 0).commit();
				file.createNewFile();
			}
			is = new FileInputStream(file);
			long last=sp.getLong(name, 0);
			URL url=new URL(urlPath);
			HttpURLConnection connect=(HttpURLConnection) url.openConnection();
			connect.setConnectTimeout(3000);
			connect.setRequestProperty("User-Agent", "Mozilla/5.0 BiliDroid/4.5.1 (bbcallen@gmail.com)");
			connect.setIfModifiedSince(last);
			if (match)
			{
				int length=is.available();
				connect.addRequestProperty("If-None-Match", "\"" + Long.toHexString(last / 1000) + "-" + Integer.toHexString(length) + "\"");
			}
			connect.connect();
			if (connect.getResponseCode() == 200)
			{
				InputStream httpIs=connect.getInputStream();
				OutputStream os=new FileOutputStream(file);
				int len=-1;
				byte[] by=new byte[1024];
				while ((len = httpIs.read(by)) != -1)
				{
					os.write(by, 0, len);
				}
				os.close();
				httpIs.close();
				sp.edit().putLong(name, connect.getLastModified()).commit();
			}
		}
		catch (MalformedURLException e)
		{}
		catch (FileNotFoundException e)
		{}
		catch (IOException e)
		{
			return is;
		}
		return is;
	}

	public static InputStream getInputStream(String path)
	{
		try
		{
			URL url=new URL(path);
			HttpURLConnection connect=(HttpURLConnection) url.openConnection();
			connect.setConnectTimeout(3000);
			connect.setRequestProperty("User-Agent", "Mozilla/5.0 BiliDroid/4.5.1 (bbcallen@gmail.com)");
			connect.connect();
			return connect.getInputStream();
		}
		catch (IOException e)
		{}
		return null;
	}
}
