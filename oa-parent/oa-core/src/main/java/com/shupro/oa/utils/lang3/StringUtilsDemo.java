package com.shupro.oa.utils.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * apache.commons.lang3包中的StringUtils类
 * 字符串
 * @author Administrator
 *
 */
public class StringUtilsDemo {

	/**判断是否为空*/
	@Test
	public void isEmpty() {
		System.out.println(StringUtils.isEmpty(null));//true  
		System.out.println(StringUtils.isEmpty(""));//true  
		System.out.println(StringUtils.isEmpty(" "));//false  
	}
	
	@Test
	public void isBlank() {
		System.out.println(StringUtils.isBlank(null));//true  
		System.out.println(StringUtils.isBlank(""));//true  
		System.out.println(StringUtils.isBlank(" "));//false  
	}
	
	/**去空格*/
	@Test
	public void trim() {
		//tirm,去除前后空格
		System.out.println(StringUtils.trim(null)); //null  
		System.out.println(StringUtils.trim("")); //""  
		System.out.println(StringUtils.trim("  abc")); //"abc"  
		System.out.println(StringUtils.trim("  abc  ")); //"abc"  
		System.out.println(StringUtils.trim("  ab c  ")); //"ab c" 
		
		// 去空格，将Null和"" 转换为Null
		System.out.println(StringUtils.trimToNull(""));
		// 去空格，将NULL 和 "" 转换为""
		System.out.println(StringUtils.trimToEmpty(null));
	
	}
	
	
	
}
