package com.cn.cjj.idao;

import com.cn.cjj.pojo.Login;

public interface LoginMapper {
    //通过账号查找用户
    public Login selectByAccount(String account);
    public void insertLogin(Login login) ;
    public void deleteLogin(String account) ;
    public void updateLogin(Login login) ;
}