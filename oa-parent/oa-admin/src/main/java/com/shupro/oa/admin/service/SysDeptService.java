package com.shupro.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.shupro.oa.admin.model.SysDept;
import com.shupro.oa.core.BaseService;
import com.shupro.oa.vo.TreeNode;

public interface SysDeptService extends BaseService<SysDept, Integer> {
	
	/**
	 * 批量删除
	 * @param ids	多个主键值，用","隔开
	 * @return
	 */
	int deleteById(String ids);

	/**
	 * 根据pid 查询
	 * @param pid
	 * @return
	 */
	List<SysDept> selectByPid(String pid);
	
	/**
	 * 
	 * @param deptList
	 * @return
	 */
	List<TreeNode> select2tree(List<SysDept> deptList);
}
