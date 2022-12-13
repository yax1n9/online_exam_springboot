package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.dao.ExamDao;
import com.yaxing.domain.Exam;
import com.yaxing.domain.IsExam;
import com.yaxing.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yx
 * @date 2022/12/12
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamDao, Exam> implements IExamService {
    @Autowired
    private ExamDao examDao;

    @Override
    public IPage<Exam> selectPageByCondition(int currentPage, int pageSize, Exam exam) {
        IPage<Exam> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Exam> lqm = new LambdaQueryWrapper<>();
        lqm.eq(exam.getSubjectId() != null, Exam::getSubjectId, exam.getSubjectId())
                .like(exam.getTitle() != null, Exam::getTitle, exam.getTitle())
                .eq(Exam::getIsDelete, 0);
        return examDao.selectPage(page, lqm);
    }

    @Override
    public Result judgeTime(Integer examId) {
        // 拿到试卷id
        // 查询试卷信息拿到开始时间结束时间
        Exam exam = examDao.selectById(examId);
        long startTime = exam.getStartTime().getTime();
        long endTime = exam.getEndTime().getTime();
        int latestEnterTime = exam.getLatestEnterTime() * 60 * 1000;  // ms
        // 获取当前系统时间
        Date date = new Date();
        long now = date.getTime();
        // 判断当前系统时间是否处于开放区间
        IsExam isExam = new IsExam();
        Result result = new Result();
        if (now >= startTime && now < endTime) {
            if ((now - startTime) > latestEnterTime) {
                // 超过了最晚进入时间
                result.setCode(ResultCode.EXAM_TIME_OVER_CODE);
                result.setSuccess(false);
                result.setMessage(ResultMessage.EXAM_TIME_LATE_MSG);
                return result;
            }
            // 时间在区间内
            isExam.setExam(true);
            isExam.setRemainingTime(endTime - now);
            result.setCode(ResultCode.REQUEST_SUCCESS_CODE);
            result.setSuccess(true);
            result.setMessage(ResultMessage.EXAM_TIME_PASS_MSG);
            result.setData(isExam);
            return result;
        } else if (now < startTime) {
            // 未开始
            result.setCode(ResultCode.EXAM_TIME_NOT_BEGIN_CODE);
            result.setSuccess(false);
            result.setMessage(ResultMessage.EXAM_TIME_NOT_BEGIN_MSG);
            return result;
        } else {
            // 已结束
            result.setCode(ResultCode.EXAM_TIME_OVER_CODE);
            result.setSuccess(false);
            result.setMessage(ResultMessage.EXAM_TIME_OVER_MSG);
            return result;
        }
    }
}
