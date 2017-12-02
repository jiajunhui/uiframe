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

package com.kk.taurus.uiframe.a;

import android.os.Bundle;
import android.view.View;

import com.kk.taurus.uiframe.i.HolderData;
import com.kk.taurus.uiframe.v.BaseStateContainer;
import com.kk.taurus.uiframe.v.BaseTitleBarHolder;
import com.kk.taurus.uiframe.v.BaseUserHolder;
import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframe.v.NormalTitleBarContainer;
import com.kk.taurus.uiframe.v.d.DefaultTitleBarHolder;

/**
 * Created by Taurus on 2017/10/1.
 */

public abstract class TitleBarActivity<T extends HolderData, H extends ContentHolder<T>> extends StateActivity<T, H> {

    @Override
    protected BaseStateContainer getStateContainer() {
        return new NormalTitleBarContainer(this,this,this);
    }

    @Override
    public BaseTitleBarHolder onBindTitleBarHolder() {
        return new DefaultTitleBarHolder(this,this);
    }

    @Override
    public void onHolderEvent(int eventCode, Bundle bundle) {
        super.onHolderEvent(eventCode, bundle);
        switch (eventCode){
            case DefaultTitleBarHolder.DEFAULT_TITLE_BAR_EVENT_BACK_ICON_CLICK:
                onFinish();
                break;
        }
    }

    protected void setTitleBarVisibleState(boolean visible){
        BaseUserHolder userHolder = getUserHolder();
        if(userHolder!=null && userHolder.titleBarHolder!=null){
            userHolder.titleBarHolder.setVisibility(visible? View.VISIBLE:View.GONE);
        }
    }

    protected boolean isTitleBarVisible(){
        BaseUserHolder userHolder = getUserHolder();
        if(userHolder!=null && userHolder.titleBarHolder!=null){
            return userHolder.titleBarHolder.getVisibility()==View.VISIBLE;
        }
        return false;
    }

}
