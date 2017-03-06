package com.xihoo.liveshow.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.xihoo.liveshow.R;
import com.xihoo.liveshow.view.activity.fragment.IndexFragment;
import com.xihoo.liveshow.view.activity.fragment.UserFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.index_image)
    ImageView indexImage;
    @BindView(R.id.index_text)
    TextView indexText;
    @BindView(R.id.index_layout)
    RelativeLayout indexLayout;
    @BindView(R.id.live_image)
    ImageView liveImage;
    @BindView(R.id.live_text)
    TextView liveText;
    @BindView(R.id.live_layout)
    RelativeLayout liveLayout;
    @BindView(R.id.me_image)
    ImageView meImage;
    @BindView(R.id.me_text)
    TextView meText;
    @BindView(R.id.me_layout)
    RelativeLayout meLayout;
    @BindView(R.id.main_layout)
    LinearLayout mainLayout;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    private IndexFragment indexFragment;
    private UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        fragmentManager = getSupportFragmentManager();


        if (savedInstanceState != null) {
            indexFragment = (IndexFragment) fragmentManager.findFragmentByTag("tab_index");
            userFragment = (UserFragment) fragmentManager.findFragmentByTag("tab_user");
            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            transaction.remove(diagnoseFragment);
            transaction.commit();
//            diagnoseFragment = null;
        }
        // 第一次启动时选中第0个tab
        setTabSelection(0);

    }


    public void setTabSelection ( int index){
        try {
            // 每次选中之前先清楚掉上次的选中状态
            clearSelection();
            // 开启一个Fragment事务
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
            hideFragments(transaction);
            setTranslucent();
            switch (index) {
                case 0:
                    // 当点击了首页tab时，改变控件的图片和文字颜色
//                        indexImage.setImageResource(R.drawable.tab_index_hover);
//                        indexText.setTextColor(getResources().getColor(R.color.common_green));
                    if (indexFragment == null) {
                        // 如果indexFragment为空，则创建一个并添加到界面上
                        indexFragment = new IndexFragment();
                        transaction.add(R.id.content, indexFragment, "tab_index");
                    } else {
                        // 如果indexFragment不为空，则直接将它显示出来
                        transaction.show(indexFragment);
                    }
                    break;

                case 1:
                    // 当点击了发现tab时，改变控件的图片和文字颜色
//                        findImage.setImageResource(R.drawable.tab_find_hover);
//                        findText.setTextColor(getResources().getColor(R.color.common_green));
                    if (userFragment == null) {
                        // 如果findFragment为空，则创建一个并添加到界面上
                        userFragment = new UserFragment();
                        transaction.add(R.id.content, userFragment, "tab_find");
                    } else {
                        // 如果findFragment不为空，则直接将它显示出来
                        transaction.show(userFragment);
                    }
                    break;
                   /* case 3:

                        // 当点击了我tab时，改变控件的图片和文字颜色
//                        meImage.setImageResource(R.drawable.tab_me_hover);
//                        meText.setTextColor(getResources().getColor(R.color.common_green));
                        if (userNewFragment == null) {
                            // 如果userFragment为空，则创建一个并添加到界面上
                            userNewFragment = new UserNewFragment();
                            transaction.add(R.id.content, userNewFragment, "tab_user");
                        } else {
                            // 如果userFragment不为空，则直接将它显示出来
                            transaction.show(userNewFragment);
                        }

                        break;*/
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (indexFragment != null) {
            transaction.hide(indexFragment);
        }

       /* if (userFragment != null){
            transaction.hide(userFragment);
        }*/
        if (userFragment != null) {
            transaction.hide(userFragment);
        }
    }


    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
//        indexImage.setImageResource(R.drawable.tab_index_norm);
//        indexText.setTextColor(getResources().getColor(R.color.common_darker_gray));
//
//        msgImage.setImageResource(R.drawable.tab_remind_norm);
//        msgText.setTextColor(getResources().getColor(R.color.common_darker_gray));
//
////        diagnoseImage.setImageResource(R.drawable.tab_diagnose_norm);
////        diagnoseText.setTextColor(getResources().getColor(R.color.common_darker_gray));
//
//        findImage.setImageResource(R.drawable.tab_find_norm);
//        findText.setTextColor(getResources().getColor(R.color.common_darker_gray));
//
//        meImage.setImageResource(R.drawable.tab_me_norm);
//        meText.setTextColor(getResources().getColor(R.color.common_darker_gray));
    }


    @OnClick({R.id.index_layout, R.id.live_layout, R.id.me_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.index_layout:
                setTabSelection(0);
                break;
            case R.id.live_layout://调到直播界面

                break;
            case R.id.me_layout:
                setTabSelection(1);
                break;
        }
    }

    private void setTranslucent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar 状态栏
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // Translucent navigation bar 虚拟键盘栏
           /* window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
    	    	WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);*/
        }
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//        mainLayout.setFitsSystemWindows(false);
//        mainLayout.setClipToPadding(false);
    }
}
