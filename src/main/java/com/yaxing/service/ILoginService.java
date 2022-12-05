package com.yaxing.service;

import com.yaxing.domain.Admin;
import com.yaxing.domain.Login;
import com.yaxing.domain.Student;

/**
 * @author yx
 * @date 2022/12/5
 */
public interface ILoginService {
    Admin adminLogin(Login login);

    Student studentLogin(Login login);
}
