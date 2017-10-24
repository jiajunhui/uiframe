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
