package com.yaxing.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.domain.ExamQuestion;
import com.yaxing.service.IExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yx
 * @date 2022/12/13
 */
@RestController
@RequestMapping("/examQuestions")
public class ExamQuestionController {

    @Autowired
    private IExamQuestionService examQuestionService;

    @PostMapping
    public Result createExamQuestion(@RequestBody ExamQuestion examQuestion) {
        boolean save = examQuestionService.save(examQuestion);
        return new Result(save ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.INSERT_FAILED_CODE,
                save,
                save ? ResultMessage.INSERT_SUCCESS_MSG : ResultMessage.INSERT_FAILED_MSG);
    }

    @DeleteMapping("/{examQuestionId}")
    public Result removeById(@PathVariable Integer examQuestionId) {
        boolean b = examQuestionService.removeById(examQuestionId);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.REMOVE_FAILED_CODE,
                b,
                b ? ResultMessage.REMOVE_SUCCESS_MSG : ResultMessage.REMOVE_FAILED_MSG);
    }

    @PutMapping
    public Result modifyById(@RequestBody ExamQuestion examQuestion) {
        boolean b = examQuestionService.updateById(examQuestion);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.MODIFY_FAILED_CODE,
                b,
                b ? ResultMessage.MODIFY_SUCCESS_MSG : ResultMessage.MODIFY_FAILED_MSG);
    }

    @GetMapping
    public Result selectList() {
        List<ExamQuestion> list = examQuestionService.list();
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, list);
    }

    @GetMapping("/{examQuestionId}")
    public Result selectById(@PathVariable Integer examQuestionId) {
        ExamQuestion examQuestion = examQuestionService.getById(examQuestionId);
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, examQuestion);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectPageByCondition(@PathVariable int currentPage,@PathVariable int pageSize, ExamQuestion examQuestion) {
        IPage<ExamQuestion> page = examQuestionService.selectPageByCondition(currentPage, pageSize, examQuestion);
        if (currentPage > page.getPages()) {
            page = examQuestionService.selectPageByCondition((int) page.getPages(), pageSize, examQuestion);
        }
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, page);
    }
}
