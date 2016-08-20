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

import com.shupro.oa.admin.model.SysDictionary;
import com.shupro.oa.admin.service.SysDictionaryService;
import com.shupro.oa.utils.json.JsonUtil;
import com.shupro.oa.utils.page.PageBean;

@Controller
@RequestMapping("/sysDictionary")
public class SysDictionaryController {

	@Autowired
	private SysDictionaryService sysDictionaryService;

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {
		
		return "admin/sysDictionary";
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
		PageBean<SysDictionary> list = sysDictionaryService.select2PageBean(map);
		
		return JsonUtil.obj2JsonStr(list);
	}
	
	/**
	 * 查询数据给下拉框
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/select2combo/{pid}")
	@ResponseBody
	public String select2combo(HttpServletRequest request,@PathVariable int pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		//查询域的查询条件
//		map.put("pid", request.getParameter("pid"));
		map.put("pid", pid);
		List<SysDictionary> list = sysDictionaryService.selectAll4Page(map);
		
		return JsonUtil.obj2JsonStr(list);
	}
	
	/**
     * 保存
     * 返回的是text
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysDictionary sysDictionary){
//    	Map<String,Object> map = new HashMap<>();
//    	try {
//    		sysDictionaryService.insert(sysDictionary);
//    		map.put("success", true);
//        	map.put("msg", "保存成功");
//		} catch (Exception e) {
//			map.put("success", false);
//			map.put("msg", "保存失败");
//		}
//    	return JsonUtil.obj2JsonStr(map);
    	try {
    		sysDictionaryService.insert(sysDictionary);
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
    public String update(SysDictionary sysDictionary){
    	try {
    		sysDictionaryService.updateSelective(sysDictionary);
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
    		sysDictionaryService.deleteById(ids);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
	
}