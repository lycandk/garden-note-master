package com.cn.lycan.result;

import com.cn.lycan.entity.Result;

/**
 * @author Makkapakka
 * @date 2022-5-18
 * @package_name com.cn.lycan.factory
 * @description
 */
public class ResultFactory {
    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}
