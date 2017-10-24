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

import android.content.Context;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.d.BaseTitleBarParams;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public abstract class BaseTitleBarHolder extends BaseHolder {

    protected BaseState mState;

    public BaseTitleBarHolder(Context context) {
        super(context);
    }

    public BaseTitleBarHolder(Context context, OnHolderListener onHolderListener) {
        super(context, onHolderListener);
    }

    public void setState(BaseState state){
        this.mState = state;
    }

    public abstract BaseTitleBarParams getTitleBarParams();

}
