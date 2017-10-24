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

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by Taurus on 2017/1/17.
 */

public interface IContentHolder {
    void onHolderCreated(Bundle savedInstanceState);
    Intent getIntent();
    void onNewIntent(Intent intent);
    void onRestart();
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
    void finish();
    void onConfigurationChanged(Configuration newConfig);
    void onSaveInstanceState(Bundle outState);
//    LoadingStateHolder getLoadingStateHolder();
//    ErrorStateHolder getErrorStateHolder();
//    ErrorNetWorkStateHolder getErrorNetWorkStateHolder();
}
