package com.shupro.oa.admin.dao;

import java.util.List;

import com.shupro.oa.admin.model.SysRole;
import com.shupro.oa.core.BaseMapper;

public interface SysRoleMapper extends BaseMapper<SysRole, Integer> {
	
	/**
	 * 根据用户id 查询所含 角色
	 * @param roleId
	 * @return
	 */
	public List<SysRole> selectByUserId(int userId);
}