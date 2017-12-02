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

package com.kk.taurus.uiframedemo.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.kk.taurus.uiframe.d.BaseTitleBarParams;
import com.kk.taurus.uiframe.i.ITitleBar;
import com.kk.taurus.uiframe.listener.OnHolderListener;
import com.kk.taurus.uiframe.u.Utils;
import com.kk.taurus.uiframe.v.BaseTitleBarHolder;
import com.kk.taurus.uiframedemo.R;

/**
 * Created by Taurus on 2017/11/10.
 */

public class DemoTitleBarHolder extends BaseTitleBarHolder {

    private TextView mTitle;

    public DemoTitleBarHolder(Context context) {
        super(context);
    }

    public DemoTitleBarHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

    @Override
    public BaseTitleBarParams getTitleBarParams() {
        BaseTitleBarParams params = new BaseTitleBarParams();
        params.titleBarHeight = Utils.dip2px(mContext,50);
        return params;
    }

    @Override
    public void onCreate() {
        setContentView(R.layout.layout_demo_title_bar);

        mTitle = getViewById(R.id.title);
        getViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getHolderListener()!=null){
                    getHolderListener().onHolderEvent(ITitleBar.TITLE_BAR_EVENT_NAVIGATION_CLICK,null);
                }
            }
        });

    }

    public void setTitle(CharSequence title){
        mTitle.setText(title);
    }

}
