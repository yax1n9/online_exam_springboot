package com.yaxing.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.dao.AdminDao;
import com.yaxing.domain.Admin;
import com.yaxing.domain.Register;
import com.yaxing.domain.Student;
import com.yaxing.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yx
 * @date 2022/12/9
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @PostMapping
    public Result register(@RequestBody Register register) {
        // 可以加一些信息验证 避免传入不合法数据
        // 账号查重
        if (!registerService.usernameExistCheck(register.getUsername())) {
            return new Result(ResultCode.REGISTER_FAILED_CODE, false, ResultMessage.REGISTER_IS_EXIST_MSG);
        }

        if (register.getRole() == 1) {
            // 注册管理员
            Admin admin = new Admin();
            admin.setUsername(register.getUsername());
            admin.setPassword(register.getPassword());
            admin.setAvatar(register.getAvatar());
            admin.setName(register.getName());
            admin.setGender(register.getGender());
            admin.setTel(register.getTel());
            admin.setIsDelete(0);
            admin.setRole(1);
            boolean res = registerService.adminRegister(admin);
            return new Result(res ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.REGISTER_FAILED_CODE, res, res ? ResultMessage.REGISTER_SUCCESS_MSG : ResultMessage.REGISTER_FAILED_MSG);
        } else if (register.getRole() == 0) {
            // 注册学生
            Student student = new Student();
            student.setUsername(register.getUsername());
            student.setPassword(register.getPassword());
            student.setAvatar(register.getAvatar());
            student.setName(register.getName());
            student.setGender(register.getGender());
            student.setTel(register.getTel());
            student.setIsDelete(0);
            student.setRole(0);
            boolean res = registerService.studentRegister(student);
            return new Result(res ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.REGISTER_FAILED_CODE, res, res ? ResultMessage.REGISTER_SUCCESS_MSG : ResultMessage.REGISTER_FAILED_MSG);
        }
        return new Result(ResultCode.REGISTER_FAILED_CODE, false, ResultMessage.REGISTER_NO_ROLE_MSG);
    }
}
