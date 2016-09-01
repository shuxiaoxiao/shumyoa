package com.shupro.oa.utils.joda;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;

/**
 * DateTime类似jdk的String（不可变）<br>
 * Joda 使用以下概念，它们可以应用到任何日期/时间库：<br>
 * 不可变性（Immutability）<br>
 * 瞬间性（Instant）<br>
 * 局部性（Partial）<br>
 * 年表（Chronology）<br>
 * 时区（Time zone）<br>
 * @author Administrator
 *
 */
public class DateTimeDemo {

	public void init() {
		//构造当前时间
		DateTime dt1 =new DateTime();
		System.out.println(dt1);//2015-12-16T10:59:36.655+08:00
		System.out.println(dt1.toString());//2015-12-16T10:59:36.655+08:00
		System.out.println(dt1.toString("E MM/dd/yyyy HH:mm:ss.SSS"));//星期三 12/16/2015 10:59:36.655
		//分别获取年、月、日 信息
		Property week = dt1.dayOfWeek();
		int w1 = week.get();//3
		String w2 = week.getAsString();//"3"
		String w3 = week.getAsText();//星期三
		System.out.println(w1+","+w2+","+w3);
		
		/**
		 * 构造任意时间段<br>
		 * (1)年-月-日 时:分 ;(2)年-月-日 时:分:秒 ;(3)年-月-日 时:分:秒.毫秒 ;
		 */
		DateTime dt2 =new DateTime(2015,1,1,0,0,0);
		System.out.println(dt2);//2015-01-01T00:00:00.000+08:00
		
//		DateTime dateTime = SystemClock.getDateTime();

		
	}
	
	public void test1() {
//		DateTime dt1 =new DateTime();
//		dt1.plusDays(30);
//		//星期三 2015-12-16 10:45:34(DateTime是不可变的)
//		System.out.println(dt1.toString("E yyyy-MM-dd HH:mm:ss"));
		/**
		 * 在当前日期下操作<br>
		 * 添加30天后的日期,dt1.plusDays(30); 减少30天后的日期,dt1.plusDays(-30)<br>
		 * 
		 */
		DateTime dt1 =new DateTime();
		System.out.println(dt1.plusDays(30).toString("E yyyy-MM-dd HH:mm:ss"));
		
		DateTime dt2 =new DateTime();
		System.out.println(dt2.plusDays(-30).toString("E yyyy-MM-dd HH:mm:ss"));
		Property week =dt2.plusDays(-30).dayOfWeek();//Property[dayOfWeek]
		int w1 = week.get();
		String w2 = week.getAsString();
		String w3 = week.getAsText();
	}
	
	//Joda 与 JDK 是百分之百可互操作的
	public void dateTime2jdkdate() {
		//将dateTime转换为 jdkdate
		DateTime dt =new DateTime();
		Date jdkDate = dt.toDate();
		
		//将jdkdate转换为 dateTime
		Date date =new Date();
		DateTime dt2 =new DateTime(date);
		
	}
	
}
