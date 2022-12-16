package com.yaxing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yaxing.controller.utils.Result;
import com.yaxing.domain.Exam;

/**
 * @author yx
 * @date 2022/12/12
 */
public interface IExamService extends IService<Exam> {

    /**
     * 分页条件查询
     *
     * @param currentPage 当前页码
     * @param pageSize    页容量
     * @param exam        条件信息
     * @return 分页条件查询结果
     */
    IPage<Exam> selectPageByCondition(int currentPage, int pageSize, Exam exam);

    /**
     * 判断是否处于考试时间区间
     *
     * @param examId 试卷id
     * @return 时间结果
     */
    Result judgeTime(Integer examId);

    /**
     * 新增
     */
    boolean create(Exam exam);
}
