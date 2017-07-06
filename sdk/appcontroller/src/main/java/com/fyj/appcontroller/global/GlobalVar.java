package com.fyj.appcontroller.global;

import android.app.NotificationManager;

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
     * 提醒管理类
     */
    public static NotificationManager notifyManager;

    /**
     * socket是否能连接
     */
    public static boolean isScoketCanConnect = true;
    /**
     * Socket连接状态
     */
    public static String SocketStat = "";
    /**
     * socket连接(yes/no)
     */
    public static boolean sockect_conn = false;
    /**
     * 登录状态
     */
    public static boolean login_stat = false;
    /**
     * 是否提示音
     */
    public static boolean isTipRun = false;
    /**
     * 是否是在聊天界面
     */
    public static boolean isChatView = false;


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
    public static String SOCKET_HOST;
    public static int SOCKET_PORT;
    public static String PIC_HOST;

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
                HOST = HttpConstant.Host.NB_ENTERPRISE_GOV_CN;
                PORT = HttpConstant.Post.P_8888;
                SOCKET_HOST = HttpConstant.Host.NB_ENTERPRISE_GOV_CN;
                SOCKET_PORT = HttpConstant.Post.P_10001;
                PIC_HOST = "http://qyfw.87188718.com/upload/app/";
                break;
            case DEVELOP:
                HOST = HttpConstant.Host.NB_ENTERPRISE_GOV_CN;
                PORT = HttpConstant.Post.P_8888;
                SOCKET_HOST = HttpConstant.Host.NB_ENTERPRISE_GOV_CN;
                SOCKET_PORT = HttpConstant.Post.P_10001;
                PIC_HOST = "http://qyfw.87188718.com/upload/app/";

                break;
            case RELEASE:
                HOST = HttpConstant.Host.NB_ENTERPRISE_GOV_CN;
                PORT = HttpConstant.Post.P_8888;
                SOCKET_HOST = HttpConstant.Host.NB_ENTERPRISE_GOV_CN;
                SOCKET_PORT = HttpConstant.Post.P_10001;
                PIC_HOST = "http://qyfw.87188718.com/upload/app/";

                break;
        }
    }


}
