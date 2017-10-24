package com.kk.taurus.uiframedemo.holder;

import android.content.Context;

import com.kk.taurus.uiframe.listener.OnHolderListener;
import com.kk.taurus.uiframe.v.BaseLoadingHolder;
import com.kk.taurus.uiframedemo.R;

/**
 * Created by Taurus on 2017/10/9.
 */

public class LoadingHolder extends BaseLoadingHolder {

    public LoadingHolder(Context context) {
        super(context);
    }

    public LoadingHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

    @Override
    public void onCreate() {
        setContentView(R.layout.layout_loading);
    }

}
