package com.kk.taurus.uiframe.a;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kk.taurus.uiframe.manager.ActivityManager;

/**
 * Created by Taurus on 2017/9/27.
 */

public abstract class AbsActivity extends AppCompatActivity {

    protected View mRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().onActivityCreated(this,savedInstanceState);
        mRootView = getContentView();
        if(mRootView!=null){
            onBeforeSetContentView();
            setContentView(mRootView);
            onInit(savedInstanceState);
        }
    }

    protected void onBeforeSetContentView() {

    }

    protected void onInit(Bundle savedInstanceState) {

    }

    protected abstract View getContentView();

    @Override
    protected void onStart() {
        super.onStart();
        ActivityManager.getInstance().onActivityStarted(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityManager.getInstance().onActivityResumed(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActivityManager.getInstance().onActivityPaused(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ActivityManager.getInstance().onActivityStopped(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ActivityManager.getInstance().onActivitySaveInstanceState(this,outState);
    }

    public void onFinish(){
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().onActivityDestroyed(this);
    }

}
