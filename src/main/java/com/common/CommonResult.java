package com.common;

import com.common.enumeration.CommonCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author Administrator
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 3831711629044003725L;

    /** 返回结果编码 */
    private Integer returnCode;
    /** 返回结果描述 */
    private String returnMsg;
    /** 返回结果 */
    private T returnData;

    public CommonResult(T returnData) {
        this.returnData = returnData;
    }

    /**
     * 返回成功信息
     * @param returnData 返回值
     * @return CommonResult<T>
     */
    public CommonResult<T> success(T returnData) {
        return new CommonResult<T>(CommonCode.CODE_SUCCESS.code, CommonCode.CODE_SUCCESS.message, returnData);
    }

    /**
     * 返回成功信息
     * @return CommonResult<T>
     */
    public CommonResult<T> success() {
        return new CommonResult<T>(CommonCode.CODE_SUCCESS.code, CommonCode.CODE_SUCCESS.message, null);
    }

    /**
     * 返回失败信息（返回结果）
     * @param returnData 返回值
     * @return CommonResult<T>
     */
    public CommonResult<T> failed(T returnData) {
        return new CommonResult<T>(CommonCode.CODE_FAILED.code, CommonCode.CODE_FAILED.message, returnData);
    }

    /**
     * 返回失败信息（返回描述）
     * @param returnMsg 返回结果描述
     * @return
     */
    public CommonResult<T> error(String returnMsg) {
        return new CommonResult<T>(CommonCode.CODE_FAILED.code, returnMsg, null);
    }

    /**
     * 返回失败信息（返回描述）
     * @param returnMsg 返回结果描述
     * @param returnData
     * @return
     */
    public CommonResult<T> error(String returnMsg, T returnData) {
        return new CommonResult<T>(CommonCode.CODE_FAILED.code, returnMsg, returnData);
    }

    /**
     * 验证码错误
     * @return
     */
    public CommonResult<T> vcError() {
        return new CommonResult<>(CommonCode.CODE_VCERROR.code, CommonCode.CODE_VCERROR.message, returnData);
    }

    /**
     * 随机码错误
     * @return
     */
    public CommonResult<T> randomError() {
        return new CommonResult<>(CommonCode.CODE_RANDOMERROR.code, CommonCode.CODE_RANDOMERROR.message, returnData);
    }

    /**
     * 用户名密码错误
     * @return
     */
    public CommonResult<T> loginError() {
        return new CommonResult<>(CommonCode.CODE_LOGIN_ERROR.code, CommonCode.CODE_LOGIN_ERROR.message, returnData);
    }

    /**
     * 用户名密码错误
     * @param msg
     * @return
     */
    public CommonResult<T> loginError(String msg) {
        return new CommonResult<>(CommonCode.CODE_LOGIN_ERROR.code, msg, returnData);
    }

    /**
     * 系统异常（返回结果）
     * @param returnData 返回值
     * @return CommonResult<T>
     */
    public CommonResult<T> sysException(T returnData) {
        return new CommonResult<>(CommonCode.CODE_SYS_EXCEPTION.code, CommonCode.CODE_SYS_EXCEPTION.message,returnData);
    }

    /**
     * 系统异常（返回描述）
     * @param errMesg 错误消息
     * @return CommonResult<T>
     */
    public CommonResult<T> sysExceptionStr(String errMesg) {
        return new CommonResult<>(CommonCode.CODE_SYS_EXCEPTION.code, errMesg,null);
    }

    /**
     * 用户被锁定
     * @return
     */
    public CommonResult<T> userLock() {
        return new CommonResult<>(CommonCode.CODE_ERROR_SYSCODE.code, CommonCode.CODE_ERROR_SYSCODE.message,null);
    }

    /**
     * 用户登陆超时或未登陆
     * @return
     */
    public CommonResult<T> noLogin() {
        return new CommonResult<>(CommonCode.CODE_ERROR_NO_LOGIN.code, CommonCode.CODE_ERROR_NO_LOGIN.message,null);
    }
    /**
     * 无权限
     * @return
     */
    public CommonResult<T> noPurview() {
        return new CommonResult<>(CommonCode.CODE_ERROR_NO_PURVIEW.code, CommonCode.CODE_ERROR_NO_PURVIEW.message,null);
    }
    /**
     * 无效菜单
     * @return
     */
    public CommonResult<T> noMenu() {
        return new CommonResult<>(CommonCode.CODE_ERROR_NO_MENU.code, CommonCode.CODE_ERROR_NO_MENU.message,null);
    }
}
