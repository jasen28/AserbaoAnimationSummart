package com.aserbao.aserbaoanimationsummart.aserbaoUtil.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;

import java.util.Random;

public class CustomProgressBar extends View
{

	private int mFirstColor;

	private int mSecondColor;

	private int mCircleWidth;

	private Paint mPaint;

	private int mProgress;

	private int mSpeed;

	private int[] mInts = {Color.RED,Color.GRAY,Color.BLACK,Color.YELLOW,Color.BLUE,Color.WHITE,Color.CYAN,Color.GREEN};
	private boolean isNext = false;

	public CustomProgressBar(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public CustomProgressBar(Context context)
	{
		this(context, null);
	}


	public CustomProgressBar(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyle, 0);
		int n = a.getIndexCount();

		for (int i = 0; i < n; i++)
		{
			int attr = a.getIndex(i);
			switch (attr)
			{
			case R.styleable.CustomProgressBar_firstColor:
				mFirstColor = a.getColor(attr, Color.GREEN);
				break;
			case R.styleable.CustomProgressBar_secondColor:
				mSecondColor = a.getColor(attr, Color.RED);
				break;
			case R.styleable.CustomProgressBar_circleWidth:
				mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
				break;
			case R.styleable.CustomProgressBar_speed:
				mSpeed = a.getInt(attr, 20);
				break;
			}
		}
		a.recycle();
		mPaint = new Paint();
		
		new Thread()
		{
			public void run()
			{
				while (true)
				{
					mProgress++;
					if (mProgress == 360)
					{
						mProgress = 0;
						if (!isNext)
							isNext = true;
						else
							isNext = false;
					}
					postInvalidate();
					try
					{
						Thread.sleep(mSpeed);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			};
		}.start();

	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		Random random = new Random();
		int i = random.nextInt(mInts.length);
		int centre = getWidth() / 2;
		int radius = centre - mCircleWidth / 2;
		mPaint.setStrokeWidth(mCircleWidth);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.STROKE);
		RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius);
		Path path = new Path();
		path.moveTo(0,0);
		if (!isNext)
		{
			mPaint.setColor(mInts[i]);
			canvas.drawArc(oval, -90, mProgress, false, mPaint);
			path.lineTo(mProgress,0);
			canvas.drawPath(path,mPaint);
		} else
		{

			mPaint.setColor(mFirstColor);
			canvas.drawArc(oval, -90, mProgress, false, mPaint);

			path.lineTo(mProgress,0);
			canvas.drawPath(path,mPaint);
		}

	}

}
