package com.yaxing.controller;

import com.yaxing.controller.utils.Result;
import com.yaxing.controller.utils.ResultCode;
import com.yaxing.controller.utils.ResultMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yx
 * @date 2022/12/19
 */
// @CrossOrigin
@RestController
@RequestMapping("/token")
public class TokenController {
    @GetMapping("/verify")
    public Result tokenVerify() {
        return new Result(ResultCode.REQUEST_SUCCESS_CODE, true, ResultMessage.TOKEN_PASS_MSG);
    }
}
