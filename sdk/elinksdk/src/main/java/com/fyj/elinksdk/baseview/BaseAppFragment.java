package com.fyj.elinksdk.baseview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyj.easylinkingutils.utils.ELog;
import com.fyj.easylinkingutils.utils.EToastUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 当前作者: Fyj<br>
 * 时间: 2016/8/24<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述: 基类Fragmnet
 */
public abstract class BaseAppFragment extends Fragment {

    /**
     * TAG
     */
    private String TAG = this.getClass().getName();
//    private String TAG = this.getClass().getSimpleName();

    /**
     * container
     */
    private ViewGroup mContainer;
    /**
     * 父类
     */
    private FragmentActivity activity;

    /**
     * currentview
     */
    private View mCurrentView;
    /**
     * 试图绑定
     */
    private Unbinder unbinder;

    /**
     * 异常储存
     */
    private Bundle msavedInstanceState;

    /**
     * 当前团
     */
    private String CurGroupId = "";

    /**
     * 广播
     */
    private LocalBroadcastManager mLBM;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mContainer = container;
        mCurrentView = inflater.inflate(setLayout(), container, false);
        mLBM = LocalBroadcastManager.getInstance(getActivity());
        unbinder = ButterKnife.bind(this, mCurrentView);
        msavedInstanceState = savedInstanceState;
        initDate();
        getDate();
        initCustomer();
        initlocalReceiver();
        initBroadCast();
        bindEvent();
        mCurrentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mCurrentView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK && onBackPressed();
            }
        });
        return mCurrentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ELog.e("Showing Fragment Name:", TAG);
        if (getView() != null) {
            getView().setFocusableInTouchMode(true);
            getView().requestFocus();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ELog.e("onDestroy Fragment Name:", TAG);
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
     * 其他函数
     */
    protected abstract void initCustomer();

    /**
     * 初始化广播
     */
    protected abstract void initBroadCast();

    /**
     * 绑定事件
     */
    protected abstract void bindEvent();

    /**
     * 获取当前 view
     *
     * @return view
     */
    protected View getCurrentView() {
        return mCurrentView;
    }

    /**
     * 父类
     *
     * @return 父类
     */
    public FragmentActivity getSupportActivity() {

        return super.getActivity();
    }

    /**
     * container
     *
     * @return viewgroup
     */
    public ViewGroup getContainer() {
        return mContainer;
    }

    /**
     * 异常
     *
     * @return bundle
     */
    public Bundle getSavedInstanceState() {
        return msavedInstanceState;
    }

    /**
     * 监听返回按钮
     *
     * @return 当true的时候会拦截返回事件，false不会拦截
     */
    public boolean onBackPressed() {
        return false;
    }

    /**
     * 设置当前GroupID
     *
     * @param groupId GroupID
     */
    protected void setCurGroupId(String groupId) {
        this.CurGroupId = groupId;
    }

    /**
     * 获取广播发送器
     */
    protected LocalBroadcastManager getLBM() {
        if (mLBM == null) {
            mLBM = LocalBroadcastManager.getInstance(getActivity());
        }
        return mLBM;
    }

    /**
     * 基础的广播
     */
    protected void initlocalReceiver() {


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        handleResult(this, requestCode, resultCode, data);
    }

    private void handleResult(Fragment frag, int requestCode, int resultCode, Intent data) {
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null) {
                    f.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }
}
