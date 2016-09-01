package com.shupro.oa.utils.lang3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * org.apache.commons.io 包中的FileUtils类
 * 字符串
 * @author Administrator
 *
 */
public class FileUtilDemo {
	// http://jackyrong.iteye.com/blog/2153812

	public void readAndWrite() throws IOException {

		String fileName = "D:/testexl/test2.txt";
		File file = new File(fileName);
		
		//读取时文件必须存在
//		String fileContent = FileUtils.readFileToString(file,"gbk");
//		String fileContent = FileUtils.readFileToString(file,"utf-8");
//		System.out.println(fileContent);
		
		//写操作  ：注意读写操作的编码要统一
		String fileContent ="中文";

		//文件不存在，自动创建
		FileUtils.writeStringToFile(file, fileContent, "gbk");

	}
}
