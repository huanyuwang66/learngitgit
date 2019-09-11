package com.mpaas.demo.analytics;

import android.os.Bundle;

import com.alipay.mobile.framework.app.ActivityApplication;

/**
 * Created by xingcheng on 2018/7/27.
 */

public class AnalyticsMicroApp extends ActivityApplication {

    private Bundle mParam;

    @Override
    public String getEntryClassName() {
        return null;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        mParam = bundle;
    }

    @Override
    protected void onStart() {
        doStart(mParam);
    }

    @Override
    protected void onRestart(Bundle bundle) {
        mParam = bundle;
        doStart(mParam);
    }

    @Override
    protected void onStop() {

    }

    @Override
    protected void onDestroy(Bundle bundle) {

    }

    private void doStart(Bundle bundle) {
        String className = AnalyticsActivity.class.getName();
        getMicroApplicationContext().startActivity(this, className);
    }
}
