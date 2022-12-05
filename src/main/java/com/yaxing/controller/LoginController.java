package com.yaxing.controller;

import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.domain.Admin;
import com.yaxing.domain.Login;
import com.yaxing.domain.Student;
import com.yaxing.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        Admin admin = loginService.adminLogin(login);
        if (admin != null) {
            return new Result(ResultCode.LOGIN_SUCCESS_CODE, true, ResultMessage.LOGIN_SUCCESS_MSG);
        }

        Student student = loginService.studentLogin(login);
        if (student != null) {
            return new Result(ResultCode.LOGIN_SUCCESS_CODE, true, ResultMessage.LOGIN_SUCCESS_MSG);
        }
        return new Result(ResultCode.LOGIN_FAILED_CODE, false, ResultMessage.LOGIN_FAILED_MSG);
    }
}
