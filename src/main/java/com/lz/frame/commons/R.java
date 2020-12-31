package com.lz.frame.commons;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName R
 * @Description //TODO 封装返回结果
 * @Author lz
 * @Date 10:00 2020/12/29
 */
@Data
@SuppressWarnings("serial")
public class R implements Serializable {

    private Integer code;

    private String message;

    private Object data;

    public static R success() {
        return new R(ResultEnum.SUCCESS);
    }

    public static R success(Object data) {
        return new R(ResultEnum.SUCCESS, data);
    }

    public static R fail(ResultEnum sc) {
        return new R(sc);
    }

    public static R fail(ResultEnum sc, Object data) {
        return new R(sc, data);
    }

    public static R fail(Integer code, String message, Object data) {
        return new R(code, message, data);
    }

    public R(ResultEnum sc) {
        this.code = sc.code();
        this.message = sc.message();
        this.data = null;
    }

    public R(ResultEnum sc, Object data) {
        this.code = sc.code();
        this.message = sc.message();
        this.data = data;
    }

    public R(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
