package com.shupro.oa.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shupro.oa.admin.dao.SysDeptMapper;
import com.shupro.oa.admin.model.SysDept;
import com.shupro.oa.admin.service.SysDeptService;
import com.shupro.oa.core.AbstractService;
import com.shupro.oa.core.BaseMapper;
import com.shupro.oa.utils.MyConstant;
import com.shupro.oa.utils.page.PageBean;
import com.shupro.oa.vo.TreeNode;

@Service
public class SysDeptServiceImpl extends AbstractService<SysDept, Integer> implements SysDeptService {
	
	@Autowired
	private SysDeptMapper sysDeptMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysDept, Integer> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public PageBean<SysDept> select2PageBean(Map<String, Object> map) {
		PageBean<SysDept> pageBean = new PageBean<>();
		pageBean.setPageNo(Integer.parseInt(map.get("pageNo").toString()));
		pageBean.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		//注意map要先设置pageBean,拦截器里面要获取其值
		map.put("pageBean", pageBean);
		map.put("needPage", true);//是否分页，默认是false不分页
		pageBean.setRows(sysDeptMapper.selectAll4Page(map));
		return pageBean;
	}
	
	//将物理删除修改为逻辑删除
	@Override
	public int deleteById(Integer id) {
		SysDept sysDept = new SysDept(id,MyConstant.DISABLE);
		sysDeptMapper.updateSelective(sysDept);
		return 1;
	}

	@Override
	@Transactional
	public int deleteById(String ids) {
		String[] idsStr = ids.split(",");
		if (idsStr.length > 0) {
			for (String id : idsStr) {
//				sysDeptMapper.deleteById(Integer.parseInt(id));
				SysDept sysDept = new SysDept(Integer.parseInt(id),MyConstant.DISABLE);
				sysDeptMapper.updateSelective(sysDept);
			}
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<SysDept> selectByPid(String pid) {
		
		return sysDeptMapper.selectByPid(pid);
	}

	@Override
	public List<TreeNode> select2tree(List<SysDept> deptList) {
		List<TreeNode> list = null;
		TreeNode node = null;
		if (deptList != null) {
			list = new ArrayList<TreeNode>();
			for (SysDept dept : deptList) {
				if(dept != null){
					node = new TreeNode();
					node.setId(dept.getDeptid());//部门ID
					node.setChecked(false);
					node.setText(dept.getName());//部门名称
					node.setPid(dept.getPid());//父级部门ID
					node.setState(dept.getState());//节点状态，'open' 或 'closed'
//					if(selectByPid(dept.getDeptid()).size() >0){
//						node.setState("closed");
//					}
//					Map<String,Object> map = new HashMap<String,Object>();
//					node.setAttributes(map);
					
					list.add(node);
				}
			}
		}

		return list;
	}

	@Override
	public List<SysDept> select2treeGrid(List<SysDept> deptList) {
		for (SysDept dept : deptList) {
			if(dept != null){
				if(selectByPid(dept.getDeptid()).size() >0){
					dept.setState("closed");
				}
			}
		}
		return deptList;
	}

}
