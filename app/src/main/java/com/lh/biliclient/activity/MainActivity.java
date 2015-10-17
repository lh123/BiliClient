package com.lh.biliclient.activity;

import android.os.*;
import android.support.v4.app.*;
import android.support.v7.app.*;
import android.view.*;
import com.facebook.drawee.backends.pipeline.*;
import com.lh.biliclient.fragment.*;
import com.lh.biliclient.presenter.*;

public class MainActivity extends AppCompatActivity
{
	private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		Fresco.initialize(this);
        setContentView(R.layout.main);
		initFragment();
    }

	private void initFragment()
	{
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		fm = getSupportFragmentManager();
		fm.beginTransaction().replace(R.id.mainFrameLayout, new SplashFragment()).commit();
		MainDataPresenter.getInstance().getMainBangumiData();
		MainDataPresenter.getInstance().getIndexData();
		new Handler().postDelayed(new Runnable(){

				@Override
				public void run()
				{
					//refreshThread.stop();
					fm.beginTransaction().replace(R.id.mainFrameLayout, new MainFragment()).commitAllowingStateLoss();
					//MainDataPresenter.getInstance().delMainBangumiDataObserver(MainActivity.this);
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
