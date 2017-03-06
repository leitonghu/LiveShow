/**
 * @项目名称:友德医网络医院(Android个人端)
 * @(#)MainFragmentPagerAdapter.java Created on 2015-8-1
 * Copyright © 2015 深圳友德医科技有限公司  版权所有
 */
package com.xihoo.liveshow.comm.adapter;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;


import com.xihoo.liveshow.view.activity.fragment.BaseFragment;

import java.util.ArrayList;



/*
 * viewpager在加载当前页的时候已经将pager页左右页的内容加载进内存里了，这样才保证了viewpager左右滑动的时候的流畅性；
 * 为了解决彻底删除fragment，
 * 我们要做的是： 1.将FragmentPagerAdapter
 * 替换成FragmentStatePagerAdapter，因为前者只要加载过，
 * fragment中的视图就一直在内存中，在这个过程中无论你怎么刷新，清除都是无用的，直至程序退出； 后者 可以满足我们的需求。
 * 2.我们可以重写Adapter的方法--getItemPosition()，让其返回PagerAdapter.POSITION_NONE即可；
 */

/**
 * The class <code>Class MainFragmentPagerAdapter</code>.
 *
 * @author Tonghu Lei FragmentPagerAdapter
 * @version 1.0 FragmentStatePagerAdapter
 */
public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<BaseFragment> list;
    private View mCurrentView;
    public MainFragmentPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public BaseFragment getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @SuppressWarnings("deprecation")
    @Override
    public Object instantiateItem(View container, int position) {
        // TODO Auto-generated method stub
        return super.instantiateItem(container, position);
    }

/*    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mCurrentView = (View)object;
    }

    public View getPrimaryItem() {
        return mCurrentView;
    }*/

}
