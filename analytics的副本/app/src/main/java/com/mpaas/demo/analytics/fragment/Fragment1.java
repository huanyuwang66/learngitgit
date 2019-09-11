package com.mpaas.demo.analytics.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alipay.mobile.antui.segement.AUSegment;
import com.mpaas.demo.analytics.R;
import com.mpaas.mas.adapter.api.MPTracker;

/**
 * Created by xingcheng on 2018/7/27.
 */
public class Fragment1 extends BaseFragment {

    private static final String ID_VIEW_1 = "view1";
    private static final String ID_VIEW_2 = "view2";
    private int selectedTab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        final View view1 = view.findViewById(R.id.text1);
        final View view2 = view.findViewById(R.id.text2);
        AUSegment auSegment = (AUSegment) view.findViewById(R.id.view_tab);
        auSegment.setTabSwitchListener(new AUSegment.TabSwitchListener() {
            @Override
            public void onTabClick(int i, View view) {
                if (selectedTab == i) {
                    return;
                }
                selectedTab = i;
                switch (i) {
                    case 0:
                        view1.setVisibility(View.VISIBLE);
                        view2.setVisibility(View.GONE);
                        // View之间的切换，需要手动调用
                        MPTracker.enterView(view1, ID_VIEW_1);
                        MPTracker.leaveView(view2, ID_VIEW_2);
                        break;
                    case 1:
                        view1.setVisibility(View.GONE);
                        view2.setVisibility(View.VISIBLE);
                        MPTracker.leaveView(view1, ID_VIEW_1);
                        MPTracker.enterView(view2, ID_VIEW_2);
                        break;
                }
            }
        });
        return view;
    }
}
