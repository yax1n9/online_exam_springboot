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
    public static String TOKEN_NO_AUTH_MSG = "令牌权限不足";

    // 注册
    public static String REGISTER_SUCCESS_MSG = "注册成功！";
    public static String REGISTER_FAILED_MSG = "注册失败！";
    public static String REGISTER_IS_EXIST_MSG = "用户名已存在！";
    public static String REGISTER_NO_ROLE_MSG = "身份未选择！";

    // 增删改查
    public static String INSERT_FAILED_MSG = "添加失败！";
    public static String INSERT_SUCCESS_MSG = "添加成功！";

    public static String REMOVE_FAILED_MSG = "删除失败！";
    public static String REMOVE_SUCCESS_MSG = "删除成功！";

    public static String MODIFY_FAILED_MSG = "修改失败！";
    public static String MODIFY_SUCCESS_MSG = "修改成功！";

    public static String SELECT_FAILED_MSG = "查询失败！";
    public static String SELECT_SUCCESS_MSG = "查询成功！";

    // 文件
    public static String FILE_UPLOAD_SUCCESS_MSG = "上传成功！";
    public static String FILE_UPLOAD_FAILED_MSG = "上传失败！";

    public static String FILE_DOWNLOAD_SUCCESS_MSG = "下载成功！";
    public static String FILE_DOWNLOAD_FAILED_MSG = "下载失败！";

    // 考试时间
    public static String EXAM_TIME_OVER_MSG = "考试结束！";
    public static String EXAM_TIME_NOT_BEGIN_MSG = "考试未开始！";
    public static String EXAM_TIME_LATE_MSG = "考试已经开始，不能进入！";
    public static String EXAM_TIME_PASS_MSG = "开始考试！";

}
