package com.aserbao.aserbaoanimationsummart.aUtil;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Imitation by Abybxc on 16/9/20 00:47
 * weixin:aserbao
 * <p/>
 * 重写Viewpager解决点击tab去除滑动动画效果的问题
 */
public class NoScrollViewPager extends ViewPager
{

    public NoScrollViewPager(Context context)
    {

        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs)
    {

        super(context, attrs);
    }


    @Override
    public void scrollTo(int x, int y)
    {

        super.scrollTo(x, y);
    }


    @Override
    public void setCurrentItem(int item, boolean smoothScroll)
    {

        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item)
    {
        super.setCurrentItem(item, false);
    }


}
