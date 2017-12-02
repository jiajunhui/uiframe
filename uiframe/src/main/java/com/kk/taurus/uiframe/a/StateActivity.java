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

package com.kk.taurus.uiframe.a;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.i.HolderData;
import com.kk.taurus.uiframe.i.IUserHolder;
import com.kk.taurus.uiframe.listener.OnHolderListener;
import com.kk.taurus.uiframe.v.BaseErrorHolder;
import com.kk.taurus.uiframe.v.BaseLoadingHolder;
import com.kk.taurus.uiframe.v.BaseStateContainer;
import com.kk.taurus.uiframe.v.BaseTitleBarHolder;
import com.kk.taurus.uiframe.v.BaseUserHolder;
import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframe.v.NoTitleBarContainer;
import com.kk.taurus.uiframe.v.d.DefaultErrorHolder;
import com.kk.taurus.uiframe.v.d.DefaultLoadingHolder;

/**
 * Created by Taurus on 2017/9/27.
 */

public abstract class StateActivity<T extends HolderData, H extends ContentHolder<T>> extends ToolsActivity implements IUserHolder, OnHolderListener {

    private BaseStateContainer mStateContainer;
    protected BaseState mState;
    protected T mData;

    @Override
    protected final View getContentView() {
        mStateContainer = getStateContainer();
        if(mStateContainer==null)
            return null;
        if(getUserContentHolder()!=null){
            getUserContentHolder().onHolderCreated();
        }else{
            return null;
        }
        return mStateContainer.getHolderView();
    }

    @Override
    protected void onLoadState() {
        setPageState(BaseState.SUCCESS);
    }

    /**
     * set activity page state.
     * @param state
     */
    protected void setPageState(BaseState state){
        if(mStateContainer!=null){
            this.mState = state;
            mStateContainer.setState(state);
        }
    }

    private boolean isUserHolderAvailable(){
        return mStateContainer!=null && mStateContainer.getUserHolder()!=null;
    }

    public BaseUserHolder getUserHolder(){
        if(mStateContainer!=null){
            return mStateContainer.getUserHolder();
        }
        return null;
    }

    /**
     * set model data for content holder.
     * @param data
     */
    protected void setData(T data){
        this.mData = data;
        ContentHolder contentHolder = getUserContentHolder();
        if(contentHolder!=null){
            contentHolder.onDataChanged(data);
        }
    }

    /**
     * get user content holder.
     * @return
     */
    protected H getUserContentHolder(){
        if(isUserHolderAvailable()){
            return (H) mStateContainer.getUserHolder().contentHolder;
        }
        return null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(getUserContentHolder()!=null)
            getUserContentHolder().onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(getUserContentHolder()!=null)
            getUserContentHolder().onNewIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getUserContentHolder()!=null)
            getUserContentHolder().onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getUserContentHolder()!=null)
            getUserContentHolder().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(getUserContentHolder()!=null)
            getUserContentHolder().onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(getUserContentHolder()!=null)
            getUserContentHolder().onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(getUserContentHolder()!=null)
            getUserContentHolder().onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(getUserContentHolder()!=null)
            getUserContentHolder().onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        H userContentHolder = getUserContentHolder();
        if(userContentHolder==null){
            super.onBackPressed();
        }else{
            if(!userContentHolder.onBackPressed()){
                super.onBackPressed();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(getUserContentHolder()!=null)
            getUserContentHolder().onDestroy();
    }

    @Override
    public void onHolderEvent(int eventCode, Bundle bundle) {

    }

    /**
     * Try to use the construction method of three
     * parameters to implement all callback methods
     * @return
     */
    protected BaseStateContainer getStateContainer(){
        return new NoTitleBarContainer(this,this,this);
    }

    @Override
    public BaseTitleBarHolder onBindTitleBarHolder() {
        return null;
    }

    @Override
    public BaseLoadingHolder onBindLoadingHolder() {
        return new DefaultLoadingHolder(this,this);
    }

    @Override
    public BaseErrorHolder onBindErrorHolder() {
        return new DefaultErrorHolder(this,this);
    }
}
