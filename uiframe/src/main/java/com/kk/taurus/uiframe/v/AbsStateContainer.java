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
        if(mUserHolder!=null){
            if(mUserHolder.titleBarHolder!=null){
                mUserHolder.titleBarHolder.setState(state);
            }
            if(mUserHolder.loadingHolder!=null){
                mUserHolder.loadingHolder.setState(state);
            }
        }
    }

    public BaseUserHolder getUserHolder() {
        return mUserHolder;
    }

}
