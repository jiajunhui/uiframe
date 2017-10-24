package com.kk.taurus.uiframe.v;

import android.content.Context;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.i.IStateContainer;
import com.kk.taurus.uiframe.i.IUserHolder;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public abstract class AbsStateContainer extends BaseHolder implements IStateContainer {

    protected BaseState mState = new BaseState(BaseState.STATE_SUCCESS);
    protected BaseUserHolder mUserHolder;

    public AbsStateContainer(Context context, IUserHolder userHolder) {
        this(context, userHolder, null);
    }

    public AbsStateContainer(Context context, IUserHolder userHolder, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
        onInitUserHolder(userHolder);
        onLayoutLogic();
    }

    /**
     * on construction method, init user holders.
     * @param userHolder
     */
    protected void onInitUserHolder(IUserHolder userHolder) {
        mUserHolder = new BaseUserHolder();
        mUserHolder.titleBarHolder = userHolder.onBindTitleBarHolder();
        mUserHolder.contentHolder = userHolder.onBindContentHolder();
        mUserHolder.loadingHolder = userHolder.onBindLoadingHolder();
        mUserHolder.errorHolder = userHolder.onBindErrorHolder();
    }

    /**
     * on construction method, handle layout logic for your custom location.
     */
    protected abstract void onLayoutLogic();

    @Override
    public void setState(BaseState state) {
        this.mState = state;
        if(mUserHolder!=null && mUserHolder.titleBarHolder!=null){
            mUserHolder.titleBarHolder.setState(state);
        }
    }

    public BaseUserHolder getUserHolder() {
        return mUserHolder;
    }

}
