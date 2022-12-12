package com.yaxing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yaxing.domain.Exam;

/**
 * @author yx
 * @date 2022/12/12
 */
public interface IExamService extends IService<Exam> {

    boolean deleteById(Integer examId);

    IPage<Exam> selectPageByCondition(int currentPage, int pageSize, Exam exam);
}
