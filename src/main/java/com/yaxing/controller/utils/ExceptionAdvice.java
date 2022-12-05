package com.yaxing.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yx
 * @date 2022/12/5
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public Result handler(Exception e) {
        e.printStackTrace();
        return new Result(ResultCode.SYSTEM_EXCEPTION_CODE, false, ResultMessage.SYSTEM_EXCEPTION_MSG);
    }
}
