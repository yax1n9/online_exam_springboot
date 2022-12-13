package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaxing.dao.SubjectDao;
import com.yaxing.domain.Subject;
import com.yaxing.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yx
 * @date 2022/12/9
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, Subject> implements ISubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public IPage<Subject> getPageByCondition(Integer currentPage, Integer pageSize, Subject subject) {
        IPage<Subject> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Subject> lqm = new LambdaQueryWrapper<>();
        lqm.like(subject.getName() != null, Subject::getName, subject.getName());
        return subjectDao.selectPage(page, lqm);
    }
}
