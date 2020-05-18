package com.szh.controller;

import com.szh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * String类型返回值响应
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了...");
        //模拟数据库取值
        User user=new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(23);
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * void类型返回值相应方式
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid执行了...");
        //请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //解决中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //直接响应数据
        response.getWriter().write("哈哈");
    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv=new ModelAndView();
        System.out.println("testModelAndView执行了...");
        //模拟数据库取值
        User user=new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(23);
        //将user对象存入mv中，mv调用modelMap将内容存入request
        mv.addObject("user",user);
        //利用视图解析器跳转
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字实现转发或重定向（不经过视图解析器）
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了...");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向(框架会自动增加项目名称完成重定向)
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步响应请求
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了...");
        System.out.println(user);
        user.setUsername("hehe");
        user.setAge(33);
        return user;
    }
}
