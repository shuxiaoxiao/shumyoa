package com.shupro.oa.admin.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shupro.oa.admin.dao.SysRoleMapper;
import com.shupro.oa.admin.model.SysRole;
import com.shupro.oa.admin.service.SysRoleService;
import com.shupro.oa.core.AbstractService;
import com.shupro.oa.core.BaseMapper;
import com.shupro.oa.utils.page.PageBean;

@Service
public class SysRoleServiceImpl extends AbstractService<SysRole, Integer> implements SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysRole, Integer> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public PageBean<SysRole> select2PageBean(Map<String, Object> map) {
		PageBean<SysRole> pageBean = new PageBean<>();
		pageBean.setPageNo(Integer.parseInt(map.get("pageNo").toString()));
		pageBean.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		//注意map要先设置pageBean,拦截器里面要获取其值
		map.put("pageBean", pageBean);
		map.put("needPage", true);//是否分页，默认是false不分页
		pageBean.setRows(sysRoleMapper.selectAll4Page(map));
		return pageBean;
	}
	
	@Override
	@Transactional
	public int deleteById(String ids) {
		String[] idsStr = ids.split(",");
		if (idsStr.length > 0) {
			for (String id : idsStr) {
				sysRoleMapper.deleteById(Integer.parseInt(id));
			}
			return 1;
		} else {
			return 0;
		}
	}
}
