package com.kk.taurus.uiframe.v;

import android.content.Context;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.d.BaseTitleBarParams;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public abstract class BaseTitleBarHolder extends BaseHolder {

    protected BaseState mState;

    public BaseTitleBarHolder(Context context) {
        super(context);
    }

    public BaseTitleBarHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

    public void setState(BaseState state){
        this.mState = state;
    }

    public abstract BaseTitleBarParams getTitleBarParams();

}
