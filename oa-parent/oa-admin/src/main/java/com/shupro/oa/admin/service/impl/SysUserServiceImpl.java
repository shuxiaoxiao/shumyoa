package com.shupro.oa.admin.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shupro.oa.admin.dao.SysUserMapper;
import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;
import com.shupro.oa.core.AbstractService;
import com.shupro.oa.core.BaseMapper;
import com.shupro.oa.utils.page.PageBean;

@Service
public class SysUserServiceImpl extends AbstractService<SysUser, Integer> implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysUser, Integer> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public PageBean<SysUser> select2PageBean(Map<String, Object> map) {
		PageBean<SysUser> pageBean = new PageBean<>();
		pageBean.setPageNo(Integer.parseInt(map.get("pageNo").toString()));
		pageBean.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		//注意map要先设置pageBean,拦截器里面要获取其值
		map.put("pageBean", pageBean);
		map.put("needPage", true);//是否分页，默认是false不分页
		pageBean.setRows(sysUserMapper.selectAll4Page(map));
		return pageBean;
	}

	@Override
	@Transactional
	public int deleteById(String ids) {
		String[] idsStr = ids.split(",");
		if (idsStr.length > 0) {
			for (String id : idsStr) {
				sysUserMapper.deleteById(Integer.parseInt(id));
			}
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public SysUser login(String username, String password) {
		return sysUserMapper.login(username, password);
	}
}
