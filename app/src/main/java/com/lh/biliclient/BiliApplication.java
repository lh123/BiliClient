package com.lh.biliclient;

import android.app.*;
import com.facebook.drawee.backends.pipeline.*;
import com.lh.biliclient.utils.*;

public class BiliApplication extends Application
{

	@Override
	public void onCreate()
	{
		super.onCreate();
		Fresco.initialize(this);
		SharedPreferencesUtils.init(this);
		HttpUtils.init(this);
		SplashUtils.init(this);
	}
}
