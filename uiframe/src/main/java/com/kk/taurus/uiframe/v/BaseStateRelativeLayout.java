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
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.i.IStateLayout;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by mtime on 2017/11/30.
 */

public abstract class BaseStateRelativeLayout extends RelativeLayout implements IStateLayout, OnHolderListener{

    private BaseState mState;
    private View mStateView;
    private OnHolderListener mOnHolderListener;

    public BaseStateRelativeLayout(Context context) {
        super(context);
    }

    public BaseStateRelativeLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnHolderListener(OnHolderListener onHolderListener) {
        this.mOnHolderListener = onHolderListener;
    }

    @Override
    public void setState(BaseState state) {
        boolean isStateChange = isStateChange(state);
        this.mState = state;
        if(isStateChange){
            onStateChange(state);
        }
    }

    private boolean isStateChange(BaseState newState){
        return mState==null || (mState.getStateCode()!=newState.getStateCode());
    }

    protected void onStateChange(BaseState state){
        switch (state.getStateCode()){
            case BaseState.STATE_SUCCESS:
                removeStateView();
                break;
            case BaseState.STATE_LOADING:
                removeStateView();
                BaseLoadingHolder loadingHolder = getLoadingHolder();
                loadingHolder.setState(state);
                mStateView = loadingHolder.getHolderView();
                if(mStateView!=null){
                    mStateView.setBackgroundColor(Color.WHITE);
                    addView(mStateView,getMatchLayoutParams());
                }
                break;
            case BaseState.STATE_ERROR:
                removeStateView();
                BaseErrorHolder errorHolder = getErrorHolder();
                mStateView = errorHolder.getHolderView();
                if(mStateView!=null){
                    addView(mStateView,getMatchLayoutParams());
                }
                break;
        }
    }

    protected void removeStateView(){
        if(mStateView!=null){
            removeView(mStateView);
        }
    }

    protected LayoutParams getMatchLayoutParams(){
        return new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onHolderEvent(int eventCode, Bundle bundle) {
        if(mOnHolderListener!=null){
            mOnHolderListener.onHolderEvent(eventCode, bundle);
        }
    }

    protected abstract BaseLoadingHolder getLoadingHolder();

    protected abstract BaseErrorHolder getErrorHolder();

}
