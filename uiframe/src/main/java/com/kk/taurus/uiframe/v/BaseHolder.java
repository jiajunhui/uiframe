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

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;

import com.kk.taurus.uiframe.i.BaseViewHandle;
import com.kk.taurus.uiframe.i.Holder;
import com.kk.taurus.uiframe.i.IResource;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/1/13.
 */

public abstract class BaseHolder implements Holder,BaseViewHandle,IResource,View.OnClickListener {

    protected Context mContext;
    protected OnHolderListener mOnHolderListener;
    protected View mRootView;

    public BaseHolder(Context context){
        this(context,null);
    }

    public BaseHolder(Context context, OnHolderListener onHolderListener){
        this.mContext = context;
        this.mOnHolderListener = onHolderListener;
        onCreate();
    }

    @Override
    public final LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mContext);
    }

    @Override
    public final void setContentView(int id) {
        setContentView(getLayoutInflater().inflate(id,null,false));
    }

    @Override
    public final void setContentView(View view) {
        mRootView = view;
    }

    public abstract void onCreate();

    @Override
    public Activity getActivity() {
        if(mContext instanceof Activity)
            return (Activity)mContext;
        return null;
    }

    @Override
    public final <T extends View> T getViewById(int id) {
        return (T) mRootView.findViewById(id);
    }

    @Override
    public View getHolderView() {
        return mRootView;
    }

    @Override
    public void setBackgroundColor(int color) {
        mRootView.setBackgroundColor(color);
    }

    @Override
    public void setVisibility(int visibility) {
        mRootView.setVisibility(visibility);
    }

    @Override
    public void setGravity(int gravity) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public int getScreenWidth() {
        DisplayMetrics displayMetrics = getResource().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    @Override
    public int getScreenHeight() {
        DisplayMetrics displayMetrics = getResource().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    @Override
    public Resources getResource() {
        return mContext.getResources();
    }

    @Override
    public float getDimension(int id) {
        return getResource().getDimension(id);
    }

    @Override
    public String getString(int id) {
        return getResource().getString(id);
    }

    @Override
    public Drawable getDrawable(int id) {
        return getResource().getDrawable(id);
    }

    @Override
    public int getColor(int id) {
        return getResource().getColor(id);
    }
}
