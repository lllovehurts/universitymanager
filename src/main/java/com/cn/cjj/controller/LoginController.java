package com.cn.cjj.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.cjj.pojo.Login;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(Login login){
		UsernamePasswordToken token = new UsernamePasswordToken(login.getAccount(),login.getPassword());//从前端获取账号密码然后交由realm处理
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
        if (subject.hasRole("admin")) {
            return "redirect:/admin/index.jsp";
        } else if (subject.hasRole("teacher")) {	
            return "redirect:/teacher/index.jsp";
        } else if (subject.hasRole("student")) {
            return "redirect:/student/index.jsp";
        }
        return "/login";
	}
	
	@RequestMapping("/loginout")
    public String loginOut(Login login)throws Exception{
    	Subject subject = SecurityUtils.getSubject();
    	subject.logout(); 
		return "login";  
    }
}
