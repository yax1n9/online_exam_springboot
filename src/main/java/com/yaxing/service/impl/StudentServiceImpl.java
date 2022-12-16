package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaxing.dao.StudentDao;
import com.yaxing.domain.Student;
import com.yaxing.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yx
 * @date 2022/12/16
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public IPage<Student> selectPageByCondition(int currentPage, int pageSize, Student student) {
        IPage<Student> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<>();
        lqw.like(Student::getName, student.getName());
        return studentDao.selectPage(page, lqw);
    }
}
