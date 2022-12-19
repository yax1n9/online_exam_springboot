package com.yaxing.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.domain.Student;
import com.yaxing.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yx
 * @date 2022/12/16
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping
    public Result createStudent(@RequestBody Student student) {
        boolean save = studentService.save(student);
        return new Result(save ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.INSERT_FAILED_CODE,
                save,
                save ? ResultMessage.INSERT_SUCCESS_MSG : ResultMessage.INSERT_FAILED_MSG);
    }

    @DeleteMapping("/{studentId}")
    public Result removeStudent(@PathVariable Integer studentId){
        boolean b = studentService.removeById(studentId);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.REMOVE_FAILED_CODE,
                b,
                b ? ResultMessage.REMOVE_SUCCESS_MSG : ResultMessage.REMOVE_FAILED_MSG);
    }

    @PutMapping
    public Result modifyStudent(@RequestBody Student student){
        boolean b = studentService.updateById(student);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.MODIFY_FAILED_CODE,
                b,
                b ? ResultMessage.MODIFY_SUCCESS_MSG : ResultMessage.MODIFY_FAILED_MSG);
    }

    @GetMapping("/{studentId}")
    public Result selectById(@PathVariable Integer studentId){
        Student student = studentService.getById(studentId);
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, student);
    }

    @GetMapping
    public Result selectList(){
        List<Student> list = studentService.list();
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, list);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectPageByCondition(@PathVariable int currentPage, @PathVariable int pageSize, Student student){
        IPage<Student> page = studentService.selectPageByCondition(currentPage, pageSize, student);
        if (page.getPages() < currentPage) {
            page = studentService.selectPageByCondition((int) page.getPages(), pageSize, student);
        }
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, page);
    }
}
