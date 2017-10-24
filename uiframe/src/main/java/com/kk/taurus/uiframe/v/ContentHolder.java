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

import com.kk.taurus.uiframe.i.HolderData;
import com.kk.taurus.uiframe.i.IContentHolder;

/**
 * Created by Taurus on 2017/1/17.
 */

public abstract class ContentHolder<T extends HolderData> extends BaseHolder implements IContentHolder {

    protected T mData;

    public ContentHolder(Context context) {
        super(context);
    }

    @Override
    public void onHolderCreated(Bundle savedInstanceState){

    }

    public void onDataChanged(T data){
        this.mData = data;
        refreshView();
    }

    public void refreshView() {

    }

    @Override
    public void onRestart() {

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

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    public boolean onBackPressed(){
        return false;
    }

    @Override
    public void onDestroy() {

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
