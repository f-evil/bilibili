package com.fyj.elinksdk.baseview;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.fyj.easylinkingutils.utils.ELog;
import com.fyj.easylinkingutils.utils.EToastUtils;
import com.fyj.elinksdk.view.swipbackview.SwipeWindowHelper;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 当前作者: Fyj<br>
 * 时间: 2016/8/24<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述: 基类Activity
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    /**
     * TAG
     */
    protected String TAG = this.getClass().getName();
    //    private String TAG = this.getClass().getSimpleName();

    /**
     * ui绑定
     */
    private Unbinder unBinder;

    /**
     * 滑动关闭工具类
     */
    private SwipeWindowHelper mSwipeWindowHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(setLayout());
        unBinder = ButterKnife.bind(this);
        initDate();
        initView();
        getDate();
        initCustomFunction();
        bindEvent();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ELog.eLine();
        ELog.e("Showing Activity Name:", TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destoryPre();
        unBinder.unbind();
        EToastUtils.destory();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                v.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        if (!supportSlideBack()) {
            return super.dispatchTouchEvent(ev);
        }
        if (mSwipeWindowHelper == null) {
            mSwipeWindowHelper = new SwipeWindowHelper(getWindow());
        }
        return mSwipeWindowHelper.processTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }

    /**
     * 是否隐藏键盘
     *
     * @param v     view
     * @param event 时间
     * @return 是否
     */
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

    /**
     * 是否可滑动
     *
     * @return 是不是
     */
    protected boolean supportSlideBack() {
        return false;
    }

    /**
     * 设置layout
     *
     * @return layout
     */
    protected abstract int setLayout();

    /**
     * 销毁p层实例
     */
    protected abstract void destoryPre();

    /**
     * 初始化数据
     */
    protected abstract void initDate();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 获得数据
     */
    protected abstract void getDate();

    /**
     * 其他函数
     */
    protected abstract void initCustomFunction();

    /**
     * 绑定事件
     */
    protected abstract void bindEvent();

    /**
     * 获取activity
     *
     * @return activity
     */
    protected Activity getActivity() {
        return this;
    }
}
