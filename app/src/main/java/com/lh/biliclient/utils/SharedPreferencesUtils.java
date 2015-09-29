package com.lh.biliclient.utils;
import android.content.*;

public class SharedPreferencesUtils
{
	private static Context mContext;
	public static void init(Context context)
	{
		mContext=context;
	}
	public static SharedPreferences getSharePreferences(String name)
	{
		SharedPreferences sharedPreferences=mContext.getSharedPreferences(name, mContext.MODE_PRIVATE);
		return sharedPreferences;
	}
}
