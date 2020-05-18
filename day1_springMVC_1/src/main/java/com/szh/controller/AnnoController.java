package com.szh.controller;

import com.szh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //将msg存入session域中
public class AnnoController {
    /*测试requestParam*/
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String name){
        System.out.println(name);
        return "success";
    }
    /*获取请求体内容*/
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }
    /*PathVariable*/
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") String id){
        System.out.println(id);
        return "success";
    }
    /*获取cookie值*/
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解会在方法之前执行
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc")User user){
        System.out.println("testModelAttribute");
        System.out.println(user);
        return "success";
    }

    /*有返回值
    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行力");
        //模拟通过用户名查询数据库
        User user=new User();
        user.setUname(uname);
        user.setAge(10);
        user.setBirthday(new Date());
        return user;
    }
     */

    /**
     * 无返回值
     */
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行力");
        //模拟通过用户名查询数据库
        User user=new User();
        user.setUname(uname);
        user.setAge(10);
        user.setBirthday(new Date());
        map.put("abc",user);
    }

    /**
     * SessionAttributes
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes");
        //底层会存储到request域中
        model.addAttribute("msg","张三");
        return "success";
    }

    //从session中取值
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes");
        String msg=(String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    //删除session
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes");
        status.setComplete();
        return "success";
    }
}
