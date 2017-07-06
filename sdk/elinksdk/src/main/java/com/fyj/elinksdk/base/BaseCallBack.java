package com.fyj.elinksdk.base;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/11/25
 * 邮箱: blq_ssnb@outlook.com
 * 修改次数: 1
 * 描述:
 * 用于在mvp中 m对p的回调
 * ================================================
 */
public interface BaseCallBack<T> {
    void callBack(T data);

    void onError(String errorMsg);

    void onTaskIdOrTag(String tag, int id);
}
