package com.cn.cjj.service;

import com.cn.cjj.pojo.Login;

public interface ILoginService {
	public Login findLogin(String account) ;		
	public void addLogin(Login login) ;
	public void removeLogin(String account) ;
	public void editLogin(Login login) ;
}
