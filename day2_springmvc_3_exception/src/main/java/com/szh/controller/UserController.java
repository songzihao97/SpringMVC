package com.szh.controller;

import com.szh.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("testException")
    public String testException() throws SysException{

        System.out.println("testException执行了");
        try {
            //模拟异常
            int i=10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询异常");
        }
        return "success";
    }
}
