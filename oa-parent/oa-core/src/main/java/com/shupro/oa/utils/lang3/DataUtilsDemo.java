package com.shupro.oa.utils.lang3;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

/**
 * apache.commons.lang3.time包中的DateUtils类
 * 日期处理
 * @author Administrator
 *
 */
public class DataUtilsDemo {

	@Test
	public void parseDate() throws ParseException {
		//字符串转成date类型
		Date date = DateUtils.parseDate("2015/01/01 11:22:33", "yyyy/MM/dd HH:mm:ss");//true   
//		System.out.println(date);
		
		// 10天后  
		Date tenDaysAfter = DateUtils.addDays(date, 10); // => 2015/01/11 11:22:33  
		System.out.println(DateFormatUtils.format(tenDaysAfter, "yyyy/MM/dd HH:mm:ss"));  
		  
		// 前一个月  
		Date prevMonth = DateUtils.addMonths(date, -1); // => 2014/12/01 11:22:33  
		System.out.println(DateFormatUtils.format(prevMonth, "yyyy/MM/dd HH:mm:ss"));  
		  
		// 判断是否是同一天  
		Date date1 = DateUtils.parseDate("2015/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});  
		Date date2 = DateUtils.parseDate("2015/01/01 22:33:44", new String[]{"yyyy/MM/dd HH:mm:ss"});  
		System.out.println(DateUtils.isSameDay(date1, date2));// true  
		  
		// 日期格式化  （date类型 转成 字符串）
		System.out.println(DateFormatUtils.format(new Date(), "yyyy/MM/dd HH:mm:ss"));  

	}
	
}
