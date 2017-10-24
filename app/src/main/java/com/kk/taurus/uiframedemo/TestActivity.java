package com.kk.taurus.uiframedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kk.taurus.uiframe.a.StateActivity;
import com.kk.taurus.uiframe.v.BaseErrorHolder;
import com.kk.taurus.uiframe.v.BaseLoadingHolder;
import com.kk.taurus.uiframe.v.ContentHolder;

/**
 * Created by Taurus on 2017/10/9.
 */

public class TestActivity extends StateActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    public ContentHolder onBindContentHolder() {
        return null;
    }

    @Override
    public BaseLoadingHolder onBindLoadingHolder() {
        return null;
    }

    @Override
    public BaseErrorHolder onBindErrorHolder() {
        return null;
    }
}
