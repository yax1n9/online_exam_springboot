package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaxing.dao.ExamQuestionDao;
import com.yaxing.domain.ExamQuestion;
import com.yaxing.service.IExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yx
 * @date 2022/12/13
 */
@Service
public class ExamQuestionServiceImpl extends ServiceImpl<ExamQuestionDao, ExamQuestion> implements IExamQuestionService {

    @Autowired
    private ExamQuestionDao examQuestionDao;


    /**
     * 分页条件查询试卷对应试题
     *
     * @param currentPage 当前页码
     * @param pageSize 页容量
     * @param examQuestion 条件
     * @return 查询结果
     */
    @Override
    public IPage<ExamQuestion> selectPageByCondition(int currentPage, int pageSize, ExamQuestion examQuestion) {
        IPage<ExamQuestion> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<ExamQuestion> lqm = new LambdaQueryWrapper<>();
        lqm.eq(examQuestion.getExamId() != null, ExamQuestion::getExamId, examQuestion.getExamId());
        return examQuestionDao.selectPage(page, lqm);
    }
}
