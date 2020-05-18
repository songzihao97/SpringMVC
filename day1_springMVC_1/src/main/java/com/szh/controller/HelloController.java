package com.szh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器
@Controller
@RequestMapping(path = "/user")
public class HelloController  {

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    @RequestMapping(value = "/testRequestMapping",method = {RequestMethod.GET,RequestMethod.POST},params = {"username"},headers = "Accept")
    public String testRequestMapping(String username){
        System.out.println("testRequestMapping"+'\n'+username);
        return "success";
    }
}
