package com.kk.taurus.uiframe.d;

/**
 * Created by Taurus on 2017/9/30.
 */

public class BaseState {

    public static final int STATE_SUCCESS = 1 << 1;
    public static final int STATE_LOADING = 1 << 2;
    public static final int STATE_ERROR = 1 << 3;

    private int stateCode = STATE_SUCCESS;
    private int resId;
    private String text;

    public static final BaseState SUCCESS = new BaseState(STATE_SUCCESS);
    public static final BaseState LOADING = new BaseState(STATE_LOADING);
    public static final BaseState ERROR = new BaseState(STATE_ERROR);

    public BaseState() {
    }

    public BaseState(int stateCode) {
        this.stateCode = stateCode;
    }

    public BaseState(int stateCode, String text) {
        this.stateCode = stateCode;
        this.text = text;
    }

    public BaseState(int stateCode, int resId, String text) {
        this.stateCode = stateCode;
        this.resId = resId;
        this.text = text;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
