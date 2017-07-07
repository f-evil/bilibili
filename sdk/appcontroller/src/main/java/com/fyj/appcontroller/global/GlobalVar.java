package com.fyj.appcontroller.global;

import com.fyj.appcontroller.global.constant.HttpConstant;

/**
 * 当前作者: Fyj<br>
 * 时间: 2016/9/1<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述: 全局变量出存处
 */
public class GlobalVar {

    public static String PHONE_PLATFORM = "android";

    /**
     * DEVELOP: 开发环境
     * TESTING: 测试环境
     * RELEASE: 集成环境
     */
    public enum SvrAddrType {
        DEVELOP,
        TESTING,
        RELEASE
    }

    public static String HOST;
    public static int PORT;

    /**
     * 改变运行环境
     *
     * @param svrType serType
     */
    public static void toggleSvrAddrType(SvrAddrType svrType) {
        toggleSerAddr(svrType);
        HttpInterface.ServiceName.init();
        HttpInterface.Document.init();
    }

    /**
     * 切换运行环境
     *
     * @param svrAddrType 运行环境
     */
    private static void toggleSerAddr(SvrAddrType svrAddrType) {
        switch (svrAddrType) {
            case TESTING:
                HOST = HttpConstant.Host.BIIBILI;
                PORT = HttpConstant.Post.P_80;
                break;
            case DEVELOP:
                HOST = HttpConstant.Host.BIIBILI;
                PORT = HttpConstant.Post.P_80;
                break;
            case RELEASE:
                HOST = HttpConstant.Host.BIIBILI;
                PORT = HttpConstant.Post.P_80;
                break;
        }
    }


}
