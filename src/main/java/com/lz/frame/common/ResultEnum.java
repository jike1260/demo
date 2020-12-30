package com.lz.frame.common;

/**
 * @Description TODO 状态码枚举
 * @Author lz
 * @Date 9:56 2020/12/29
 **/
public enum ResultEnum {

    /* 成功 */
    SUCCESS(200,"成功"),

    /* Token相关 */
    TOKEN_FIAL(1000,"Token验证失败"),

    /* 参数相关 */
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),

    /* 用户相关 */
    USER_NOT_LOGIN(2001,"服务器内部错误"),
    USER_LOGIN_ERROR(2002,"用户名或密码错误"),
    USER_ACCOUNT_FREEZE(2003,"帐号已被禁用"),
    USER_NOT_EXIST(2004,"用户不存在"),
    USER_HAS_EXISTED(2005,"用户已存在");

    /* 状态码 */
    private Integer code;
    /* 说明 */
    private String message;

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
