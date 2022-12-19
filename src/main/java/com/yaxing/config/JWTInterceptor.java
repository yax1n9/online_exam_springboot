package com.yaxing.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.utils.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yx
 * @date 2022/12/7
 * jwt 拦截器
 */
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //表示接受任意域名的请求,也可以指定域名
        response.setHeader("Access-Control-Allow-Origin",
                request.getHeader("origin"));
        //该字段可选，是个布尔值，表示是否可以携带cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT,PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");
        Result result = null;
        try {
            // 从 request 的 header 中获得 token 值
            String token = request.getHeader("Authorization").replace("Bearer ", "");
            String path = request.getServletPath();
            DecodedJWT decodedJWT = JWTUtil.verify(token);
            String role = decodedJWT.getClaim("role").asString();
            if (role.equals("0")) {
                // 不是管理员，不能访问部分接口
                // /subject
                String reg = "(^/subject.*)|(^/login/test/token)";
                if (path.matches(reg)) {
                    result = new Result(ResultCode.TOKEN_NO_AUTHORIZATION_CODE, false, ResultMessage.TOKEN_NO_AUTH_MSG);
                }
            } else {
                return true; // 如果验证过程没有出异常，放行
            }
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            result = new Result(ResultCode.TOKEN_INVALID_CODE, false, ResultMessage.TOKEN_SIGNATURE_INVALID_MSG);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            result = new Result(ResultCode.TOKEN_INVALID_CODE, false, ResultMessage.TOKEN_OVER_TIME_MSG);
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            result = new Result(ResultCode.TOKEN_INVALID_CODE, false, ResultMessage.TOKEN_ALGO_DIFF_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(ResultCode.TOKEN_INVALID_CODE, false, ResultMessage.TOKEN_INVALID_MSG);
        }
        String json = new ObjectMapper().writeValueAsString(result);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return false;
    }
}
