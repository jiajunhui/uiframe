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

package com.kk.taurus.uiframe.v.d;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

import com.kk.taurus.uiframe.R;
import com.kk.taurus.uiframe.d.BaseTitleBarParams;
import com.kk.taurus.uiframe.listener.OnHolderListener;
import com.kk.taurus.uiframe.v.BaseTitleBarHolder;

/**
 * Created by Taurus on 2017/12/2.
 */

public class DefaultTitleBarHolder extends BaseTitleBarHolder {

    public static final int DEFAULT_TITLE_BAR_EVENT_BACK_ICON_CLICK = -101;

    private AppCompatImageView mBackIcon;
    private AppCompatImageView mMenuIcon;
    private TextView mTvTitle;

    public DefaultTitleBarHolder(Context context) {
        super(context);
    }

    public DefaultTitleBarHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

    @Override
    public BaseTitleBarParams getTitleBarParams() {
        BaseTitleBarParams params = new BaseTitleBarParams();
        params.titleBarHeight = (int) getDimension(R.dimen.default_title_bar_height);
        return params;
    }

    @Override
    public void onCreate() {
        setContentView(R.layout.layout_default_title_bar);
        mBackIcon = getViewById(R.id.default_title_bar_back_icon);
        mMenuIcon = getViewById(R.id.default_title_bar_menu_icon);

        mTvTitle = getViewById(R.id.default_title_bar_center_title);

        getViewById(R.id.default_title_bar_back_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHolderEvent(DEFAULT_TITLE_BAR_EVENT_BACK_ICON_CLICK,null);
            }
        });
    }

    @Override
    public void setTitle(CharSequence title) {
        mTvTitle.setText(title);
    }

    public void setBackIcon(int resId){
        mBackIcon.setImageResource(resId);
    }

    public void setBackIconVisibility(int visibility){
        mBackIcon.setVisibility(visibility);
    }

    public void setMenuIconVisibility(int visibility){
        mMenuIcon.setVisibility(visibility);
    }

    public void setMenuIcon(int resId){
        mMenuIcon.setImageResource(resId);
    }
}
