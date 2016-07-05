package com.shupro.oa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shupro.oa.admin.model.SysUser;

public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURL = request.getRequestURI();
		System.out.println(requestURL);
		SysUser userInfo = (SysUser) request.getSession().getAttribute("userInfo");
		if (userInfo == null) {
			String url = request.getContextPath() + "/";
			// 考虑到可能有多层路径,如sysUser/init,这时重定向建议使用绝对路径
			response.sendRedirect(url + "tologin");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}  

}
