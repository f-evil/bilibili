package com.fyj.appcontroller.router;

import android.content.Context;
import android.os.Bundle;

/**
 * 当前作者: Fyj<br>
 * 时间: 2017/5/23<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述:
 */

public class RouterService extends BaseRouterService {


    public static void goToMainScreenActivity(Context context, Bundle bundle) {
        goToActivity(context, "MainScreen", bundle);
    }
}
