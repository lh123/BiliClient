package com.lh.biliclient.utils;
import android.graphics.*;
import com.lh.biliclient.*;
import com.nostra13.universalimageloader.core.*;
import com.nostra13.universalimageloader.core.display.*;

public class ImageLoaderUtils
{
	public static DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new FadeInBitmapDisplayer(1000)).build();
}
