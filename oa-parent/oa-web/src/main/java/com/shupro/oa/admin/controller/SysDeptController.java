package com.shupro.oa.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shupro.oa.admin.model.SysDept;
import com.shupro.oa.admin.service.SysDeptService;
import com.shupro.oa.utils.json.JsonUtil;
import com.shupro.oa.utils.page.PageBean;

@Controller
@RequestMapping("/sysDept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;

	@RequestMapping("/treeGrid")
	@ResponseBody
	public String treeGrid(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String pid = request.getParameter("id");
		if (pid == null) {
			pid = "0";
		}
		List<SysDept> list = sysDeptService.selectByPid(pid);
//		//treegrid不适合做搜索查询
//		String deptid = request.getParameter("deptid");
//		String name = request.getParameter("name");
//		map.put("deptid", deptid);
//		map.put("name", name);
//		//没有查询条件时
//		if(deptid == null && name == null){
//			map.put("pid",pid);
//		}
//		List<SysDept> list = sysDeptService.selectAll4Page(map);
		
		return JsonUtil.obj2JsonStr(sysDeptService.select2treeGrid(list));
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public String tree(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		int pid = 0;
//		if (id != null) {
//			pid = Integer.parseInt(id);
//		}
		//根节点默认为pid=0
		String pid = request.getParameter("id");
		if (pid == null) {
			pid = "0";
		}
		List<SysDept> list = sysDeptService.selectByPid(pid);
		
		return JsonUtil.obj2JsonStr(sysDeptService.select2tree(list));
	}
	
	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {
		
		return "admin/sysDept";
	}
	
	/**
	 * 分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		//easyUI的grid分页参数,具体处理在service层
		map.put("pageNo", request.getParameter("page"));
		map.put("pageSize", request.getParameter("rows"));
		//查询域的查询条件
		//map.put("deptid", request.getParameter("deptid"));
		map.put("name", request.getParameter("name"));
		PageBean<SysDept> list = sysDeptService.select2PageBean(map);
		
		return JsonUtil.obj2JsonStr(list);
	}
	
	/**
     * 保存
     * 返回的是text
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysDept sysDept){
//    	Map<String,Object> map = new HashMap<>();
//    	try {
//    		sysDeptService.insert(sysDept);
//    		map.put("success", true);
//        	map.put("msg", "保存成功");
//		} catch (Exception e) {
//			map.put("success", false);
//			map.put("msg", "保存失败");
//		}
//    	return JsonUtil.obj2JsonStr(map);
    	try {
    		sysDeptService.insert(sysDept);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
    
    /**
     * 修改
     * 返回的是text
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(SysDept sysDept){
    	try {
    		sysDeptService.updateSelective(sysDept);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
    
    /**
     * 删除
     * 返回的是text
     */
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable String ids){
    	try {
    		sysDeptService.deleteById(ids);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
	
}