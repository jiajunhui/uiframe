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

import com.kk.taurus.uiframe.i.HolderData;
import com.kk.taurus.uiframe.v.BaseStateContainer;
import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframe.v.NormalTitleBarContainer;

/**
 * Created by Taurus on 2017/10/1.
 */

public abstract class TitleBarActivity<T extends HolderData, H extends ContentHolder<T>> extends StateActivity<T, H> {

    @Override
    protected BaseStateContainer getStateContainer() {
        return new NormalTitleBarContainer(this,this,this);
    }

}
