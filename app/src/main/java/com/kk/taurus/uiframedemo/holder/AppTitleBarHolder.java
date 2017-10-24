package com.kk.taurus.uiframedemo.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.kk.taurus.uiframe.d.BaseTitleBarParams;
import com.kk.taurus.uiframe.i.ITitleBar;
import com.kk.taurus.uiframe.listener.OnHolderListener;
import com.kk.taurus.uiframe.v.BaseTitleBarHolder;
import com.kk.taurus.uiframedemo.R;

/**
 * Created by Taurus on 2017/10/1.
 */

public class AppTitleBarHolder extends BaseTitleBarHolder implements ITitleBar {

    private TextView mTitle;

    public AppTitleBarHolder(Context context) {
        super(context);
    }

    public AppTitleBarHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

    @Override
    public void onCreate() {
        setContentView(R.layout.layout_title_bar);

        mTitle = getViewById(R.id.title);

        getViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnHolderListener.onHolderEvent(TITLE_BAR_EVENT_NAVIGATION_CLICK,null);
            }
        });
    }

    @Override
    public void setTitleBarBackgroundColor(int color) {

    }

    @Override
    public void setNavigationVisibility(int visibility) {

    }

    @Override
    public void setNavigationIcon(int resId) {

    }

    @Override
    public void setTitle(CharSequence charSequence) {
        mTitle.setText(charSequence);
    }

    @Override
    public void setSubTitle(CharSequence charSequence) {

    }

    @Override
    public BaseTitleBarParams getTitleBarParams() {
        BaseTitleBarParams params = new BaseTitleBarParams();
        params.titleBarHeight = 180;
        return params;
    }
}
