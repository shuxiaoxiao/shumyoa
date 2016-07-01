package com.shupro.oa.core;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.shupro.oa.utils.lang.StringUtil;

public class MyTest {

	@Test
	public void test1() throws UnsupportedEncodingException {
		String str ="中文";
		String encoding ="utf-8";
		String result = StringUtil.transcodage(str, encoding);
		System.out.println(result);
	}
}
