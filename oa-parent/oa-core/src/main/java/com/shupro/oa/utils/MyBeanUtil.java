package com.shupro.oa.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class MyBeanUtil {
	
	/**
	 * 请求参数转换为map
	 * @param request
	 * @return
	 */
	public static Map<String, String> getParameterMap(HttpServletRequest request){
		Map<String, String> map =new HashMap<>();
		Enumeration<String> paraNames = request.getParameterNames();
		while (paraNames.hasMoreElements()) {
			String key = paraNames.nextElement();
			String value = request.getParameter(key);
		    map.put(key, value);
		}
		return map;
	}

}
