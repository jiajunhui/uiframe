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
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.i.HolderData;
import com.kk.taurus.uiframe.i.HolderLifeCycle;
import com.kk.taurus.uiframe.i.IContentHolder;
import com.kk.taurus.uiframe.listener.OnHolderListener;
import com.kk.taurus.uiframe.manager.HolderPoolCallbackHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taurus on 2017/1/17.
 */

public abstract class ContentHolder<T extends HolderData> extends BaseHolder implements IContentHolder {

    protected T mData;
    private List<BaseHolder> mHolderPool;
    private HolderPoolCallbackHandler mCallbackHandler;

    public ContentHolder(Context context) {
        this(context, null);
    }

    public ContentHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
        mHolderPool = new ArrayList<>();
        mCallbackHandler = new HolderPoolCallbackHandler(mHolderPool);
    }

    @Override
    public void onHolderCreated(){

    }

    public void onPageStateChange(BaseState state){

    }

    protected final void addHolderToLifeCyclePool(BaseHolder holder){
        if(mHolderPool == null){
            mHolderPool = new ArrayList<>();
        }
        mHolderPool.add(holder);
    }

    private void clearHolderPool(){
        if(mHolderPool!=null){
            mHolderPool.clear();
        }
    }

    public void onDataChanged(T data){
        this.mData = data;
        refreshView();
    }

    public void refreshView() {

    }

    @Override
    public void onRestart() {
        mCallbackHandler.handleCallback(HolderLifeCycle.LIFE_CYCLE_ON_RESTART);
    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public Intent getIntent() {
        if(getActivity()!=null)
            return getActivity().getIntent();
        return null;
    }

    @Override
    public void onStart() {
        mCallbackHandler.handleCallback(HolderLifeCycle.LIFE_CYCLE_ON_START);
    }

    @Override
    public void onResume() {
        mCallbackHandler.handleCallback(HolderLifeCycle.LIFE_CYCLE_ON_RESUME);
    }

    @Override
    public void onPause() {
        mCallbackHandler.handleCallback(HolderLifeCycle.LIFE_CYCLE_ON_PAUSE);
    }

    @Override
    public void onStop() {
        mCallbackHandler.handleCallback(HolderLifeCycle.LIFE_CYCLE_ON_STOP);
    }

    @Override
    public boolean onBackPressed(){
        return false;
    }

    @Override
    public void onDestroy() {
        mCallbackHandler.handleCallback(HolderLifeCycle.LIFE_CYCLE_ON_DESTROY);
        clearHolderPool();
    }

    @Override
    public void finish() {
        if(getActivity()!=null){
            getActivity().finish();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState){

    }

}
