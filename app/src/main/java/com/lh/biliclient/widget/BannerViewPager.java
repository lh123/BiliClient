package com.lh.biliclient.widget;
import android.support.v4.view.*;
import android.view.*;
import android.widget.*;
import com.lh.biliclient.bilibili.*;
import com.lh.biliclient.*;
import android.support.v4.view.ViewPager.*;
import java.util.*;

public class BannerViewPager extends ViewPager
{
	private boolean touching=false;
	private ArrayList<View> dots;
	private int current=-1;
	private LoopRunnable loop;
	public BannerViewPager(android.content.Context context)
	{
		super(context);
		dots = new ArrayList<View>();
		setOnPageChangeListener();
		//startAutoLoop(2000);
	}

    public BannerViewPager(android.content.Context context, android.util.AttributeSet attrs)
	{
		super(context, attrs);
		dots = new ArrayList<View>();
		setOnPageChangeListener();
		//startAutoLoop(2000);
	}

	public void stopAutoLoop()
	{
		current = getCurrentItem();
		loop.autoloop = false;
		loop = null;
		if (getCurrentItem() == getAdapter().getCount() - 1)
			setCurrentItem(1, true);
		else if (getCurrentItem() == 0)
			setCurrentItem(getAdapter().getCount() - 2);
	}

	public void startAutoLoop(int time)
	{
		if (loop != null)
		{
			stopAutoLoop();
		}
		loop = new LoopRunnable();
		loop.autoloop=true;
		loop.time=time;
		loop.startLoop();
	}

	public void refreshDot(View root)
	{
		//System.out.println("refreshdot");
		setCurrentItem(1, false);
		LinearLayout dotLayout=(LinearLayout) root.findViewById(R.id.linear_dot);
		dotLayout.removeAllViews();
		dots.clear();
		int count=getAdapter().getCount();
		int dotSize=getContext().getResources().getDimensionPixelSize(R.dimen.banner_dot);
		int dotMargin=getContext().getResources().getDimensionPixelSize(R.dimen.banner_dot_margin);
		for (int i=0;i < count - 2;i++)
		{
			View dot=new View(root.getContext());
			dot.setBackgroundResource(R.drawable.banner_dot);
			dot.setEnabled(false);
			LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(dotSize, dotSize);
			lp.setMargins(dotMargin, 0, 0, 0);
			dot.setLayoutParams(lp);
			dots.add(dot);
			dotLayout.addView(dot);
		}
	}

	@Override
	public void setOnPageChangeListener()
	{
		OnPageChangeListener list = null;
		list = new OnPageChangeListener(){

			private boolean isZero = false;
			private boolean isLast=false;

			@Override
			public void onPageScrolled(int p1, float p2, int p3)
			{
			}

			@Override
			public void onPageSelected(int pPosition)
			{
				//System.out.println(pPosition);
				for (int i=0;i < dots.size();i++)
				{
					if (i == pPosition - 1)
						dots.get(i).setEnabled(true);
					else
						dots.get(i).setEnabled(false);
				}
				if (pPosition == 0)
				{
					isZero = true;
				}
				else if (pPosition == getAdapter().getCount() - 1)
				{
					isLast = true;
				}
			}

			@Override
			public void onPageScrollStateChanged(int p1)
			{
				if (p1 == SCROLL_STATE_IDLE)
				{
					if (isZero)
					{
						//System.out.println("isZero"+getAdapter().getCount());
						isZero = false;
						setCurrentItem(getAdapter().getCount() - 2, false);
					}
					else if (isLast)
					{
						//System.out.println("islast");
						isLast = false;
						setCurrentItem(1, false);
					}
				}
			}
		};
		super.setOnPageChangeListener(list);
	}


	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		touching = true;
		return super.onTouchEvent(event);
	}

	class LoopRunnable implements Runnable
	{
		boolean autoloop=true;
		int count=0;
		public int time=2000;
		@Override
		public void run()
		{
			//System.out.println("count=" + count);
			//System.out.println("current" + current);
			if (getAdapter() != null && getAdapter().getCount() >= 3)
			{
				if (autoloop == true)
				{
					if (touching == true)
					{
						count = 2;
						touching = false;
					}
					if (count == 0)
					{
						setCurrentItem(getCurrentItem() + 1, true);
					}
					else
					{
						count--;
					}
				}
				else
				{
					return;
				}
			}
			postDelayed(this, time);
		}
		public void startLoop()
		{
			postDelayed(this, time);
		}
	}
}
