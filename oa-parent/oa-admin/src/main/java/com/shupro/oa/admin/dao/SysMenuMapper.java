package com.shupro.oa.admin.dao;

import java.util.List;

import com.shupro.oa.admin.model.SysMenu;
import com.shupro.oa.core.BaseMapper;

public interface SysMenuMapper extends BaseMapper<SysMenu, Integer> {
	
	/**
	 * 根据登录名 查询所含菜单
	 * @param loginName
	 * @return
	 */
	public List<SysMenu> selectByLoginName(String loginName);
	
	/**
	 * 根据角色id 查询所含菜单
	 * @param roleId
	 * @return
	 */
	public List<SysMenu> selectByRoleId(int roleId);
}