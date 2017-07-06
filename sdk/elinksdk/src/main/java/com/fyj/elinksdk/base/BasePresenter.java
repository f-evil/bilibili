package com.fyj.elinksdk.base;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fyj on 2016/8/23.
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    protected List<String> mTask;

    public V mView;
    public M mModel;

    public void setVM(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }

    public void onDestory() {
        mView = null;
        mModel = null;
        removeAllTask();
    }

    protected void removeAllTask() {
        if (mTask != null) {
            for (String tag : mTask) {
                OkHttpUtils.getInstance().cancelTag(tag);
            }
        }
    }

    protected void addTask(String tag, int id) {
        if (mTask == null) {
            mTask = new ArrayList<>();
        }
        mTask.add(tag);
    }

}
