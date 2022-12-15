package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        if (exam.getIsEnd() == 1) {
            return new Result(ResultCode.EXAM_TIME_OVER_CODE, true, ResultMessage.EXAM_TIME_OVER_MSG);
        }
        long startTime = exam.getStartTime().getTime();
        long endTime = exam.getEndTime().getTime();
        int latestEnterTime = exam.getLatestEnterTime() * 60 * 1000;  // ms
        // 获取当前系统时间
        long now = new Date().getTime();
        // 判断当前系统时间是否处于开放区间
        if (now >= startTime && now < endTime) {
            // 处于试卷开放时间
            if ((now - startTime) > latestEnterTime) {
                // 迟到时间大于设置
                return new Result(ResultCode.EXAM_TIME_OVER_CODE, true, ResultMessage.EXAM_TIME_LATE_MSG, new IsExam(false, 0));
            }
            return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.EXAM_TIME_PASS_MSG, new IsExam(true, endTime - now));
        }else if (now < startTime){
            // 未开始
            return new Result(ResultCode.EXAM_TIME_NOT_BEGIN_CODE, true, ResultMessage.EXAM_TIME_NOT_BEGIN_MSG, new IsExam(false, 0));
        }else {
            // 已结束
            return new Result(ResultCode.EXAM_TIME_OVER_CODE, true, ResultMessage.EXAM_TIME_OVER_MSG, new IsExam(false,0));
        }
    }


    /**
     * 定时器任务
     * 在每分钟第 0s 去设置 exam 表中试卷 is_end 字段
     */
    @Scheduled(cron = "0 * * * * *")
    public void task() {
        // 拿取所有未结束的试卷信息
        LambdaQueryWrapper<Exam> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Exam::getIsEnd, 0);
        List<Exam> examList = examDao.selectList(lqw);

        // 遍历更新 is_end
        long now = new Date().getTime();
        long endTime;
        for (Exam exam : examList) {
            endTime = exam.getEndTime().getTime();
            if (now >= endTime) {
                examDao.updateIsEnd(exam.getExamId());
            }
        }
    }
}
