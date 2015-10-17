package com.lh.biliclient.fragment.base;
import android.support.v4.app.*;
import com.lh.biliclient.widget.*;
import android.view.*;

public class BangumiDetailBaseFragment extends Fragment implements ScrollableHelper.ScrollableContainer
{
	protected String title;
	protected View scrollableView;

	public String getTitle()
	{
		return title;
	}

	@Override
	public View getScrollableView()
	{
		return scrollableView;
	}
}
