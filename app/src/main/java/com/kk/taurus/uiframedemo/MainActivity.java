package com.kk.taurus.uiframedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kk.taurus.uiframe.a.TitleBarActivity;
import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.d.BaseTitleBarParams;
import com.kk.taurus.uiframe.i.ITitleBar;
import com.kk.taurus.uiframe.i.OnForeOrBackgroundCallback;
import com.kk.taurus.uiframe.manager.ActivityManager;
import com.kk.taurus.uiframe.v.BaseErrorHolder;
import com.kk.taurus.uiframe.v.BaseLoadingHolder;
import com.kk.taurus.uiframe.v.BaseTitleBarHolder;
import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframedemo.entity.MainData;
import com.kk.taurus.uiframedemo.holder.AppTitleBarHolder;
import com.kk.taurus.uiframedemo.holder.ErrorHolder;
import com.kk.taurus.uiframedemo.holder.MainHolder;

public class MainActivity extends TitleBarActivity<MainData,MainHolder> implements MainHolder.OnMainHolderListener, OnForeOrBackgroundCallback {

    private final String TAG = "MainActivity";

    @Override
    protected void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        setPageState(BaseState.LOADING);
        mRootView.postDelayed(new Runnable() {
            @Override
            public void run() {
                setPageState(BaseState.ERROR);
            }
        }, 2000);
        getUserContentHolder().setOnMainHolderListener(this);
        BaseTitleBarHolder titleBarHolder = getUserHolder().titleBarHolder;
        ((AppTitleBarHolder)titleBarHolder).setTitle("我是标题");

        ActivityManager.getInstance().registerGroundCallback(this);

    }

    @Override
    public void onHolderEvent(int eventCode, Bundle bundle) {
        super.onHolderEvent(eventCode, bundle);
        switch (eventCode){
            case ITitleBar.TITLE_BAR_EVENT_NAVIGATION_CLICK:
                onFinish();
                break;
            case BaseErrorHolder.ERROR_EVENT_ON_ERROR_CLICK:
                setPageState(BaseState.LOADING);
                mRootView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainData data = new MainData();
                        data.text = "success";
                        setData(data);
                        setPageState(BaseState.SUCCESS);
                    }
                }, 2000);
                break;
        }
    }

    @Override
    public void onIntentToNoTitleBarPage() {
        Intent intent = new Intent(this,NoTitleBarActivity.class);
        startActivity(intent);
    }

    @Override
    public BaseTitleBarHolder onBindTitleBarHolder() {
        return new AppTitleBarHolder(this,this){
            @Override
            public BaseTitleBarParams getTitleBarParams() {
                BaseTitleBarParams params = new BaseTitleBarParams();
                params.titleBarHeight = 180;
                return params;
            }
        };
    }

    @Override
    public ContentHolder onBindContentHolder() {
        return new MainHolder(this);
    }

    @Override
    public BaseLoadingHolder onBindLoadingHolder() {
        return new BaseLoadingHolder(this) {
            @Override
            public void onCreate() {
                setContentView(R.layout.layout_loading);
            }
        };
    }

    @Override
    public BaseErrorHolder onBindErrorHolder() {
        return new ErrorHolder(this,this);
    }

    @Override
    public void onEnterForeground(Activity currentActivity) {
        Log.d(TAG,"enter foreground : current = " + currentActivity.getClass().getSimpleName());
    }

    @Override
    public void onEnterBackground(Activity currentActivity) {
        Log.d(TAG,"enter background : current = " + currentActivity.getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().unregisterGroundCallback(this);
    }
}
