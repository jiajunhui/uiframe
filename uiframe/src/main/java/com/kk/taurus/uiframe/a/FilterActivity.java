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

import android.content.Intent;

import com.kk.taurus.uiframe.manager.ActivityFilterManager;

/**
 * Created by Taurus on 2017/9/27.
 */

public abstract class FilterActivity extends AbsActivity {

    @Override
    protected void onNewIntent(Intent intent) {
        ActivityFilterManager.getInstance().onNewIntent(this, intent);
        super.onNewIntent(intent);
    }

    @Override
    public void startActivity(Intent intent) {
        ActivityFilterManager.getInstance().startActivity(this, intent);
        super.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        ActivityFilterManager.getInstance().startActivityForResult(this, intent, requestCode);
        super.startActivityForResult(intent, requestCode);
    }

}
