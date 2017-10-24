package com.kk.taurus.uiframe.a;

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

/**
 * Created by Taurus on 2017/9/30.
 */

public abstract class ToolsActivity extends FilterActivity implements IToolsInterface, OnNetChangeListener {

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
            registerReceiver(mNetChangeReceiver,intentFilter);
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
        return Utils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public boolean isWifi() {
        return Utils.isWifi(getApplicationContext());
    }

    public void fullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        isFullScreen = true;
    }

    public void quitFullScreen(){
        final WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setAttributes(attrs);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        isFullScreen = false;
    }

    protected boolean isFullScreen(){
        return isFullScreen;
    }

    public void keepScreenOn(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
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
            if(mNetChangeReceiver !=null){
                unregisterReceiver(mNetChangeReceiver);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterNetChangeReceiver();
    }

}
