package com.kk.taurus.uiframedemo.holder;

import android.content.Context;
import android.view.View;

import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframedemo.R;
import com.kk.taurus.uiframedemo.entity.NoTitleBarData;

/**
 * Created by Taurus on 2017/10/9.
 */

public class NoTitleBarHolder extends ContentHolder<NoTitleBarData> {

    private OnNoTitleBarHolderListener onNoTitleBarHolderListener;

    public void setOnNoTitleBarHolderListener(OnNoTitleBarHolderListener onNoTitleBarHolderListener) {
        this.onNoTitleBarHolderListener = onNoTitleBarHolderListener;
    }

    public NoTitleBarHolder(Context context) {
        super(context);
    }

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_no_title_bar);

        getViewById(R.id.btn_show_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onNoTitleBarHolderListener!=null){
                    onNoTitleBarHolderListener.showLoading();
                }
            }
        });
    }

    public interface OnNoTitleBarHolderListener{
        void showLoading();
    }

}
