package com.kk.taurus.uiframe.i;

/**
 * Created by Taurus on 2017/9/30.
 */

public interface ITitleBar {

    int TITLE_BAR_EVENT_NAVIGATION_CLICK = -1001;
    int TITLE_BAR_EVENT_TITLE_CLICK = -1002;

    void setTitleBarBackgroundColor(int color);
    void setNavigationVisibility(int visibility);
    void setNavigationIcon(int resId);
    void setTitle(CharSequence charSequence);
    void setSubTitle(CharSequence charSequence);

}
