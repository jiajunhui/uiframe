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

package com.kk.taurus.uiframe.listener;

import android.os.Bundle;

/**
 * Created by Taurus on 2017/9/30.
 */

public interface OnHolderListener{

    String KEY_INT_DATA = "int_data";
    String KEY_LONG_DATA = "long_data";
    String KEY_STRING_DATA = "string_data";
    String KEY_BOOLEAN_DATA = "boolean_data";
    String KEY_SERIALIZABLE_DATA = "serializable_data";

    /**
     * when holder event occur,callback this method,include bundle data.
     * @param eventCode
     * @param bundle
     */
    void onHolderEvent(int eventCode, Bundle bundle);

}
