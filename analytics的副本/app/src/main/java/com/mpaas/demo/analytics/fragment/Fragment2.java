package com.mpaas.demo.analytics.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alipay.mobile.monitor.track.TrackPageConfig;
import com.mpaas.demo.analytics.R;

import java.util.Map;

/**
 * Created by xingcheng on 2018/7/27.
 */

public class Fragment2 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

}
