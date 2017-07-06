package com.fyj.elinksdk.baseview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyj.easylinkingutils.utils.EToastUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 当前作者: Fyj<br>
 * 时间: 2016/8/24<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述: 懒加载Fragemnt
 */
public abstract class BaseLazyAppFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();

    private ViewGroup mContainer;
    private FragmentActivity activity;

    private View mCurrentView;
    private Unbinder unbinder;

    private boolean mIsInit = false;
    private boolean mIsLoad = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mContainer = container;
        mCurrentView = inflater.inflate(setLayout(), container, false);
        unbinder = ButterKnife.bind(this, mCurrentView);
        return mCurrentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIsInit = true;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && mIsInit && !mIsLoad) {
            mIsLoad = true;
            onVisible();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destoryPre();
        unbinder.unbind();
        EToastUtils.destory();

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }

    /**
     * 可见的时候调用
     */
    protected void onVisible() {
        initDate();
        getDate();
        initBroadCast();
        bindEvent();
    }

    /**
     * 设置layout
     *
     * @return layout
     */
    protected abstract int setLayout();

    /**
     * 消除层实例
     */
    protected abstract void destoryPre();

    /**
     * 初始化数据
     */
    protected abstract void initDate();

    /**
     * 获取数据
     */
    protected abstract void getDate();

    /**
     * 初始化广播
     */
    protected abstract void initBroadCast();

    /**
     * 绑定事件
     */
    protected abstract void bindEvent();

    private View getCurrentView() {
        return mCurrentView;
    }

    public FragmentActivity getSupportActivity() {

        return super.getActivity();
    }

    public ViewGroup getContainer() {
        return mContainer;
    }
}
