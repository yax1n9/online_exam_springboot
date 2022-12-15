package com.yaxing.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.domain.Exam;
import com.yaxing.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yx
 * @date 2022/12/12
 */
@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private IExamService examService;

    @PostMapping
    public Result createExam(@RequestBody Exam exam) {
        boolean save = examService.save(exam);
        Map<String, Integer> map = new HashMap<>();
        map.put("examId", exam.getExamId());
        return new Result(save ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.INSERT_FAILED_CODE,
                save,
                save ? ResultMessage.INSERT_SUCCESS_MSG : ResultMessage.INSERT_FAILED_MSG,
                map);
    }

    @DeleteMapping("/{examId}")
    public Result removeById(@PathVariable Integer examId) {
        boolean b = examService.removeById(examId);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.REMOVE_FAILED_CODE,
                b,
                b ? ResultMessage.REMOVE_SUCCESS_MSG : ResultMessage.REMOVE_FAILED_MSG);
    }

    @PutMapping
    public Result modifyById(@RequestBody Exam exam) {
        boolean b = examService.updateById(exam);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.MODIFY_FAILED_CODE,
                b,
                b ? ResultMessage.MODIFY_SUCCESS_MSG : ResultMessage.MODIFY_FAILED_MSG);
    }

    @GetMapping("/{examId}")
    public Result selectById(@PathVariable Integer examId) {
        Exam exam = examService.getById(examId);
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, exam);
    }

    @GetMapping
    public Result selectList() {
        List<Exam> exams = examService.list();
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, exams);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectPageByCondition(@PathVariable int currentPage, @PathVariable int pageSize, Exam exam) {
        IPage<Exam> page = examService.selectPageByCondition(currentPage, pageSize, exam);
        if (currentPage > page.getPages()) {
            page = examService.selectPageByCondition((int) page.getPages(), pageSize, exam);
        }
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, page);
    }
}
