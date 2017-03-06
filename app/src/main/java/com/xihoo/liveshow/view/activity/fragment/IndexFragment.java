package com.xihoo.liveshow.view.activity.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.xihoo.liveshow.R;
import com.xihoo.liveshow.comm.adapter.MainFragmentPagerAdapter;
import com.xihoo.liveshow.view.activity.fragment.index.NewestFragment;
import com.xihoo.liveshow.view.activity.fragment.index.RecommedFragment;
import com.xihoo.liveshow.view.activity.fragment.index.RemindFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class IndexFragment extends BaseFragment {

    @BindView(R.id.nts)
    NavigationTabStrip navigationTabStrip;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private RemindFragment remindFragment;
    private RecommedFragment recommedFragment;
    private NewestFragment newestFragment;
    private ArrayList<BaseFragment> mFragments = new ArrayList<BaseFragment>();
    private MainFragmentPagerAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
        initData();
        setAdapter();
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
        viewPager.setCurrentItem(1);
    }

    private void initData() {
        mFragments.clear();
        remindFragment = new RemindFragment();
        recommedFragment = new RecommedFragment();
        newestFragment = new NewestFragment();

        mFragments.add(remindFragment);
        mFragments.add(recommedFragment);
        mFragments.add(newestFragment);

    }

    private void initUI() {
        navigationTabStrip.setTitles("关注", "推荐", "最新");
        navigationTabStrip.setTabIndex(1, true);
        navigationTabStrip.setTitleSize(35);
        navigationTabStrip.setStripColor(getResources().getColor(R.color.common_purple));
        navigationTabStrip.setStripWeight(15);
        navigationTabStrip.setStripFactor(8);
        navigationTabStrip.setStripType(NavigationTabStrip.StripType.POINT);
        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
        navigationTabStrip.setTypeface("fonts/typeface.ttf");
        navigationTabStrip.setCornersRadius(8);
        navigationTabStrip.setAnimationDuration(300);
        navigationTabStrip.setInactiveColor(Color.GRAY);
        navigationTabStrip.setActiveColor(getResources().getColor(R.color.common_purple));

        navigationTabStrip.setOnPageChangeListener(new MyOnPageChangeListener());

    }

    private void setAdapter() {
        mAdapter = new MainFragmentPagerAdapter(getActivity().getSupportFragmentManager(),
                mFragments);
        viewPager.removeAllViewsInLayout();
        viewPager.setAdapter(mAdapter);

        navigationTabStrip.setViewPager(viewPager,1);

    }

    /**
     * 页卡切换监听
     */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            setNavigationTab(arg0);
            switch (arg0) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }

    private void setNavigationTab(int index){
        navigationTabStrip.setTabIndex(index,true);
    }
}
