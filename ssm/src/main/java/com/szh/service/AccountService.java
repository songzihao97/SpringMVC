package com.szh.service;

import com.szh.domain.Account;

import java.util.List;

public interface AccountService {

    //查询所有用户
    List<Account> findAll();

    //保存账户信息
    void saveAccount(Account account);

}
