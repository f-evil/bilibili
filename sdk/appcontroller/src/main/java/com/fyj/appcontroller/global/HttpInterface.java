package com.fyj.appcontroller.global;


import java.util.Locale;

/**
 * 当前作者: fuyujie<br>
 * 时间: 2016/12/13<br>
 * 邮箱: 279259625@qq.com<br>
 * 修改次数: <br>
 * 描述:<br>全局请求地址存放处<br>请根据头放入对应Action,并在Docment中更新
 */
public class HttpInterface {

    /**
     * http配置
     *
     * @param domain      z
     * @param port        z
     * @param serviceName z
     * @return z
     */
    private static String getPrefixHttp(String domain, int port, String serviceName) {
        return String.format(Locale.CHINA, "http://%s:%d%s", domain, port, serviceName);
    }

    /**
     * https 配置
     *
     * @param domain      z
     * @param port        z
     * @param serviceName z
     * @return z
     */
    private static String getPrefixHttps(String domain, int port, String serviceName) {
        return String.format(Locale.CHINA, "https://%s:%d%s", domain, port, serviceName);
    }

    /**
     * 服务名称集合
     */
    static class ServiceName {
        static String PushServier;
        static String HomeServier;
        static String VersionServier;
        static String CustomerServier;
        static String MessageServier;

        public static void init() {
            PushServier = getPrefixHttp(GlobalVar.HOST, GlobalVar.PORT, "/push/");
            HomeServier = getPrefixHttp(GlobalVar.HOST, GlobalVar.PORT, "/home/");
            VersionServier = getPrefixHttp(GlobalVar.HOST, GlobalVar.PORT, "/version/");
            CustomerServier = getPrefixHttp(GlobalVar.HOST, GlobalVar.PORT, "/customer/");
            MessageServier = getPrefixHttp(GlobalVar.HOST, GlobalVar.PORT, "/");
        }
    }

    interface PushAction {
        /**
         * 根据手机号绑定推送通道
         * mobile=
         * channelId=
         * platform=
         */
        String BIND = "/bind.do";
    }

    interface HomeAction {
        /**
         * 获取首页地址
         */
        String GET_HOME_ADDRESS = "getHomeAddress.do";
    }

    interface VersionAction {
        /**
         * 版本更新
         */
        String GET_ANDROID_VERSION_INFO = "getandroidReleaseVersion.do";
    }

    interface CustomerAction {
        /**
         * 获取用户信息通用接口
         */
        String GET_USER_INFO = "getUserInfo.do";
        /**
         * 修改用户昵称
         */
        String UPDATE_USER_INFO = "updateUserInfo.do";
        /**
         * 根据个人信息的会话标识获取群聊信息
         */
        String GET_USER_CHAT = "getUserChat.do";
    }

    public interface MsgAction {
        /**
         * 发送消息
         */
        String SEND_CHAT_MESSAGE = "chat/sendChatMessage.do";
        /**
         * 发送图片语音文件消息
         */
        String SEND_ALLFILE_MESSAGE = "message/sendAllFileMessage.do";
    }


    /**
     * 汇总
     */
    public static class Document {

        /**
         * 根据手机号绑定推送通道
         */
        public static String BIND;
        /**
         * 获取首页地址
         */
        public static String GET_HOME_ADDRESS;
        /**
         * 版本更新
         */
        public static String GET_ANDROID_VERSION_INFO;
        /**
         * 获取用户信息通用接口
         */
        public static String GET_USER_INFO;
        /**
         * 修改用户昵称
         */
        public static String UPDATE_USER_INFO;
        /**
         * 根据个人信息的会话标识获取群聊信息
         */
        public static String GET_USER_CHAT;
        /**
         * 发送消息
         */
        public static String SEND_CHAT_MESSAGE;
        /**
         * 发送图片语音文件消息
         */
        public static String SEND_ALLFILE_MESSAGE;

        public static void init() {
            BIND = ServiceName.PushServier + PushAction.BIND;
            GET_HOME_ADDRESS = ServiceName.HomeServier + HomeAction.GET_HOME_ADDRESS;
            GET_ANDROID_VERSION_INFO = ServiceName.VersionServier + VersionAction.GET_ANDROID_VERSION_INFO;
            GET_USER_INFO = ServiceName.CustomerServier + CustomerAction.GET_USER_INFO;
            UPDATE_USER_INFO = ServiceName.CustomerServier + CustomerAction.UPDATE_USER_INFO;
            GET_USER_CHAT = ServiceName.CustomerServier + CustomerAction.GET_USER_CHAT;
            SEND_CHAT_MESSAGE = ServiceName.MessageServier + MsgAction.SEND_CHAT_MESSAGE;
            SEND_ALLFILE_MESSAGE = ServiceName.MessageServier + MsgAction.SEND_ALLFILE_MESSAGE;

        }
    }
}
