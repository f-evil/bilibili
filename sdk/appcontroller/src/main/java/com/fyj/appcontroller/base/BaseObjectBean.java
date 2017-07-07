package com.fyj.appcontroller.base;

/**
 * 当前作者: Fyj<br>
 * 时间: 2017/7/7<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述:
 */

public class BaseObjectBean<T> {
    private int code;
    private T result;

    public BaseObjectBean() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
