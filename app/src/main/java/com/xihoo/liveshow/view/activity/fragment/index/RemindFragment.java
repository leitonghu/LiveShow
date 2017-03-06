package com.xihoo.liveshow.view.activity.fragment.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xihoo.liveshow.R;
import com.xihoo.liveshow.view.activity.fragment.BaseFragment;

/**
 * 关注主播列表
 * Created by leitonghu on 17/2/22.
 */

public class RemindFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_remind,null);
    }
}
