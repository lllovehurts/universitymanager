package com.cn.cjj.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.cn.cjj.pojo.Login;
import com.cn.cjj.pojo.Role;
import com.cn.cjj.service.ILoginService;
import com.cn.cjj.service.IRoleService;


@Component
public class loginRealm extends AuthorizingRealm{
	@Resource
	private ILoginService loginService ;
	@Resource
	private IRoleService roleService ;
	/**
	 *授权 -访问控制 
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String account=(String) getAvailablePrincipal(principals);//获得提交账号
		Role role=null;
		Login login=loginService.findLogin(account);//通过账号获得指定用户
		role =roleService.getRole(login.getRoleid());//通过用户信息得到用户权限
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> r=new HashSet<String>();//存储权限
		if(role!=null){
			r.add(role.getName());
			info.setRoles(r);
		}
		return info;
	}
	/**
	 * 认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String account = (String) token.getPrincipal();//获得提交的账号和密码
		String password = new String((char[])token.getCredentials());
		Login login=null;
		login=loginService.findLogin(account) ;
		if(login==null){
			throw new UnknownAccountException();//账号无对应用户，抛出账号异常
		}else if (!password.equals(login.getPassword())) {
			throw new IncorrectCredentialsException();//密码匹配错误，抛出密码异常
		}
		AuthenticationInfo ainfo=new SimpleAuthenticationInfo(account,password,getName());
		return ainfo;
	}
}
