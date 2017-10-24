package com.kk.taurus.uiframe.i;

import com.kk.taurus.uiframe.d.BaseState;
import com.kk.taurus.uiframe.v.BaseUserHolder;

/**
 * Created by Taurus on 2017/9/30.
 */

public interface IStateContainer {

    void setState(BaseState state);

    BaseUserHolder getUserHolder();

}
