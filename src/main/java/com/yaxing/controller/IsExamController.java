package com.yaxing.controller;

import com.yaxing.controller.utils.Result;
import com.yaxing.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yx
 * @date 2022/12/13
 */
@RestController
@RequestMapping("/isExam")
public class IsExamController {

    @Autowired
    private IExamService examService;

    @GetMapping("/{examId}")
    public Result judgeTime(@PathVariable Integer examId) {
        return examService.judgeTime(examId);
    }
}
