package com.lh.biliclient;

import android.os.*;
import android.support.v4.app.*;
import android.support.v7.app.*;
import android.view.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.fragment.*;
import com.lh.biliclient.utils.*;
import com.nostra13.universalimageloader.core.*;

public class MainActivity extends AppCompatActivity
{
	private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
		SharedPreferencesUtils.init(this);
		HttpUtils.init(this);
		SplashUtils.init(this);
		initFragment();
    }

	private void initFragment()
	{
		final Thread refreshThread=new Thread(new Runnable(){

				@Override
				public void run()
				{
					BiliData.onlineList=BiliApi.getInstance().getOnlineList();
					BiliData.bangumiBannerList=BiliApi.getInstance().getBangumiBannerList();
					BiliData.recommendList=BiliApi.getInstance().getRecommendList();
					BiliData.indexData=BiliApi.getInstance().getIndexData();
					BiliData.indexBannerList=BiliApi.getInstance().getIndexBannerObj();
					if(BangumiFragment.handler!=null)
					{
						BangumiFragment.handler.sendEmptyMessage(BangumiFragment.REFRESH_SUCCESS);
					}
				}
			});
		refreshThread.start();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		fm = getSupportFragmentManager();
		fm.beginTransaction().replace(R.id.mainFrameLayout, new SplashFragment()).commit();
		new Handler().postDelayed(new Runnable(){

				@Override
				public void run()
				{
					//refreshThread.stop();
					fm.beginTransaction().replace(R.id.mainFrameLayout, new MainFragment()).commitAllowingStateLoss();
				}
			}, 3000);
	}



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
		{
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
