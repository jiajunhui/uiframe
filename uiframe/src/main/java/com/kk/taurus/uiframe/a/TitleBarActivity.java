package com.kk.taurus.uiframe.a;

import com.kk.taurus.uiframe.i.HolderData;
import com.kk.taurus.uiframe.v.BaseStateContainer;
import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframe.v.NormalTitleBarContainer;

/**
 * Created by Taurus on 2017/10/1.
 */

public abstract class TitleBarActivity<T extends HolderData, H extends ContentHolder<T>> extends StateActivity<T, H> {

    @Override
    protected BaseStateContainer getStateContainer() {
        return new NormalTitleBarContainer(this,this,this);
    }

}
