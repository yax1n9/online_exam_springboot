package com.yaxing.service;

import com.yaxing.domain.Admin;
import com.yaxing.domain.Student;

/**
 * @author yx
 * @date 2022/12/9
 */
public interface IRegisterService {
    /**
     * 管理员注册
     *
     * @param admin 管理员信息
     * @return 注册结果
     */
    boolean adminRegister(Admin admin);

    /**
     * 学生注册
     *
     * @param student 学生信息
     * @return 注册结果
     */
    boolean studentRegister(Student student);

    /**
     * 账号查重
     *
     * @param username 查询账号
     * @return 是否重复
     */
    boolean usernameExistCheck(String username);
}
