package com.yaxing.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import com.yaxing.domain.SingleChoose;
import com.yaxing.service.ISingleChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yx
 * @date 2022/12/13
 */
@CrossOrigin
@RestController
@RequestMapping("/singleChooses")
public class SingleChooseController {
    @Autowired
    private ISingleChooseService singleChooseService;

    @PostMapping
    public Result createSingleChoose(@RequestBody SingleChoose singleChoose) {
        boolean save = singleChooseService.create(singleChoose);
        Map<String, SingleChoose> map = new HashMap<>();
        map.put("question", singleChoose);
        return new Result(save ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.INSERT_FAILED_CODE,
                save,
                save ? ResultMessage.INSERT_SUCCESS_MSG : ResultMessage.INSERT_FAILED_MSG,
                map);
    }

    @DeleteMapping("/{singleChooseId}")
    public Result removeById(@PathVariable Integer singleChooseId) {
        boolean b = singleChooseService.removeById(singleChooseId);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.REMOVE_FAILED_CODE,
                b,
                b ? ResultMessage.REMOVE_SUCCESS_MSG : ResultMessage.REMOVE_FAILED_MSG);
    }

    @PutMapping
    public Result modifyById(@RequestBody SingleChoose singleChoose) {
        boolean b = singleChooseService.updateById(singleChoose);
        return new Result(b ? ResultCode.REQUEST_SUCCESS_CODE : ResultCode.MODIFY_FAILED_CODE,
                b,
                b ? ResultMessage.MODIFY_SUCCESS_MSG : ResultMessage.MODIFY_FAILED_MSG);
    }

    @GetMapping
    public Result selectList() {
        List<SingleChoose> list = singleChooseService.list();
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, list);
    }

    @GetMapping("/{singleChooseId}")
    public Result selectById(@PathVariable Integer singleChooseId) {
        SingleChoose singleChoose = singleChooseService.getById(singleChooseId);
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, singleChoose);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectPageByCondition(@PathVariable int currentPage, @PathVariable int pageSize, SingleChoose singleChoose) {
        IPage<SingleChoose> page = singleChooseService.selectPageByCondition(currentPage, pageSize, singleChoose);
        if (currentPage > page.getPages()) {
            page = singleChooseService.selectPageByCondition((int) page.getPages(), pageSize, singleChoose);
        }
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.SELECT_SUCCESS_MSG, page);
    }
}
