package com.szh.controller;

import com.szh.domain.Account;
import com.szh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "success";
    }

    /**
     * 多种类型参数封装
     * @param account
     * @return
     */
    @RequestMapping("/savAccount")
    public String savAccount(Account account){
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换
     * @param user
     * @return
     */
    @RequestMapping("/savUser")
    public String savUser(User user){
        System.out.println("执行了");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了");
        System.out.println(request);
        System.out.println(response);
        return "success";
    }
}
