package com.kk.taurus.uiframe;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import java.util.List;

/**
 * Created by Taurus on 2017/9/27.
 */

public class FrameApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String processName = getProcessName(getApplicationContext(),android.os.Process.myPid());
        if(getPackageName().equals(processName)) {
            onCreateInAppMainProcess();
        }
    }

    protected void onCreateInAppMainProcess() {

    }

    public String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }

}
