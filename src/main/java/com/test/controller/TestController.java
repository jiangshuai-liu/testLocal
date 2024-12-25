package com.test.controller;

import com.common.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @Title Controller
 * @Author jiangshuai
 * @Description TODO
 * @Date 2024/12/12 10:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("test/controller")
public class TestController {
    /**
     * 登陆
     * @param
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public CommonResult<String> login(HttpServletRequest request, @RequestBody ) {
        return ;
    }
}
