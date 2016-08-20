package com.shupro.oa.admin.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;
import com.shupro.oa.utils.io.FileUtil;
import com.shupro.oa.utils.json.JsonUtil;
import com.shupro.oa.utils.lang.StringUtil;
import com.shupro.oa.utils.page.PageBean;

@Controller
@RequestMapping("/sysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {
		
		return "admin/sysUser";
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
		PageBean<SysUser> list = sysUserService.select2PageBean(map);
		
		return JsonUtil.obj2JsonStr(list);
	}
	
    /**
     * 保存
     * 返回的是text
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysUser sysUser){
//    	Map<String,Object> map = new HashMap<>();
//    	try {
//    		sysUserService.insert(sysUser);
//    		map.put("success", true);
//        	map.put("msg", "保存成功");
//		} catch (Exception e) {
//			map.put("success", false);
//			map.put("msg", "保存失败");
//		}
//    	return JsonUtil.obj2JsonStr(map);
    	try {
    		sysUserService.insert(sysUser);
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
    public String update(SysUser sysUser){
    	try {
    		sysUserService.updateSelective(sysUser);
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
    		sysUserService.deleteById(ids);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
    
    /**
     * 文件上传(方式一)
     * 返回的是text
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(HttpServletRequest request, HttpServletResponse response){
    	try {
    		FileUtil.upload(request, response);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
    
    /**
     * 文件上传(方式二)
     * 返回的是text
     */
    @RequestMapping(value = "/upload2")
    @ResponseBody
    public String upload2(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model){
		try {
			String path = request.getSession().getServletContext().getRealPath("upload");
			String fileName = file.getOriginalFilename();
			String newFileName = StringUtil.getNewFilename(fileName);
			File targetFile = new File(path, newFileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}

			// 保存
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
    }
 
}