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

package com.kk.taurus.uiframe.w;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by Taurus on 2017/12/3.
 */

public class TitleBarMenu extends FrameLayout implements View.OnClickListener{

    public static final int TRIGGER_TYPE_TEXT = 0;
    public static final int TRIGGER_TYPE_ICON = 1;

    private final int DEFAULT_TEXT_SIZE = 16;
    private final int DEFAULT_TEXT_COLOR = Color.WHITE;

    private int mTriggerType = TRIGGER_TYPE_TEXT;

    private AppCompatImageView mTriggerIcon;
    private AppCompatTextView mTriggerText;
    private int mTextSize = DEFAULT_TEXT_SIZE;
    private int mTextColor = DEFAULT_TEXT_COLOR;

    private OnMenuListener onMenuListener;

    public TitleBarMenu(@NonNull Context context) {
        super(context);
    }

    public TitleBarMenu(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnMenuListener(OnMenuListener onMenuListener) {
        this.onMenuListener = onMenuListener;
    }

    public void setTriggerType(int triggerType, LayoutParams layoutParams){
        mTriggerType = triggerType;
        if(layoutParams==null){
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        }
        View targetView = null;
        switch (mTriggerType){
            case TRIGGER_TYPE_TEXT:
                if(mTriggerText == null){
                    mTriggerText = new AppCompatTextView(getContext());
                    mTriggerText.setGravity(Gravity.CENTER);
                    mTriggerText.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTextSize);
                    mTriggerText.setTextColor(mTextColor);
                }
                targetView = mTriggerText;
                break;
            case TRIGGER_TYPE_ICON:
                if(mTriggerIcon == null){
                    mTriggerIcon = new AppCompatImageView(getContext());
                    mTriggerIcon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                }
                targetView = mTriggerIcon;
                break;
        }
        if(targetView!=null){
            removeAllViews();
            targetView.setOnClickListener(this);
            addView(targetView, layoutParams);
        }
    }

    public void setTriggerType(int triggerType){
        setTriggerType(triggerType,null);
    }

    public void setTextSize(int textSize) {
        this.mTextSize = textSize;
        if(mTriggerText!=null){
            mTriggerText.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTextSize);
        }
    }

    public void setTextColor(int textColor) {
        this.mTextColor = textColor;
        if(mTriggerText!=null){
            mTriggerText.setTextColor(mTextColor);
        }
    }

    public void setMenuText(CharSequence text){
        if(mTriggerText!=null){
            mTriggerText.setText(text);
        }
    }

    public AppCompatTextView getMenuTextView(){
        return mTriggerText;
    }

    public AppCompatImageView getMenuIconView(){
        return mTriggerIcon;
    }

    public void setMenuText(int resId){
        if(mTriggerText!=null){
            mTriggerText.setText(resId);
        }
    }

    public void setMenuIcon(int resId){
        if(mTriggerIcon!=null){
            mTriggerIcon.setImageResource(resId);
        }
    }

    public void setMenuIcon(Bitmap bitmap){
        if(mTriggerIcon!=null){
            mTriggerIcon.setImageBitmap(bitmap);
        }
    }

    public void setMenuIcon(Drawable drawable){
        if(mTriggerIcon!=null){
            mTriggerIcon.setImageDrawable(drawable);
        }
    }

    private void setTriggerTextShowState(boolean state){
        if(mTriggerText!=null){
            mTriggerText.setVisibility(state? View.VISIBLE:View.GONE);
        }
    }

    private void setTriggerIconShowState(boolean state){
        if(mTriggerText!=null){
            mTriggerIcon.setVisibility(state? View.VISIBLE:View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if(onMenuListener!=null){
            onMenuListener.onTriggerClick(mTriggerType,v);
        }
    }

    public interface OnMenuListener{
        void onTriggerClick(int triggerType, View view);
    }

}
