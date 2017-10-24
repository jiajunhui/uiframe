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
