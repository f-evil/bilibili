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
        static String XServier;

        public static void init() {
            XServier = getPrefixHttp(GlobalVar.HOST, GlobalVar.PORT, "/x/");
        }
    }

    interface ShowAction {
        String SHOW_OLD = "/show/old";
    }

    /**
     * 汇总
     */
    public static class Document {

        public static String SHOW_OLD;


        public static void init() {
            SHOW_OLD = ServiceName.XServier + ShowAction.SHOW_OLD;
        }
    }
}
