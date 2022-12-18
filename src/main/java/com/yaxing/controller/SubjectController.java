package com.yaxing.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.domain.Subject;
import com.yaxing.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yx
 * @date 2022/12/9
 */
@CrossOrigin
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @PostMapping
    public Result createSubject(@RequestBody Subject subject) {
        boolean save = subjectService.save(subject);
        return new Result(save ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.INSERT_FAILED_CODE,
                save,
                save ? ResultMessage.INSERT_SUCCESS_MSG : ResultMessage.INSERT_FAILED_MSG);
    }

    @DeleteMapping("/{subjectId}")
    public Result removeSubjectById(@PathVariable Integer subjectId) {
        boolean b = subjectService.removeById(subjectId);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.REMOVE_FAILED_CODE,
                b,
                b ? ResultMessage.REMOVE_SUCCESS_MSG : ResultMessage.REMOVE_FAILED_MSG);
    }

    @PutMapping
    public Result modifySubjectById(@RequestBody Subject subject) {
        boolean b = subjectService.updateById(subject);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.MODIFY_FAILED_CODE,
                b,
                b ? ResultMessage.MODIFY_SUCCESS_MSG : ResultMessage.MODIFY_FAILED_MSG);
    }

    @GetMapping
    public Result selectAllSubject() {
        List<Subject> subjects = subjectService.list();
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, subjects);
    }

    @GetMapping("/{subjectId}")
    public Result selectById(@PathVariable Integer subjectId) {
        Subject subject = subjectService.getById(subjectId);
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, subject);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectPageByCondition(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Subject subject) {
        IPage<Subject> res = subjectService.getPageByCondition(currentPage, pageSize, subject);
        if (res.getPages() < currentPage) {
            res = subjectService.getPageByCondition((int) res.getPages(), pageSize, subject);
        }
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, res);
    }
}
