package com.fyj.appcontroller.global;

import android.content.Context;

import com.fyj.easylinkingutils.utils.SDCardUtils;
import com.fyj.easylinkingutils.utils.StorageUtils;
import com.fyj.easylinkingutils.utils.StringUtil;

import java.io.File;

/**
 * 当前作者: Fyj<br>
 * 时间: 2016/9/8<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述: 全局的缓存路径
 */
public class NBCachePath {

    private static String dirName = "easylinking";
    //目录名字
    private static final String CACHE_EXTRAL_FILE_NAME_IAMGE = "image";
    private static final String CACHE_EXTRAL_FILE_NAME_RADIO = "radio";
    private static final String CACHE_EXTRAL_FILE_NAME_MEDIA = "media";
    private static final String CACHE_EXTRAL_FILE_NAME_IMAGE_COMPRESS = "imgcompress";
    private static final String CACHE_EXTRAL_FILE_NAME_CRASH = "crash";
    private static final String CACHE_EXTRAL_FILE_NAME_AD = "ad";
    private static final String CACHE_EXTRAL_FILE_NAME_QR = "qr";
    private static final String CACHE_EXTRAL_FILE_NAME_QR_SHOW = "qrShow";
    private static final String CACHE_EXTRAL_FILE_NAME_OCR = "tessdata";
    private static final String CACHE_EXTRAL_FILE_NAME_DOWNLOAD_FILE = "dowmloadFile";
    private static final String CACHE_EXTRAL_FILE_NAME_DOWNLOAD_FILE_TEMP = "dowmloadFileTemp";
    //内存缓存路径
    private static String CACHE_EXTRAL_FILE_IAMGE = "";
    private static String CACHE_EXTRAL_FILE_RADIO = "";
    private static String CACHE_EXTRAL_FILE_MEDIA = "";
    private static String CACHE_EXTRAL_FILE_IMAGE_COMPRESS = "";
    private static String CACHE_EXTRAL_FILE_CRASH = "";
    private static String CACHE_EXTRAL_FILE_AD = "";
    private static String CACHE_EXTRAL_FILE_QR = "";
    private static String CACHE_EXTRAL_FILE_QR_SHOW = "";
    private static String CACHE_EXTRAL_FILE_OCR = "";
    private static String CACHE_EXTRAL_FILE_DOWNLOAD_FILE = "";
    private static String CACHE_EXTRAL_FILE_DOWNLOAD_FILE_TEMP = "";

    /**
     * 重命名主文件夹名字
     *
     * @param name 名字
     */
    public static void initDirName(String name) {
        if (!StringUtil.isEmpty(name)) {
            dirName = name;
        }
    }

    /**
     * 创建路径
     *
     * @param context    上下文
     * @param extralPath 路径
     * @param name       名字
     * @return 全路径
     */
    private static String CreateCachePath(Context context, String extralPath, String name) {
        String path = "";
        if (SDCardUtils.isSDCardEnable()) {
            String tempPath = (StringUtil.isEmpty(extralPath) ? SDCardUtils.getSDCardPath() : extralPath) + name;
            File dir = new File(tempPath);
            if (!dir.exists()) {
                boolean mkdir = dir.mkdirs();
                if (mkdir) {
                    path = tempPath;
                } else {
                    path = StorageUtils.getCacheDirectory(context, name).getAbsolutePath();
                }
            } else {
                path = tempPath;
            }
        } else {
            path = StorageUtils.getCacheDirectory(context, name).getAbsolutePath();
        }
        path = path + File.separator;
        return path;
    }

    /**
     * 创建路径
     *
     * @param context 上下文
     * @param dirName 路径
     * @param name    名字
     * @return 全路径
     */
    public static String getCachePath(Context context, String dirName, String name) {
        String pathTotal = CreateCachePath(context, "", dirName);
        String path = "";
        path = CreateCachePath(context, pathTotal, name);
        return path;
    }

    /**
     * 创建路径
     *
     * @param context 上下文
     * @param name    名字
     * @return 全路径
     */
    public static String getCachePath(Context context, String name) {
        String pathTotal = CreateCachePath(context, "", dirName);
        String path = "";
        path = CreateCachePath(context, pathTotal, name);
        return path;
    }

    /**
     * 返回全路径
     *
     * @param context 上下文
     * @param value   路径
     * @param name    名字
     * @return 全路径
     */
    private static String returnValue(Context context, String value, String name) {
        if (StringUtil.isEmpty(value)) {
            return value = getCachePath(context, name);
        } else {
            return value;
        }
    }

