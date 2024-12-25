package com.common.helper;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * @author: WangHe
 * @description:
 * @date: 2019\6\6 0006.
 */

public class IdGenHelper {
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.  32位长度。一般用它
     *
     * @param flag 是否有中间的'-' true有 false无
     * @return
     */
    public static String uuid(boolean flag) {
        if (flag) {
            return UUID.randomUUID().toString();
        } else {
            return UUID.randomUUID().toString().replaceAll("-", "");
        }
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(RANDOM.nextLong());
    }

    /**
     * 功能描述：[  生成UUID主键  ]
     * @ Author：
     * @ Datetime： 2021/6/24 13:34
     */
    public static String getGUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
