package com.yaxing.controller;

import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.domain.Admin;
import com.yaxing.domain.Login;
import com.yaxing.domain.Student;
import com.yaxing.service.ILoginService;
import com.yaxing.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author yx
 * @date 2022/12/5
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @PostMapping
    public Result login(@RequestBody Login login) {
        try {
            Map<String, String> payload = new HashMap<>();
            String token;
            Map<String, String> resMap = new HashMap<>();
            Admin admin = loginService.adminLogin(login);
            if (admin != null) {
                payload.put("id", admin.getAdminId() + "");
                payload.put("name", admin.getName());
                payload.put("username", admin.getUsername());
                payload.put("role", admin.getRole() + "");
                token = JWTUtil.createToken(payload);
                resMap.put("token", token);
                return new Result(ResultCode.LOGIN_SUCCESS_CODE, true, ResultMessage.LOGIN_SUCCESS_MSG, resMap);
            }
            Student student = loginService.studentLogin(login);
            if (student != null) {
                payload.put("id", student.getStudentId() + "");
                payload.put("name", student.getName());
                payload.put("username", student.getUsername());
                payload.put("role", student.getRole() + "");
                token = JWTUtil.createToken(payload);
                resMap.put("token", token);
                return new Result(ResultCode.LOGIN_SUCCESS_CODE, true, ResultMessage.LOGIN_SUCCESS_MSG, resMap);
            }
        } catch (Exception e) {
            return new Result(ResultCode.LOGIN_FAILED_CODE, false, ResultMessage.LOGIN_FAILED_MSG);
        }
        return new Result(ResultCode.LOGIN_FAILED_CODE, false, ResultMessage.LOGIN_FAILED_MSG);
    }

    @PostMapping("/test/token")
    public String testToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        JWTUtil.verify(token);
        return token;
    }
}
