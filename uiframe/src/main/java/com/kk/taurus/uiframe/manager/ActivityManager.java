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

package com.kk.taurus.uiframe.manager;

import android.app.Activity;
import android.os.Bundle;

import com.kk.taurus.uiframe.i.OnForeOrBackgroundCallback;
import com.kk.taurus.uiframe.listener.ActivityLifeCycleListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Taurus on 2017/1/13.
 */

public class ActivityManager implements ActivityLifeCycleListener {

    private Stack<WeakReference<Activity>> activities = new Stack<>();
    private List<OnForeOrBackgroundCallback> callbackList = new ArrayList<>();
    private int mPreForegroundPages;
    private int mForegroundPages;
    private static ActivityManager instance = new ActivityManager();

    private ActivityLifeCycleListener mActivityLifeCycleListener;

    private ActivityManager(){

    }

    public void setActivityLifeCycleListener(ActivityLifeCycleListener activityLifeCycleListener){
        this.mActivityLifeCycleListener = activityLifeCycleListener;
    }

    public static ActivityManager getInstance(){
        return instance;
    }

    public void registerGroundCallback(OnForeOrBackgroundCallback callback){
        callbackList.add(callback);
    }

    public boolean unregisterGroundCallback(OnForeOrBackgroundCallback callback){
        return callbackList.remove(callback);
    }

    public void cancelAllGroundCallbacks(){
        callbackList.clear();
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState){
        activities.push(new WeakReference<>(activity));
        if(mActivityLifeCycleListener!=null){
            mActivityLifeCycleListener.onActivityCreated(activity, savedInstanceState);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        mPreForegroundPages = mForegroundPages;
        mForegroundPages++;
        judgeCallbacks(activity);
        if(mActivityLifeCycleListener!=null){
            mActivityLifeCycleListener.onActivityStarted(activity);
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        if(mActivityLifeCycleListener!=null){
            mActivityLifeCycleListener.onActivityResumed(activity);
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        if(mActivityLifeCycleListener!=null){
            mActivityLifeCycleListener.onActivityPaused(activity);
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {
        mPreForegroundPages = mForegroundPages;
        mForegroundPages--;
        judgeCallbacks(activity);
        if(mActivityLifeCycleListener!=null){
            mActivityLifeCycleListener.onActivityStopped(activity);
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        if(mActivityLifeCycleListener!=null){
            mActivityLifeCycleListener.onActivitySaveInstanceState(activity, outState);
        }
    }

    public void onActivityDestroyed(Activity activity){
        if(activities.contains(activity)){
            activities.remove(activity);
            if(mActivityLifeCycleListener!=null){
                mActivityLifeCycleListener.onActivityDestroyed(activity);
            }
        }
    }

    public void finish(Activity activity){
        activity.finish();
        onActivityDestroyed(activity);
    }

    private void judgeCallbacks(Activity activity){
        if(callbackList.size()<=0)
            return;
        int size = callbackList.size();
        for(int i=0;i<size;i++){
            OnForeOrBackgroundCallback callback = callbackList.get(i);
            if(callback==null)
                continue;
            if(mPreForegroundPages==0 && mForegroundPages==1){
                callback.onEnterForeground(activity);
            }
            if(mPreForegroundPages==1 && mForegroundPages==0){
                callback.onEnterBackground(activity);
            }
        }
    }

    public void finishAll(){
        while (!activities.empty()){
            WeakReference<Activity> activity = activities.pop();
            if(activity!=null && activity.get()!=null){
                finish(activity.get());
            }
        }
    }
}
