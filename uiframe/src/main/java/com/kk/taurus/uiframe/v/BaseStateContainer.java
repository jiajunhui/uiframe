package com.kk.taurus.uiframe.v;

import android.content.Context;
import android.widget.FrameLayout;

import com.kk.taurus.uiframe.i.IUserHolder;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public abstract class BaseStateContainer extends AbsStateContainer {

    protected FrameLayout mRootContainer;

    public BaseStateContainer(Context context, IUserHolder userHolder) {
        super(context, userHolder);
    }

    public BaseStateContainer(Context context, IUserHolder mUserHolder, OnHolderListener onHolderListener) {
        super(context, mUserHolder, onHolderListener);
    }

    @Override
    public void onCreate() {
        mRootContainer = new FrameLayout(mContext);
        setContentView(mRootContainer);
    }

}
