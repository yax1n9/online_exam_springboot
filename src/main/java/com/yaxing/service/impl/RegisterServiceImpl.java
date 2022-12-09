package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yaxing.dao.AdminDao;
import com.yaxing.dao.StudentDao;
import com.yaxing.domain.Admin;
import com.yaxing.domain.Student;
import com.yaxing.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @author yx
 * @date 2022/12/9
 */
@Service
public class RegisterServiceImpl implements IRegisterService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean adminRegister(Admin admin) {
        // 写入库前加密密码
        String psw2Md5 = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        admin.setPassword(psw2Md5);
        return adminDao.insert(admin) > 0;
    }

    @Override
    public boolean studentRegister(Student student) {
        // 加密密码
        String psw2Md5 = DigestUtils.md5DigestAsHex(student.getPassword().getBytes());
        student.setPassword(psw2Md5);
        return studentDao.insert(student) > 0;
    }

    @Override
    public boolean usernameExistCheck(String username) {
        // 管理员
        LambdaQueryWrapper<Admin> lqm_admin = new LambdaQueryWrapper<>();
        lqm_admin.eq(username != null, Admin::getUsername, username)
                .eq(username != null, Admin::getIsDelete, 0);
        List<Admin> admins = adminDao.selectList(lqm_admin);
        // 学生
        LambdaQueryWrapper<Student> lqm_student = new LambdaQueryWrapper<>();
        lqm_student.eq(username != null, Student::getUsername, username)
                .eq(username != null, Student::getIsDelete, 0);
        List<Student> students = studentDao.selectList(lqm_student);
        return admins.size() < 1 && students.size() < 1;
    }
}
