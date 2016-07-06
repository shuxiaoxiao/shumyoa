package com.shupro.oa.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.shupro.oa.utils.MyBeanUtil;
import com.shupro.oa.utils.excel.ExcelInfo;
import com.shupro.oa.utils.excel.POIUtil;
import com.shupro.oa.utils.lang.StringUtil;

public class MyTest {
	@Test
	public void test3() throws IOException{
		Student stu = new Student("name1", "grade1", "70", "70");
		Map<String, Object> map = MyBeanUtil.transBean2Map(stu);
		System.out.println(map);
	}
	
	@Test
	public void test2() throws IOException{
		String filePath ="D:/aa.xls";
		OutputStream outStream = new FileOutputStream(filePath);
		String[] titles = {"姓名","班级","笔试成绩","机试成绩"};
		String[] fields = {"name","grade","writeScore","machineScore"};
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "name1");
		map1.put("grade", "1");
		map1.put("writeScore", 60);
		map1.put("machineScore", 60);
		list.add(map1);
		
		ExcelInfo excelInfo = new ExcelInfo("成绩表",titles,fields,list);
		POIUtil.writeXls03(excelInfo).write(outStream);
		outStream.close();
	}
	
	@Test
	public void test1() throws UnsupportedEncodingException {
		String str ="中文";
		String encoding ="utf-8";
		String result = StringUtil.transcodage(str, encoding);
		System.out.println(result);
	}
}
