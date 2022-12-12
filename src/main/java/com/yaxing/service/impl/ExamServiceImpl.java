package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaxing.dao.ExamDao;
import com.yaxing.domain.Exam;
import com.yaxing.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yx
 * @date 2022/12/12
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamDao, Exam> implements IExamService {
    @Autowired
    private ExamDao examDao;

    @Override
    public boolean deleteById(Integer examId) {
        Exam exam = new Exam();
        exam.setExamId(examId);
        exam.setIsDelete(1);
        return examDao.updateById(exam) > 0;
    }

    @Override
    public IPage<Exam> selectPageByCondition(int currentPage, int pageSize, Exam exam) {
        IPage<Exam> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Exam> lqm = new LambdaQueryWrapper<>();
        lqm.eq(exam.getSubjectId() != null, Exam::getSubjectId, exam.getSubjectId())
                .like(exam.getTitle() != null, Exam::getTitle, exam.getTitle())
                .eq(Exam::getIsDelete, 0);
        return examDao.selectPage(page, lqm);
    }
}
