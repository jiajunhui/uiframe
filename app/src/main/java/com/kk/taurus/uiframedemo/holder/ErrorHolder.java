package com.kk.taurus.uiframedemo.holder;

import android.content.Context;
import android.view.View;

import com.kk.taurus.uiframe.listener.OnHolderListener;
import com.kk.taurus.uiframe.v.BaseErrorHolder;
import com.kk.taurus.uiframedemo.R;

/**
 * Created by Taurus on 2017/10/1.
 */

public class ErrorHolder extends BaseErrorHolder {
    public ErrorHolder(Context context) {
        super(context);
    }

    public ErrorHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

    @Override
    public void onCreate() {
        setContentView(R.layout.layout_error);

        getViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHolderListener().onHolderEvent(BaseErrorHolder.ERROR_EVENT_ON_ERROR_CLICK,null);
            }
        });

    }
}
