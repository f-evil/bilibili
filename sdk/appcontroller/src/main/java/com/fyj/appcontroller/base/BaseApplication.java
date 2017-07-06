package com.fyj.appcontroller.base;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;

import com.chenenyu.router.Router;
import com.fyj.appcontroller.BuildConfig;
import com.fyj.appcontroller.global.GlobalVar;
import com.fyj.appcontroller.global.NBCachePath;
import com.fyj.easylinkingutils.utils.ELog;
import com.fyj.easylinkingutils.utils.EToastUtils;
import com.fyj.easylinkingutils.utils.SPUtils;
import com.fyj.easylinkingutils.utils.ScreenUtils;
import com.fyj.elinksdk.view.swipbackview.SwipApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * 当前作者: Fyj<br>
 * 时间: 2017/5/15<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述:
 */

public class BaseApplication extends SwipApplication {

    private static final String EMOTION_KEYBOARD = "EmotionKeyboard";
    private static final String SOFT_INPUT_HEIGHT = "soft_input_height";

    private static SoftReference<Context> fbContext;

    @Override
    public void onCreate() {
        super.onCreate();
        initSoftReference();
        initCrashView();
        initRetrofit();
        initOkHttp();
        initCachePath();
        initImageHelper();
        initToastUtils();
        initDBManager();
        initLogUtils();
        initKeyBoard();
        initRouter();
        initZxing();
    }

    /**
     * 二维码扫描生成
     */
    private void initZxing() {
        ZXingLibrary.initDisplayOpinion(this);
    }

    /**
     * 路由配置
     */
    private void initRouter() {
        Router.initialize(this, true);
    }


    /**
     * Crach捕获配置
     */
    private void initCrashView() {
//        CrashHandler.getInstance().init(this, this.getPackageName());
    }


    /**
     * 网络配置
     */
    private void initRetrofit() {
        GlobalVar.toggleSvrAddrType(BuildConfig.APP_SERVICE_DEBUG ? GlobalVar.SvrAddrType.DEVELOP : GlobalVar.SvrAddrType.RELEASE);
    }


    /**
     * 初始化网络
     */
    private void initOkHttp() {
        try {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                    .readTimeout(10000L, TimeUnit.MILLISECONDS)
                    .addInterceptor(new LoggerInterceptor("BiliBili", true))
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    })
                    .build();
            OkHttpUtils.initClient(okHttpClient);

        } catch (Exception e) {
            ELog.e("BiliBili", "initOKHttp", e);
        }
    }


    /**
     * 目录初始
     */
    private void initCachePath() {
        NBCachePath.initDirName("BiliBili");
    }


    /**
     * 键盘初始
     */
    private void initKeyBoard() {
        int height = (int) (ScreenUtils.getScreenHeight(this) * 0.4333);
        SPUtils.putInt(this, EMOTION_KEYBOARD, SOFT_INPUT_HEIGHT, height);
    }


    /**
     * 初始化Log工具类
     * 自动判断打包模式
     * 打开/关闭Log
     */
    private void initLogUtils() {
        if (BuildConfig.APP_SERVICE_DEBUG) {
            ELog.openLog();
        } else {
            ELog.closeLog();
        }
    }

    /**
     * 初始化数据库操作类
     */
    private void initDBManager() {

    }

    /**
     * 初始化吐司工具类
     */
    private void initToastUtils() {
        EToastUtils.init(getAppContext().get());
    }

    /**
     * 初始化图片加载框架
     */
    private void initImageHelper() {

    }

    /**
     * 获得strings.xml中的值
     *
     * @param id id
     * @return string
     */
    public static String readString(int id) {
        return getAppContext().get().getString(id);
    }

    /**
     * 获得资源类
     *
     * @return res
     */
    public static Resources getResourse() {
        return getAppContext().get().getResources();
    }


    /**
     * 软引用配置
     */
    private void initSoftReference() {
        fbContext = new SoftReference<Context>(this);
        GlobalVar.notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }


    /**
     * 获得引用
     *
     * @return cont
     */
    public static SoftReference<Context> getAppContext() {
        return fbContext;
    }
}
