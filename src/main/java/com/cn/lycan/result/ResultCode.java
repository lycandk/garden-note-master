package com.cn.lycan.result;

/**
 * @author Makkapakka
 * @date 2022-5-18
 * @package_name com.cn.lycan.result
 * @description
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
