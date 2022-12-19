package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaxing.dao.SingleChooseDao;
import com.yaxing.dao.SubjectDao;
import com.yaxing.domain.SingleChoose;
import com.yaxing.domain.Subject;
import com.yaxing.service.ISingleChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author yx
 * @date 2022/12/13
 */
@Service
public class SingleChooseServiceImpl extends ServiceImpl<SingleChooseDao, SingleChoose> implements ISingleChooseService {

    @Autowired
    private SingleChooseDao singleChooseDao;
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public IPage<SingleChoose> selectPageByCondition(int currentPage, int pageSize, SingleChoose singleChoose) {
        LambdaQueryWrapper<SingleChoose> lqm = new LambdaQueryWrapper<>();
        lqm.like(singleChoose.getTitle() != null, SingleChoose::getTitle, singleChoose.getTitle())
                .eq(singleChoose.getSubjectId() != null, SingleChoose::getSubjectId, singleChoose.getSubjectId());
        IPage<SingleChoose> page = new Page<>(currentPage, pageSize);
        return singleChooseDao.selectPage(page, lqm);
    }

    @Override
    public boolean create(SingleChoose singleChoose) {
        Subject subject = subjectDao.selectById(singleChoose.getSubjectId());
        singleChoose.setSubjectName(subject.getName());
        return singleChooseDao.insert(singleChoose) > 0;
    }
}
