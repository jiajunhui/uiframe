package com.kk.taurus.uiframe.v;

import android.content.Context;

import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/10/1.
 */

public abstract class BaseErrorHolder extends BaseHolder {

    public static final int ERROR_EVENT_ON_ERROR_CLICK = -2001;

    public BaseErrorHolder(Context context) {
        super(context);
    }

    public BaseErrorHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

}
