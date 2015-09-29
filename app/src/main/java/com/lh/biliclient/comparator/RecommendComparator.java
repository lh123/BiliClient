package com.lh.biliclient.comparator;
import java.util.*;
import com.lh.biliclient.bean.*;

public class RecommendComparator implements Comparator<BangumiRecommendObj>
{
	@Override
	public int compare(BangumiRecommendObj p1, BangumiRecommendObj p2)
	{
		if(p1.getEndepcount()==-1)
		{
			return 1;
		}
		return 0;
	}
}
