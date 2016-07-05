package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.core.BaseService;

public interface SysUserService extends BaseService<SysUser, Integer> {

	/**
	 * 登录
	 * @param loginname 用户名
	 * @param password 密码
	 * @return
	 */
	public SysUser login(String loginname, String password);
}
