package com.cn.cjj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.cjj.idao.RoleMapper;
import com.cn.cjj.pojo.Role;
import com.cn.cjj.service.IRoleService;
@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	@Resource
	private RoleMapper roleMapper ; 

	public Role getRole(int roleId) {//获得权限
		return this.roleMapper.selectById(roleId) ;
	}
}
