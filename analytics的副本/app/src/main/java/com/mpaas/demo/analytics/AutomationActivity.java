package com.mpaas.demo.analytics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.alipay.mobile.antui.basic.AUTitleBar;
import com.alipay.mobile.antui.segement.AUSegment;
import com.alipay.mobile.framework.app.ui.BaseFragmentActivity;
import com.mpaas.demo.analytics.fragment.Fragment1;
import com.mpaas.demo.analytics.fragment.Fragment2;
import com.mpaas.mas.adapter.api.MPLogger;

/**
 * Created by xingcheng on 2018/7/27.
 *
 * 继承mpaas框架提供的BaseActivity、BaseFragmentActivity
 * 即可被自动化日志记录
 */
public class AutomationActivity extends BaseFragmentActivity {

    private Fragment[] fragments = new Fragment[2];
    private int selectedTab = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automation);

        // 开启自动化日志
        // 开发者可在 MockLauncherActivityAgent.postInit() 中调用
        MPLogger.enableAutoLog();

        ((AUTitleBar) findViewById(R.id.automation_title)).setTitleText(getString(R.string.automation_title));

        AUSegment auSegment = (AUSegment) findViewById(R.id.tab);
        auSegment.setTabSwitchListener(new AUSegment.TabSwitchListener() {
            @Override
            public void onTabClick(int i, View view) {
                changeFragment(i);
            }
        });

        fragments[0] = new Fragment1();
        fragments[1] = new Fragment2();
        changeFragment(0);
    }

    private void changeFragment(int tab) {
        if (selectedTab != tab) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (selectedTab != -1) {
                transaction.hide(fragments[selectedTab]);
            }
            selectedTab = tab;
            Fragment f = fragments[tab];
            if (!f.isAdded()) {
                transaction.add(R.id.container, f).commitAllowingStateLoss();
            } else {
                transaction.show(f).commitAllowingStateLoss();
            }
        }
    }
}
