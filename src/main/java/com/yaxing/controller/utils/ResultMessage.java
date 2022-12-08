package com.yaxing.controller.utils;

/**
 * @author yx
 * @date 2022/12/5
 */
public class ResultMessage {
    public static String LOGIN_SUCCESS_MSG = "登陆成功！";
    public static String LOGIN_FAILED_MSG = "登陆失败！请检查用户名或密码";

    public static String SYSTEM_EXCEPTION_MSG = "系统异常，请稍后再试！";

    // token
    public static String TOKEN_PASS_MSG = "令牌验证通过";
    public static String TOKEN_INVALID_MSG = "令牌不合法";
    public static String TOKEN_SIGNATURE_INVALID_MSG = "令牌签名无效";
    public static String TOKEN_OVER_TIME_MSG = "令牌过期";
    public static String TOKEN_ALGO_DIFF_MSG = "令牌算法不一致";
}
