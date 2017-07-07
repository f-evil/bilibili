package com.fyj.mainscreen;

import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.chenenyu.router.annotation.Route;
import com.fyj.appcontroller.base.BaseObjectBean;
import com.fyj.appcontroller.exception.NullDataException;
import com.fyj.appcontroller.global.GlobalVar;
import com.fyj.appcontroller.global.HttpInterface;
import com.fyj.easylinkingutils.utils.EToastUtils;
import com.fyj.elinksdk.baseview.BaseAppCompatActivity;
import com.fyj.mainscreen.entity.RecommendMainBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

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
        getTJ();
    }

    @Override
    protected void initCustomFunction() {

    }

    @Override
    protected void bindEvent() {

    }

    private void getTJ() {
        OkHttpUtils
                .get()
                .url(HttpInterface.Document.SHOW_OLD)
                .addParams("platform", GlobalVar.PHONE_PLATFORM)
                .addParams("device", "")
                .addParams("build", "")
                .build()
                .execute(new Callback<BaseObjectBean<List<RecommendMainBean>>>() {

                    @Override
                    public BaseObjectBean<List<RecommendMainBean>> parseNetworkResponse(Response response, int id) throws Exception {
                        BaseObjectBean<List<RecommendMainBean>> o
                                = JSONObject.parseObject(
                                response.body().string(),
                                new TypeReference<BaseObjectBean<List<RecommendMainBean>>>() {
                                }.getType());
                        if (o.getCode() == 0) {
                            return o;
                        }
                        throw new NullDataException("数据请求失败");
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        EToastUtils.makeText(e.getMessage());
                    }

                    @Override
                    public void onResponse(BaseObjectBean<List<RecommendMainBean>> response, int id) {

                    }
                });
    }
}
