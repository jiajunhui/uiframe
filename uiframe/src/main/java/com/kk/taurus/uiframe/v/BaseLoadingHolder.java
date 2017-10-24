package com.kk.taurus.uiframe.v;

import android.content.Context;

import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/10/1.
 */

public abstract class BaseLoadingHolder extends BaseHolder {

    public BaseLoadingHolder(Context context) {
        super(context);
    }

    public BaseLoadingHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

}
