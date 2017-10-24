package com.kk.taurus.uiframedemo;

import android.os.Bundle;

import com.kk.taurus.uiframe.a.StateActivity;
import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.v.BaseErrorHolder;
import com.kk.taurus.uiframe.v.BaseLoadingHolder;
import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframedemo.entity.NoTitleBarData;
import com.kk.taurus.uiframedemo.holder.ErrorHolder;
import com.kk.taurus.uiframedemo.holder.LoadingHolder;
import com.kk.taurus.uiframedemo.holder.NoTitleBarHolder;

/**
 * Created by Taurus on 2017/10/9.
 */

public class NoTitleBarActivity extends StateActivity<NoTitleBarData,NoTitleBarHolder> implements NoTitleBarHolder.OnNoTitleBarHolderListener {

    @Override
    protected void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        setPageState(BaseState.LOADING);
        mRootView.postDelayed(new Runnable() {
            @Override
            public void run() {
                setPageState(BaseState.SUCCESS);
            }
        }, 2000);
        getUserContentHolder().setOnNoTitleBarHolderListener(this);
    }

    @Override
    public ContentHolder onBindContentHolder() {
        return new NoTitleBarHolder(this);
    }

    @Override
    public BaseLoadingHolder onBindLoadingHolder() {
        return new LoadingHolder(this,this);
    }

    @Override
    public BaseErrorHolder onBindErrorHolder() {
        return new ErrorHolder(this,this);
    }

    @Override
    public void showLoading() {
        setPageState(BaseState.LOADING);
        mRootView.postDelayed(new Runnable() {
            @Override
            public void run() {
                setPageState(BaseState.SUCCESS);
            }
        }, 2000);
    }
}
