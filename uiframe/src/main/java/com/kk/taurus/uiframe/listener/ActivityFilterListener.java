package com.kk.taurus.uiframe.listener;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Taurus on 2017/9/30.
 */

public interface ActivityFilterListener {

    void onNewIntent(Activity activity, Intent intent);

    void startActivity(Activity activity, Intent intent);

    void startActivityForResult(Activity activity, Intent intent, int requestCode);

}
