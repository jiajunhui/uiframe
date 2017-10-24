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
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.d.BaseTitleBarParams;
import com.kk.taurus.uiframe.i.IUserHolder;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public class NormalTitleBarContainer extends BaseStateContainer {

    private FrameLayout mContentContainer;

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
        int height = baseTitleBarParams.titleBarHeight;
        if(height <= 0)
            return;
        mRootContainer.addView(mUserHolder.titleBarHolder.getHolderView()
                ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.topMargin = height;

        mContentContainer = new FrameLayout(mContext);
        mContentContainer.addView(mUserHolder.contentHolder.getHolderView()
                ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mRootContainer.addView(mContentContainer,layoutParams);
    }

    @Override
    public void setState(BaseState state) {
        super.setState(state);
        switch (state.getStateCode()){
            case BaseState.STATE_SUCCESS:
                mContentContainer.removeAllViews();
                BaseHolder contentHolder = mUserHolder.contentHolder;
                mContentContainer.addView(contentHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            case BaseState.STATE_LOADING:
                mContentContainer.removeAllViews();
                BaseHolder loadingHolder = mUserHolder.loadingHolder;
                mContentContainer.addView(loadingHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            case BaseState.STATE_ERROR:
                mContentContainer.removeAllViews();
                BaseHolder errorHolder = mUserHolder.errorHolder;
                mContentContainer.addView(errorHolder.getHolderView()
                        ,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.MATCH_PARENT));
                break;
        }
    }

}
