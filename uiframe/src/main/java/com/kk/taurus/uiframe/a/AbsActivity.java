/*
 * Copyright 2017 jiajunhui<junhui_jia@163.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.kk.taurus.uiframe.a;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kk.taurus.uiframe.manager.ActivityFilterManager;
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
            onParseIntent();
            onBeforeSetContentView();
            setContentView(mRootView);

            onInit(savedInstanceState);
            onLoadState();
        }
    }

    protected abstract void onLoadState();

    protected void onParseIntent(){

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
    protected void onNewIntent(Intent intent) {
        ActivityFilterManager.getInstance().onNewIntent(this, intent);
        super.onNewIntent(intent);
    }

    @Override
    public void startActivity(Intent intent) {
        ActivityFilterManager.getInstance().startActivity(this, intent);
        super.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        ActivityFilterManager.getInstance().startActivityForResult(this, intent, requestCode);
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().onActivityDestroyed(this);
    }

}
