package com.szh.controller;

import com.szh.domain.Account;
import com.szh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web(表现层)
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有");
        //调用service方法
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts",accounts);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("表现层：保存账户");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
