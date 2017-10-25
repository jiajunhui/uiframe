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

package com.kk.taurus.uiframe.f;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.kk.taurus.uiframe.i.IToolsInterface;
import com.kk.taurus.uiframe.listener.OnNetChangeListener;
import com.kk.taurus.uiframe.u.Utils;
import com.kk.taurus.uiframe.w.NetChangeReceiver;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by Taurus on 2017/10/9.
 */

public abstract class ToolsFragment extends AbsFragment implements IToolsInterface, OnNetChangeListener{

    private boolean isFullScreen;
    private NetChangeReceiver mNetChangeReceiver;

    @Override
    protected void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        registerNetChangeReceiver();
    }

    private void registerNetChangeReceiver() {
        try{
            mNetChangeReceiver = new NetChangeReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            if(getActivity()!=null){
                getActivity().registerReceiver(mNetChangeReceiver,intentFilter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onNetWorkError() {

    }

    @Override
    public void onNetWorkConnected(boolean isWifi, int ext) {

    }

    @Override
    public boolean isNetworkConnected() {
        return Utils.isNetworkConnected(mContext);
    }

    @Override
    public boolean isWifi() {
        return Utils.isWifi(mContext);
    }

    public void fullScreen() {
        if(getActivity()!=null){
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            isFullScreen = true;
        }
    }

    public void quitFullScreen(){
        Activity activity = getActivity();
        if(activity!=null){
            final WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
            attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            activity.getWindow().setAttributes(attrs);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            isFullScreen = false;
        }
    }

    protected boolean isFullScreen(){
        return isFullScreen;
    }

    public void keepScreenOn(){
        if(getActivity()!=null){
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    @Override
    public void closeKeyCode(Context ct) {
        View view = ((Activity) ct).getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputManger = (InputMethodManager) ct.getSystemService(INPUT_METHOD_SERVICE);
            inputManger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void unRegisterNetChangeReceiver(){
        try{
            if(mNetChangeReceiver !=null && getActivity()!=null){
                getActivity().unregisterReceiver(mNetChangeReceiver);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unRegisterNetChangeReceiver();
    }

}
