package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.core.BaseService;

public interface SysUserService extends BaseService<SysUser, Integer> {

	/**
	 * 批量删除
	 * @param ids	多个主键值，用","隔开
	 * @return
	 */
	int deleteById(String ids);
}
