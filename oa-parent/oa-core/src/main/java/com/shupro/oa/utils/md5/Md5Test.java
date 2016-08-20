package com.shupro.oa.utils.md5;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * MD5全名Message-Digest Algorithm 5（信息-摘要算法）是一种不可逆的加密算法。
 * @author Administrator
 *
 */
public class Md5Test {

	@Test
	public void test1() {
		String str = "test";
		String md5 = DigestUtils.md5Hex(str);
		//32位,098f6bcd4621d373cade4e832627b4f6
		System.out.println(md5.length() +"位,"+md5);
		
		String sha256 = DigestUtils.sha256Hex(str);
		//64位,9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
		System.out.println(sha256.length() +"位,"+sha256);
		
		String sha1 = DigestUtils.sha1Hex(str);
		//40位,a94a8fe5ccb19ba61c4c0873d391e987982fbbd3
		System.out.println(sha1.length() +"位,"+sha1);
		
//		Base64.
	}
	
	@Test
	public void test2() {
//		String str = "test";
//		String md5 = DigestUtils.md5Hex(str);
//		System.out.println(md5.length());
		//32位
		//098f6bcd4621d373cade4e832627b4f6
		String jiami = "098f6bcd4621d373cade4e832627b4f6";
		if (jiami.equals(DigestUtils.md5Hex("test"))) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
			
		
		
	}
}
