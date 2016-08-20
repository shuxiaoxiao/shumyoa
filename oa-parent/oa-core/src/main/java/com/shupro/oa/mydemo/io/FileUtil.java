package com.shupro.oa.mydemo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 文件分割，合并（合并流）
 * 
 * @author Administrator
 *
 */
public class FileUtil {
	
	public static boolean isExist(String filePath){
		
		return new File(filePath).exists();
	}

	/**
	 * 读操作 字节流（二进制流）
	 * 
	 * @throws IOException
	 */
	public static String readToStringByBinary(String filePath, String encoding)
			throws IOException {
		// 创建字节输入流对象
		FileInputStream fis = new FileInputStream(filePath);
		// 转换流
		InputStreamReader inread = new InputStreamReader(fis, encoding);

		char[] chs = new char[1024];
		int len = 0;
		StringBuffer sb = new StringBuffer();

		while ((len = inread.read(chs)) != -1) {
			sb.append(new String(chs, 0, len));
		}
		// 释放资源
		fis.close();
		inread.close();

		return sb.toString();
	}

	/**
	 * 读操作 字符流
	 */
	public static String readToStringByText(String filePath) throws IOException {
		
		// 创建字符缓冲输入流对象
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		
		StringBuffer sb = new StringBuffer();
		String s =null;//存放一行内容
		////BufferedReader的readLine方法
		while ((s = br.readLine()) != null) {
			sb.append(s+"\n");
		}
//		//BufferedReader的read方法
//		char[] chs = new char[1024];
//		int len = 0;
//		StringBuffer sb = new StringBuffer();
//		while ((len = br.read(chs)) != -1) {
//			sb.append(new String(chs, 0, len));
//		}

		// 释放资源
		br.close();
		return sb.toString();
	}

	/**
	 * 写操作 字节流（二进制流）
	 * 
	 * @throws IOException
	 */
	public static void writeByBinary(String filePath, String data, String encoding)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		OutputStreamWriter outwrite = new OutputStreamWriter(fos,encoding);
		// 写数据
		outwrite.write(data);
		// 刷新缓冲区
		outwrite.flush();
		//释放资源
		fos.close();
		outwrite.close();
	}
	
	/**
	 * 写操作 字符流
	 */
	public static void writeByText(String filePath, String data) 
			throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		
		// 写数据
		bw.write(data);
		// 刷新缓冲区
		bw.flush();
		//释放资源
		bw.close();
	}
	
}
