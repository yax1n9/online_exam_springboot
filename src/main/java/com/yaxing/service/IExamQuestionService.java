package com.yaxing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yaxing.domain.ExamQuestion;

/**
 * @author yx
 * @date 2022/12/13
 */
public interface IExamQuestionService extends IService<ExamQuestion> {
    IPage<ExamQuestion> selectPageByCondition(int currentPage, int pageSize, ExamQuestion examQuestion);
}
