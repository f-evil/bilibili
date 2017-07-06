package com.fyj.bilibili.ui.activity;

import android.content.Intent;

import com.fyj.bilibili.R;
import com.fyj.elinksdk.baseview.BaseAppCompatActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class SplashActivity extends BaseAppCompatActivity {

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void destoryPre() {

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getDate() {

    }

    @Override
    protected void initCustomFunction() {
        Observable.timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        finish();
                    }
                });
    }

    @Override
    protected void bindEvent() {

    }

}
