package com.lh.biliclient.utils;
import android.content.*;
import android.graphics.*;
import java.io.*;
import java.net.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.*;

public class SplashUtils
{
	private static Context mContext;
	public static void init(Context context)
	{
		mContext=context;
	}
	public static Bitmap getSplashBitMap(SplashObj splash)
	{
		Bitmap bitMap=null;
		try
		{
			if(splash==null)
			{
				InputStream open = mContext.getAssets().open("splash/ic_splash_default.png");
				bitMap = BitmapFactory.decodeStream(open);
				open.close();
				return bitMap;
			}
			String[] tempF=splash.getImage().split("/");
			String name=tempF[tempF.length - 1];
			File dir=new File(mContext.getExternalFilesDir(null) + "/splash/" + splash.getVer());
			if (!dir.exists())
				dir.mkdirs();
			File file=new File(dir,name);
			if (!file.exists())
			{
				InputStream is=HttpUtils.getInputStream(splash.getImage());
				FileOutputStream fos=new FileOutputStream(file);
				int len=-1;
				byte[] temp=new byte[1024];
				while((len=is.read(temp))!=-1)
				{
					fos.write(temp,0,len);
				}
				is.close();
				fos.close();
			}
			long time=System.currentTimeMillis()/1000;
			if (time > splash.getStart() && time < splash.getEnd())
			{
				FileInputStream fis=new FileInputStream(file);
				bitMap=BitmapFactory.decodeStream(fis);
			}
			else
			{
				bitMap=BitmapFactory.decodeStream(mContext.getAssets().open("splash/ic_splash_default.png"));
			}
		}
		catch (FileNotFoundException e)
		{}
		catch (IOException e)
		{}
		return bitMap;
	}
}