    /**
     * 获取拍照存放文件夹地址
     * 在SD下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getImageCachePath(Context context) {
        return returnValue(context, CACHE_EXTRAL_FILE_IAMGE, CACHE_EXTRAL_FILE_NAME_IAMGE);
    }

    /**
     * 获取语音存放文件夹地址
     * 在SD下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getRadioCachePath(Context context) {
        return returnValue(context, CACHE_EXTRAL_FILE_RADIO, CACHE_EXTRAL_FILE_NAME_RADIO);
    }

    /**
     * 获取视频存放文件夹地址
     * 在SD下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getMediaCachePath(Context context) {
        return returnValue(context, CACHE_EXTRAL_FILE_MEDIA, CACHE_EXTRAL_FILE_NAME_MEDIA);
    }

    /**
     * 获取图片压缩存放文件夹地址
     * 在data/data下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getImageCompressCachePath(Context context) {

        if (StringUtil.isEmpty(CACHE_EXTRAL_FILE_IMAGE_COMPRESS)) {
            String pathTotal = CreateCachePath(context, context.getCacheDir().getAbsolutePath() + "/", dirName);
            return CACHE_EXTRAL_FILE_IMAGE_COMPRESS = CreateCachePath(context, pathTotal, CACHE_EXTRAL_FILE_NAME_IMAGE_COMPRESS);
        } else {
            return CACHE_EXTRAL_FILE_IMAGE_COMPRESS;
        }
    }

    /**
     * 获取二维码存放文件夹地址
     * 在data/data下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getQRCachePath(Context context) {

        return returnValue(context, CACHE_EXTRAL_FILE_QR, CACHE_EXTRAL_FILE_NAME_QR);

//        if (StringUtil.isEmpty(CACHE_EXTRAL_FILE_QR)) {
//            String pathTotal = CreateCachePath(context, context.getCacheDir().getAbsolutePath() + "/", dirName);
//            return CACHE_EXTRAL_FILE_QR = CreateCachePath(context, pathTotal, CACHE_EXTRAL_FILE_NAME_QR);
//        } else {
//            return CACHE_EXTRAL_FILE_QR;
//        }
    }

    /**
     * 获取二维码存放文件夹地址
     * 在data/data下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getQRShowCachePath(Context context) {

        return returnValue(context, CACHE_EXTRAL_FILE_QR_SHOW, CACHE_EXTRAL_FILE_NAME_QR_SHOW);

//        if (StringUtil.isEmpty(CACHE_EXTRAL_FILE_QR)) {
//            String pathTotal = CreateCachePath(context, context.getCacheDir().getAbsolutePath() + "/", dirName);
//            return CACHE_EXTRAL_FILE_QR = CreateCachePath(context, pathTotal, CACHE_EXTRAL_FILE_NAME_QR);
//        } else {
//            return CACHE_EXTRAL_FILE_QR;
//        }
    }

    /**
     * 获取崩溃信息存放文件夹地址
     * 在SD下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getCrashCachePath(Context context) {
        return returnValue(context, CACHE_EXTRAL_FILE_CRASH, CACHE_EXTRAL_FILE_NAME_CRASH);
    }

    /**
     * 文件下载
     * 在SD下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getDownloadFilePath(Context context) {
        return returnValue(context, CACHE_EXTRAL_FILE_DOWNLOAD_FILE, CACHE_EXTRAL_FILE_NAME_DOWNLOAD_FILE);
    }

    /**
     * 文件下载缓存
     * 在SD下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getDownloadFileTempPath(Context context) {
        return returnValue(context, CACHE_EXTRAL_FILE_DOWNLOAD_FILE_TEMP, CACHE_EXTRAL_FILE_NAME_DOWNLOAD_FILE_TEMP);
    }

    /**
     * 获取文字识别训练文件文件夹地址
     * 在SD下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getOCRPath(Context context) {
        return returnValue(context, CACHE_EXTRAL_FILE_OCR, CACHE_EXTRAL_FILE_NAME_OCR);
    }

    /**
     * 获取广告存放文件夹地址
     * 在data/data下
     *
     * @param context 上下文
     * @return 地址
     */
    public static String getADCachePath(Context context) {
        if (StringUtil.isEmpty(CACHE_EXTRAL_FILE_AD)) {
            String pathTotal = CreateCachePath(context, context.getCacheDir().getAbsolutePath() + "/", dirName);
            return CACHE_EXTRAL_FILE_AD = CreateCachePath(context, pathTotal, CACHE_EXTRAL_FILE_NAME_AD);
        } else {
            return CACHE_EXTRAL_FILE_AD;
        }
    }

    /**
     * http请求结果存放文件夹地址
     * 在data/data下
     *
     * @param context 上下文
     * @return 地址
     */
    public static File getRetrofitCachePath(Context context) {

        return context.getCacheDir();
    }

}
