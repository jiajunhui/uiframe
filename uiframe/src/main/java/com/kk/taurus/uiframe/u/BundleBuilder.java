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

package com.kk.taurus.uiframe.u;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Taurus on 2017/11/11.
 */

public class BundleBuilder {

    private Bundle mBundle;

    public BundleBuilder(){
        this(null);
    }

    public BundleBuilder(Bundle bundle){
        if(bundle!=null){
            mBundle = bundle;
        }else{
            mBundle = new Bundle();
        }
    }

    public BundleBuilder putInt(String key, int value){
        mBundle.putInt(key, value);
        return this;
    }

    public BundleBuilder putString(String key, String value){
        mBundle.putString(key, value);
        return this;
    }

    public BundleBuilder putLong(String key, long value){
        mBundle.putLong(key, value);
        return this;
    }

    public BundleBuilder putShort(String key, short value){
        mBundle.putShort(key, value);
        return this;
    }

    public BundleBuilder putFloat(String key, float value){
        mBundle.putFloat(key, value);
        return this;
    }

    public BundleBuilder putDouble(String key, double value){
        mBundle.putDouble(key, value);
        return this;
    }

    public BundleBuilder putSerializable(String key, Serializable value){
        mBundle.putSerializable(key, value);
        return this;
    }

    public BundleBuilder putArrayList(String key , ArrayList<String> value){
        mBundle.putStringArrayList(key,value);
        return this;
    }

    public Bundle build(){
        return mBundle;
    }

}
