package com.lh.biliclient.fragment;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.*;
import com.lh.biliclient.utils.*;
import android.graphics.*;
import com.lh.biliclient.bean.*;
import com.lh.biliclient.bilibili.*;
import android.view.ViewGroup.*;

public class SplashFragment extends Fragment
{
	private View view;
	private ImageView splashView;
	private long time;
	private Bitmap bit;
	private SplashObj splash;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_splash,container,false);
		initView();
		return view;
	}

	private void initView()
	{
		time=System.currentTimeMillis();
		splashView=(ImageView) view.findViewById(R.id.splash);
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					splash=BiliApi.getInstance().getSplashObj();
					bit=SplashUtils.getSplashBitMap(splash);
					splashView.post(new Runnable(){

							@Override
							public void run()
							{
								splashView.setImageBitmap(bit);
							}
						});
				}
			}).start();
	}
}
