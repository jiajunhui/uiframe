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

package com.kk.taurus.uiframe.manager;

import com.kk.taurus.uiframe.i.HolderLifeCycle;
import com.kk.taurus.uiframe.v.BaseHolder;

import java.util.List;

/**
 * Created by mtime on 2017/11/22.
 */

public class HolderPoolCallbackHandler {

    private List<BaseHolder> mHolderPool;

    public HolderPoolCallbackHandler(List<BaseHolder> holderPool){
        this.mHolderPool = holderPool;
    }

    public void handleCallback(int lifeCycleType){
        if(mHolderPool==null || mHolderPool.size()<=0){
            return;
        }
        for(BaseHolder holder : mHolderPool){
            if(holder instanceof HolderLifeCycle){
                callBack((HolderLifeCycle) holder,lifeCycleType);
            }
        }

    }

    private void callBack(HolderLifeCycle holder, int lifeCycleType){
        switch (lifeCycleType){
            case HolderLifeCycle.LIFE_CYCLE_ON_RESTART:
                holder.onRestart();
                break;
            case HolderLifeCycle.LIFE_CYCLE_ON_START:
                holder.onStart();
                break;
            case HolderLifeCycle.LIFE_CYCLE_ON_RESUME:
                holder.onResume();
                break;
            case HolderLifeCycle.LIFE_CYCLE_ON_PAUSE:
                holder.onPause();
                break;
            case HolderLifeCycle.LIFE_CYCLE_ON_STOP:
                holder.onStop();
                break;
            case HolderLifeCycle.LIFE_CYCLE_ON_DESTROY:
                holder.onDestroy();
                break;
        }
    }

}
