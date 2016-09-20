package com.shupro.oa.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;
import com.shupro.oa.utils.json.JsonUtil;
import com.shupro.oa.vo.Result;
import com.shupro.oa.webservice.TestWS;

@WebService
public class TestWSImpl implements TestWS{

	@Autowired
	SysUserService sysUserService;
	
	@Override
	public String sayHello(String username) {
		System.out.println("hello:" + username);
		
		return username;
	}
	
//	@Override
//	public String sayHello(String username) {
//		SysUser sysUser = sysUserService.login("test", "123");
//		System.out.println("hello:" + sysUser);
//		Result result = new Result(0,sysUser,"成功");
//		
//		return JsonUtil.obj2JsonStr(result);
//	}

}
