package com.kk.taurus.uiframe.v;


import android.content.Context;

import com.kk.taurus.uiframe.i.IUserHolder;
import com.kk.taurus.uiframe.listener.OnHolderListener;

/**
 * Created by Taurus on 2017/9/30.
 */

public class FrameTitleBarContainer extends BaseStateContainer {

    public FrameTitleBarContainer(Context context, IUserHolder userHolder) {
        super(context, userHolder);
    }

    public FrameTitleBarContainer(Context context, IUserHolder mUserHolder, OnHolderListener onHolderListener) {
        super(context, mUserHolder, onHolderListener);
    }

    @Override
    protected void onLayoutLogic() {

    }

}
