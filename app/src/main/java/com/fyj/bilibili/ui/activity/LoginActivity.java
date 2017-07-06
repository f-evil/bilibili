package com.fyj.bilibili.ui.activity;

import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyj.appcontroller.router.RouterService;
import com.fyj.bilibili.R;
import com.fyj.bilibili.R2;
import com.fyj.elinksdk.baseview.BaseAppCompatActivity;

import butterknife.BindView;

//Activity.recreate();
public class LoginActivity extends BaseAppCompatActivity {

    @BindView(R2.id.toolbar)
    Toolbar mToolbar;
    @BindView(R2.id.iv_icon_left)
    ImageView mIvIconLeft;
    @BindView(R2.id.iv_icon_right)
    ImageView mIvIconRight;
    @BindView(R2.id.et_phone)
    EditText mEtPhone;
    @BindView(R2.id.iv_account_clean)
    ImageView mIvAccountClean;
    @BindView(R2.id.et_pw)
    EditText mEtPw;
    @BindView(R2.id.iv_pw_clean)
    ImageView mIvPwClean;
    @BindView(R2.id.tv_login)
    TextView mTvLogin;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void destoryPre() {

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {

        mToolbar.setTitle("登录");

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void getDate() {

    }

    @Override
    protected void initCustomFunction() {

    }

    @Override
    protected void bindEvent() {
        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                if (length == 0) {
                    mIvAccountClean.setVisibility(View.GONE);
                } else {
                    mIvAccountClean.setVisibility(View.VISIBLE);
                }
            }
        });

        mIvAccountClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtPhone.setText("");
            }
        });

        mEtPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                if (length == 0) {
                    mIvPwClean.setVisibility(View.GONE);
                    mIvIconLeft.setImageResource(R.drawable.ic_22);
                    mIvIconRight.setImageResource(R.drawable.ic_33);
                } else {
                    mIvPwClean.setVisibility(View.VISIBLE);
                    mIvIconLeft.setImageResource(R.drawable.ic_22_hide);
                    mIvIconRight.setImageResource(R.drawable.ic_33_hide);
                }
            }
        });

        mIvPwClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtPw.setText("");
            }
        });

        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Router.build("MainScreen").go(getActivity());
                RouterService.goToMainScreenActivity(getActivity(), null);
//                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
