package com.kk.taurus.uiframe.i;

import com.kk.taurus.uiframe.v.BaseErrorHolder;
import com.kk.taurus.uiframe.v.BaseLoadingHolder;
import com.kk.taurus.uiframe.v.BaseTitleBarHolder;
import com.kk.taurus.uiframe.v.ContentHolder;

/**
 * Created by Taurus on 2017/9/30.
 */

public interface IUserHolder {

    BaseTitleBarHolder onBindTitleBarHolder();

    ContentHolder onBindContentHolder();

    BaseLoadingHolder onBindLoadingHolder();

    BaseErrorHolder onBindErrorHolder();

}
