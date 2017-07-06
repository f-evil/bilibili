package com.fyj.mainscreen;

import android.widget.TextView;

import com.chenenyu.router.annotation.Route;
import com.fyj.elinksdk.baseview.BaseAppCompatActivity;

import butterknife.BindView;

@Route("MainScreen")
public class MainActivity extends BaseAppCompatActivity {

    @BindView(R2.id.tvss)
    TextView mTvss;

    @Override
    protected int setLayout() {
        return R.layout.main_activity_main;
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

    }

    @Override
    protected void bindEvent() {

    }
}
