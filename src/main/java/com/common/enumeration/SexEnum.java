package com.common.enumeration;

/**
 * 性别枚举
 * @author jiangshuai
 * @Classname SexEnum
 */
public enum SexEnum {
    /**
     * 性别
     */
    man("1","男"),
    woman("2","女");
    SexEnum(String sexCode, String sexName) {
        this.sexCode = sexCode;
        this.sexName = sexName;
    }
    private final String sexCode;
    private final String sexName;

    public String getSexCode() {
        return sexCode;
    }

    public String getSexName() {
        return sexName;
    }
}
