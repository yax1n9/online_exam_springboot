package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yaxing.dao.AdminDao;
import com.yaxing.dao.StudentDao;
import com.yaxing.domain.Admin;
import com.yaxing.domain.Login;
import com.yaxing.domain.Student;
import com.yaxing.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author yx
 * @date 2022/12/5
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public Admin adminLogin(Login login) {
        LambdaQueryWrapper<Admin> lqm = new LambdaQueryWrapper<>();
        lqm.eq(login.getUsername() != null && login.getPassword() != null, Admin::getUsername, login.getUsername())
                .eq(login.getUsername() != null && login.getPassword() != null, Admin::getPassword, DigestUtils.md5DigestAsHex(login.getPassword().getBytes()));
        return adminDao.selectOne(lqm);
    }

    @Override
    public Student studentLogin(Login login) {
        LambdaQueryWrapper<Student> lqm = new LambdaQueryWrapper<>();
        lqm.eq(login.getUsername() != null && login.getPassword() != null, Student::getUsername, login.getUsername())
                .eq(login.getUsername() != null && login.getPassword() != null, Student::getPassword, DigestUtils.md5DigestAsHex(login.getPassword().getBytes()));
        return studentDao.selectOne(lqm);
    }
}
