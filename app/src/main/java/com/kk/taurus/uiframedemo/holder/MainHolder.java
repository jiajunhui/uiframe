package com.kk.taurus.uiframedemo.holder;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.kk.taurus.uiframe.v.ContentHolder;
import com.kk.taurus.uiframedemo.R;
import com.kk.taurus.uiframedemo.entity.MainData;

/**
 * Created by Taurus on 2017/10/8.
 */

public class MainHolder extends ContentHolder<MainData> {

    private OnMainHolderListener onMainHolderListener;

    public void setOnMainHolderListener(OnMainHolderListener onMainHolderListener) {
        this.onMainHolderListener = onMainHolderListener;
    }

    public MainHolder(Context context) {
        super(context);
    }

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_main);

        getViewById(R.id.btn_no_title_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onMainHolderListener!=null){
                    onMainHolderListener.onIntentToNoTitleBarPage();
                }
            }
        });
    }

    @Override
    public void onDataChanged(MainData data) {
        super.onDataChanged(data);
        Toast.makeText(mContext, data.text, Toast.LENGTH_SHORT).show();
    }

    public interface OnMainHolderListener{
        void onIntentToNoTitleBarPage();
    }

}
