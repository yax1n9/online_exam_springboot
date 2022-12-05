package com.yaxing.controller.utils;

import lombok.Data;

/**
 * @author yx
 * @date 2022/12/5
 */
@Data
public class Result {
    private int code;
    private Boolean success;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(int code, Boolean success, String message, Object data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Result(int code, Boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}
