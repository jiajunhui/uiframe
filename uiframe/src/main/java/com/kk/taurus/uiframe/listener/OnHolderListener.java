package com.kk.taurus.uiframe.listener;

import android.os.Bundle;

/**
 * Created by Taurus on 2017/9/30.
 */

public interface OnHolderListener {

    /**
     * when holder event occur,callback this method,include bundle data.
     * @param eventCode
     * @param bundle
     */
    void onHolderEvent(int eventCode, Bundle bundle);

}
