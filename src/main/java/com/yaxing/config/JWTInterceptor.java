package com.yaxing.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
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
 * jwt 拦截器行为
 */
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Result result = null;
        // 从 request 的 header 中获得 token 值
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        try {
            JWTUtil.verify(token);
            return true; // 如果验证过程没有出异常，放行
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
