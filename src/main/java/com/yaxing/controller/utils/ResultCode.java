package com.yaxing.controller.utils;

/**
 * @author yx
 * @date 2022/12/5
 */
public class ResultCode {
    // 请求成功
    public static int REQUEST_SUCCESS_CODE = 200;

    // 系统异常
    public static int SYSTEM_EXCEPTION_CODE = 500;

    // 登录
    public static int LOGIN_FAILED_CODE = 201;

    // 注册
    public static int REGISTER_FAILED_CODE = 301;

    // 无效token
    public static int TOKEN_INVALID_CODE = 401;
    // token 权限不足
    public static int TOKEN_NO_AUTHORIZATION_CODE = 402;

    // 添加失败
    public static int INSERT_FAILED_CODE = 501;

    // 删除失败
    public static int REMOVE_FAILED_CODE = 502;

    // 修改失败
    public static int MODIFY_FAILED_CODE = 503;

    // 查询失败
    public static int SELECT_FAILED_CODE = 504;
}
