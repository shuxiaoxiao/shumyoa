package com.shupro.oa.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;
import com.shupro.oa.vo.Result;

/**
 * 登录退出
 * @author shu
 *
 */
@Controller
//@RequestMapping("/")
public class LoginController {
	@Autowired
	private SysUserService sysUserService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Result login(HttpServletRequest request) {
//    	MyBeanUtil.getParameterMap(request);
    	String loginname = request.getParameter("loginname");
    	String password = request.getParameter("password");
    	Result result = new Result();
//        if (StringUtils.isBlank(loginname)) {
//            result.setMsg("用户名不能为空");
//            return result;
//        }
//        if (StringUtils.isBlank(password)) {
//            result.setMsg("密码不能为空");
//            return result;
//        }
    	
    	SysUser sysUser = sysUserService.login(loginname, password);
    	if (null != sysUser) {
    		//保存用户到session
    		request.getSession().setAttribute("userInfo", sysUser);
    		
    		//成功显示首页
    		result.setSuccess(true);
    		result.setMsg("/home");
		}
    	return result;
    }

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout(HttpServletRequest request) {
    	//重定向到登录页面,如果有参数之类的建议使用RedirectAttributes
    	request.getSession().removeAttribute("userInfo");
    	
        return "redirect:/tologin";
    }
}
