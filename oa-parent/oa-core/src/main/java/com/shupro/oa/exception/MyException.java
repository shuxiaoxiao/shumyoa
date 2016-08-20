package com.shupro.oa.exception;

import org.junit.Test;

public class MyException {

	/**
	 * try-catch-finally 
	 * 
	 */
	@Test
	public void test1(){
		try {
			int a = do1(-1);
			int b = do1(100);
			System.out.println(a);
			System.out.println(b);
		} catch (Exception e) {
			System.out.println("test1 异常");
			e.printStackTrace();
		}
	}
	
	private int do1(int num) {
		try {
			if (num<0) {
				throw new Exception("");
			}else{
				return num;
			}
		} catch (Exception e) {
			throw new Exception(e);
		}finally{
			return 2;
		}
	}
}
