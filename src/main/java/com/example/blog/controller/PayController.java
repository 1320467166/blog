package com.example.blog.controller;

import com.example.blog.utils.PayUtil;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/pay")
@Api(value = "付款",description = "付款")
public class PayController {

    @Resource
    private PayUtil payUtil;

    @RequestMapping("/buy")
    public String buy(HttpServletResponse httpResponse) throws IOException {
        return payUtil.aLiPay("123","399","宝马","恭喜你成为尊贵的BMW车主");
    }


}

