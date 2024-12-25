package com.common.enumeration;

/**
 * 通用返回代码
 * @author jiangshuai
 */
public enum CommonCode {
    /**
     * 操作成功
     */
    CODE_SUCCESS(1, "操作成功"),
    /**
     * 操作失败
     */
    CODE_FAILED(-1, "操作失败"),
    /**
     * 用户名密码错误
     */
    CODE_LOGIN_ERROR(-2, "用户名或密码错误"),
    /**
     * 验证码错误
     */
    CODE_VCERROR(-3, "验证码错误"),
    /**
     * 随机码错误
     */
    CODE_RANDOMERROR(-3, "随机码错误"),
    /**
     * 系统异常
     */
    CODE_SYS_EXCEPTION(-9, "系统异常"),
    /**
     * 用户登陆超时或未登陆
     */
    CODE_ERROR_NO_LOGIN(401, "用户登陆超时或未登陆"),
    /**
     *
     */
    CODE_ERROR_NO_MENU(4040, "无效菜单"),
    /**
     * 无权限
     */
    CODE_ERROR_NO_PURVIEW(4031, "无权限"),
    /**
     * 用户被锁定
     */
    CODE_ERROR_SYSCODE(403, "用户已被锁定，请联系管理员处理"),
    /**
     * 成功（一件事专用）
     */
    CODE_YJSBL_SUCCESS(200, "已办理"),
    /**
     * 失败（一件事专用）
     */
    CODE_YJSBL_ERROR(300, "失败");

    /** 编码 */
    public Integer code;
    /** 描述 */
    public String message;

    CommonCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
