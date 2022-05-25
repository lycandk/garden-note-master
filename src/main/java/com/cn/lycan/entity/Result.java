package com.cn.lycan.entity;

import lombok.Data;

/**
 * @author Makkapakka
 * @date 2022-5-13
 * @package_name com.cn.lycan.entity
 * @description 结果返回封装，实际上应设置成枚举类
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }

    public Result(int code) {
        this.code = code;
    }
}
