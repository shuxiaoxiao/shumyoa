package com.shupro.oa.mydemo.io;

import java.io.File;

/**
 * 
 * @ClassName: FileDemo
 * @author shuheng
 * @date 2015-7-16
 */

public class FileDemo {
	
	public void init() {
		File file = new File("D:\\temp\\keytoolcmd.txt");		// 根据指定的路径创建一个File对象
		//mkdir() 创建文件夹,只能一层层创建
		//mkdirs() 创建文件夹,一次性创建
		//createNewFile() 创建文件
		
		System.out.println("文件名为：" + file.getName());			// 获取该File对象的名字
		System.out.println("绝对路径为：" + file.getAbsolutePath());	// 获取该File对象的绝对路径
		System.out.println("路径为：" + file.getPath());				// 获取该File对象的相对路径
		System.out.println("所属磁盘目录为：" + file.getParent());	//获取该File对象的目录
		if (!file.exists()) {
			file.mkdirs();
		}
		System.out.println("此路径名表示的文件是一个目录吗？：" + file.isDirectory());// 判断该File对象是不是目录
		System.out.println("它是处于可读状态吗？：" + file.canRead());		// 判断该File对象是否可读
		System.out.println("它是处于可写状态吗？" + file.canWrite());			// 判断该File对象是否可写
		System.out.println("该文件长度为：" + file.length() + "字节");		// 获取该File对象中的字符长度
		System.out.println("此文件最后修改的时间为：" + file.lastModified());// 获取该File对象最后修改时间
	}

}
