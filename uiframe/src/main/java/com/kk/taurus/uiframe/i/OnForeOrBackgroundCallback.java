package com.kk.taurus.uiframe.i;

import android.app.Activity;

/**
 * Created by Taurus on 2017/10/9.
 */

public interface OnForeOrBackgroundCallback {
    void onEnterForeground(Activity currentActivity);
    void onEnterBackground(Activity currentActivity);
}
