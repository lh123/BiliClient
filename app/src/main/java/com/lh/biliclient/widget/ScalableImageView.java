package com.lh.biliclient.widget;
import android.content.*;
import android.content.res.*;
import android.util.*;
import com.facebook.drawee.view.*;
import com.lh.biliclient.*;

public class ScalableImageView extends SimpleDraweeView
{
	public ScalableImageView(android.content.Context context, com.facebook.drawee.generic.GenericDraweeHierarchy hierarchy) {
		super(context,hierarchy);
	}

    public ScalableImageView(Context context) {
		super(context);
	}

    public ScalableImageView(Context context, AttributeSet attrs) {
		super(context,attrs);
		initRadio(context,attrs);
	}

    public ScalableImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context,attrs,defStyle);
		initRadio(context,attrs);
	}
	
	private void initRadio(Context context,AttributeSet attrs)
	{
		TypedArray type=context.obtainStyledAttributes(attrs,R.styleable.ScalableImageView);
		int width=type.getInteger(R.styleable.ScalableImageView_aspectRadioWidth,0);
		int height=type.getInteger(R.styleable.ScalableImageView_aspectRadioHeight,0);
		if(width>0&&height>0)
			setAspectRatio((float)width/height);
	}
}
