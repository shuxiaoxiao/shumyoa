package com.shupro.oa.admin.dao;

import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.core.BaseMapper;

public interface SysUserMapper extends BaseMapper<SysUser, Integer> {
	/**
	 * 登录
	 * @param loginname 用户名
	 * @param password 密码
	 * @return
	 */
	public SysUser login(String loginname, String password);
}