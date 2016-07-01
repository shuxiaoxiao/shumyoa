package com.shupro.oa.admin.dao;

import java.util.List;

import com.shupro.oa.admin.model.SysDept;
import com.shupro.oa.core.BaseMapper;

public interface SysDeptMapper extends BaseMapper<SysDept, Integer> {
	
	/**
	 * 根据pid 查询
	 * @param pid
	 * @return
	 */
	List<SysDept> selectByPid(String pid);
}