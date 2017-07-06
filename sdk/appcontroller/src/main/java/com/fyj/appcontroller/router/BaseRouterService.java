package com.fyj.appcontroller.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.chenenyu.router.IRouter;
import com.chenenyu.router.Router;
import com.fyj.easylinkingutils.utils.StringUtil;

/**
 * 当前作者: Fyj<br>
 * 时间: 2017/5/23<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述:
 */

public class BaseRouterService {

    public static void goToActivity(Context context, String path, Bundle bundle) {
        goToActivityForResult(context, path, bundle, Activity.RESULT_OK);
    }

    public static void goToActivity(Context context, Uri path, Bundle bundle) {
        goToActivityForResult(context, path, bundle, Activity.RESULT_OK);
    }

    public static void goToActivityForResult(Context context, String path, Bundle bundle, int requestCode) {
        if (context == null) {
            return;
        }

        if (StringUtil.isEmpty(path)) {
            return;
        }

        IRouter build = Router.build(path).requestCode(requestCode);
        if (bundle != null) {
            build.with(bundle);
        }
        build.go(context);
    }

    public static void goToActivityForResult(Context context, Uri path, Bundle bundle, int requestCode) {
        if (context == null) {
            return;
        }

        IRouter build = Router.build(path).requestCode(requestCode);
        if (bundle != null) {
            build.with(bundle);
        }
        build.go(context);
    }

}
