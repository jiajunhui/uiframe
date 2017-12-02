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

/**
 * Created by mtime on 2017/11/22.
 */

public interface HolderLifeCycle {

    int LIFE_CYCLE_ON_RESTART = 2;
    int LIFE_CYCLE_ON_START = 4;
    int LIFE_CYCLE_ON_RESUME = 6;
    int LIFE_CYCLE_ON_PAUSE = 8;
    int LIFE_CYCLE_ON_STOP = 10;
    int LIFE_CYCLE_ON_DESTROY = 12;

    void onRestart();
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();

}
