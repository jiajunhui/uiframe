package com.kk.taurus.uiframedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kk.taurus.uiframe.a.TitleBarActivity;
import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.i.ITitleBar;
import com.kk.taurus.uiframe.i.OnForeOrBackgroundCallback;
import com.kk.taurus.uiframe.manager.ActivityManager;
import com.kk.taurus.uiframe.v.BaseErrorHolder;
import com.kk.taurus.uiframe.v.BaseTitleBarHolder;
import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframe.v.d.DefaultTitleBarHolder;
import com.kk.taurus.uiframe.w.TitleBarMenu;
import com.kk.taurus.uiframedemo.entity.MainData;
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
        titleBarHolder.setTitle("我是标题");

        DefaultTitleBarHolder defaultTitleBarHolder = (DefaultTitleBarHolder)titleBarHolder;
        TitleBarMenu menu = defaultTitleBarHolder.getMenu();
        menu.setTriggerType(TitleBarMenu.TRIGGER_TYPE_TEXT);
        menu.setMenuText("设置");
        menu.setOnMenuListener(new TitleBarMenu.OnMenuListener() {
            @Override
            public void onTriggerClick(int triggerType, View view) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

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
//        boolean visible = isTitleBarVisible();
//        setTitleBarVisibleState(!visible);
    }

    @Override
    public ContentHolder onBindContentHolder() {
        return new MainHolder(this);
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
