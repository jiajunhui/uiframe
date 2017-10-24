package com.kk.taurus.uiframe.v;

import android.content.Context;
import android.view.ViewGroup;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.i.IUserHolder;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public class NoTitleBarContainer extends BaseStateContainer {

    public NoTitleBarContainer(Context context, IUserHolder userHolder) {
        super(context, userHolder);
    }

    public NoTitleBarContainer(Context context, IUserHolder mUserHolder, OnHolderListener onHolderListener) {
        super(context, mUserHolder, onHolderListener);
    }

    @Override
    protected void onLayoutLogic() {

    }

    @Override
    public void setState(BaseState state) {
        super.setState(state);
        switch (state.getStateCode()){
            case BaseState.STATE_SUCCESS:
                mRootContainer.removeAllViews();
                BaseHolder contentHolder = mUserHolder.contentHolder;
                mRootContainer.addView(contentHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            case BaseState.STATE_LOADING:
                mRootContainer.removeAllViews();
                BaseHolder loadingHolder = mUserHolder.loadingHolder;
                mRootContainer.addView(loadingHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            case BaseState.STATE_ERROR:
                mRootContainer.removeAllViews();
                BaseHolder errorHolder = mUserHolder.errorHolder;
                mRootContainer.addView(errorHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
        }
    }

}
