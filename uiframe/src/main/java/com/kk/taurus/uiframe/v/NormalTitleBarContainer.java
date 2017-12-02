/*
 * Copyright 2017 jiajunhui<junhui_jia@163.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.kk.taurus.uiframe.v;


import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.d.BaseTitleBarParams;
import com.kk.taurus.uiframe.i.IUserHolder;
import com.kk.taurus.uiframe.i.OnHolderVisibilityChangeListener;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public class NormalTitleBarContainer extends BaseStateContainer {

    protected FrameLayout mContentContainer;

    public NormalTitleBarContainer(Context context, IUserHolder userHolder) {
        super(context, userHolder);
    }

    public NormalTitleBarContainer(Context context, IUserHolder mUserHolder, OnHolderListener onHolderListener) {
        super(context, mUserHolder, onHolderListener);
    }

    @Override
    protected void onLayoutLogic() {
        if(mUserHolder.titleBarHolder==null)
            return;
        BaseTitleBarParams baseTitleBarParams = mUserHolder.titleBarHolder.getTitleBarParams();
        if(baseTitleBarParams == null)
            return;
        final int titleBarHeight = baseTitleBarParams.titleBarHeight;
        if(titleBarHeight <= 0)
            return;
        View titleBarView = mUserHolder.titleBarHolder.getHolderView();
        ViewCompat.setElevation(titleBarView,25f);
        //add title bar view
        mRootContainer.addView(titleBarView
                ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, titleBarHeight));

        mContentContainer = new FrameLayout(mContext);
        if(mUserHolder.contentHolder==null)
            return;
        View contentView = mUserHolder.contentHolder.getHolderView();
        //add content view
        mContentContainer.addView(contentView
                ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        //add content container
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.topMargin = titleBarHeight;
        mRootContainer.addView(mContentContainer,layoutParams);

        mUserHolder.titleBarHolder.setOnHolderVisibilityChangeListener(new OnHolderVisibilityChangeListener() {
            @Override
            public void onVisibilityChange(int visibility) {
                switch (visibility){
                    case View.VISIBLE:
                        notifyContentContainerParams(titleBarHeight);
                        break;
                    case View.GONE:
                        notifyContentContainerParams(0);
                        break;
                }
            }
        });
    }

    private void notifyContentContainerParams(int titleBarHeight){
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mContentContainer.getLayoutParams();
        layoutParams.topMargin = titleBarHeight;
        mContentContainer.setLayoutParams(layoutParams);
    }

    @Override
    public void onStateChange(BaseState state) {
        switch (state.getStateCode()){
            case BaseState.STATE_SUCCESS:
                if(mUserHolder.contentHolder==null)
                    return;
                mContentContainer.removeAllViews();
                BaseHolder contentHolder = mUserHolder.contentHolder;
                mContentContainer.addView(contentHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            case BaseState.STATE_LOADING:
                if(mUserHolder.loadingHolder==null)
                    return;
                mContentContainer.removeAllViews();
                BaseHolder loadingHolder = mUserHolder.loadingHolder;
                mContentContainer.addView(loadingHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            case BaseState.STATE_ERROR:
                if(mUserHolder.errorHolder==null)
                    return;
                mContentContainer.removeAllViews();
                BaseHolder errorHolder = mUserHolder.errorHolder;
                mContentContainer.addView(errorHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
        }
    }

}
