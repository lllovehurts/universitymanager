package com.cn.cjj.service.impl;

import javax.annotation.Resource;  
  
import org.springframework.stereotype.Service;  

import com.cn.cjj.idao.LoginMapper;
import com.cn.cjj.pojo.Login;
import com.cn.cjj.service.ILoginService;
  
  
@Service("loginService")  
public class LoginServiceImpl implements ILoginService {
	@Resource
	LoginMapper loginMapper ;
	public Login findLogin(String account) {
		return this.loginMapper.selectByAccount(account) ;
	}
	public void addLogin(Login login) {
		this.loginMapper.insertLogin(login) ;
	}
	public void removeLogin(String account) {
		this.loginMapper.deleteLogin(account) ;
	}
	public void editLogin(Login login) {
		this.loginMapper.updateLogin(login) ;
	}  
	
}  
