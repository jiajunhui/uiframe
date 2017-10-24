package com.kk.taurus.uiframe.a;

import android.content.Intent;

import com.kk.taurus.uiframe.manager.ActivityFilterManager;

/**
 * Created by Taurus on 2017/9/27.
 */

public abstract class FilterActivity extends AbsActivity {

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

}
