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

package com.kk.taurus.uiframe.i;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Taurus on 2017/1/13.
 */

public interface Holder {
    LayoutInflater getLayoutInflater();
    void setContentView(int id);
    void setContentView(View view);
    void onCreate();
    Activity getActivity();
    <T extends View> T getViewById(int id);
    View getHolderView();
}
