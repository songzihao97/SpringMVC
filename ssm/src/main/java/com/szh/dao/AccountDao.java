package com.szh.dao;

import com.szh.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    //查询所有用户
    @Select("select * from account")
    List<Account> findAll();

    //保存账户信息
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);

}
