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

package com.kk.taurus.uiframe.d;

/**
 * Created by Taurus on 2017/9/30.
 */

public class BaseState {

    public static final int STATE_SUCCESS = 1 << 1;
    public static final int STATE_LOADING = 1 << 2;
    public static final int STATE_ERROR = 1 << 3;

    private int stateCode = STATE_SUCCESS;
    private int resId;
    private String text;

    public static final BaseState SUCCESS = new BaseState(STATE_SUCCESS);
    public static final BaseState LOADING = new BaseState(STATE_LOADING);
    public static final BaseState ERROR = new BaseState(STATE_ERROR);

    public BaseState() {
    }

    public BaseState(int stateCode) {
        this.stateCode = stateCode;
    }

    public BaseState(int stateCode, String text) {
        this.stateCode = stateCode;
        this.text = text;
    }

    public BaseState(int stateCode, int resId, String text) {
        this.stateCode = stateCode;
        this.resId = resId;
        this.text = text;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
