package com.shupro.oa.admin.auto;

import org.junit.Test;

import com.shupro.oa.admin.service.SysDeptService;
import com.shupro.oa.utils.db.SpringUtil;

public class MyTest {

	@Test
	public void test1() {
		Object obj = SpringUtil.getBean("sysDeptServiceImpl");
		SysDeptService sysDeptService = (SysDeptService) obj;
//		sysDeptService.select2PageBean(map);
		System.out.println(obj);
		System.out.println(sysDeptService);
	}
}
