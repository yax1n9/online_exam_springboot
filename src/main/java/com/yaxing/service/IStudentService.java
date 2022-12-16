package com.yaxing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yaxing.domain.Student;

/**
 * @author yx
 * @date 2022/12/16
 */
public interface IStudentService extends IService<Student> {
    IPage<Student> selectPageByCondition(int currentPage, int pageSize, Student student);
}
