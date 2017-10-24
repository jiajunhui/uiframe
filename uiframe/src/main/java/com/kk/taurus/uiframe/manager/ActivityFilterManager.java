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
import android.content.Intent;

import com.kk.taurus.uiframe.listener.ActivityFilterListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public class ActivityFilterManager {

    private static ActivityFilterManager instance;

    private ActivityFilterManager(){}

    public static ActivityFilterManager getInstance(){
        if(null==instance){
            synchronized (ActivityFilterManager.class){
                if(null==instance){
                    instance = new ActivityFilterManager();
                }
            }
        }
        return instance;
    }

    private ActivityFilterListener activityFilterListener;

    public void setActivityFilterListener(ActivityFilterListener activityFilterListener){
        this.activityFilterListener = activityFilterListener;
    }

    public void onNewIntent(Activity activity, Intent intent){
        if(activityFilterListener!=null){
            activityFilterListener.onNewIntent(activity, intent);
        }
    }

    public void startActivity(Activity activity, Intent intent){
        if(activityFilterListener!=null){
            activityFilterListener.startActivity(activity, intent);
        }
    }

    public void startActivityForResult(Activity activity, Intent intent, int requestCode){
        if(activityFilterListener!=null){
            activityFilterListener.startActivityForResult(activity, intent, requestCode);
        }
    }

}
