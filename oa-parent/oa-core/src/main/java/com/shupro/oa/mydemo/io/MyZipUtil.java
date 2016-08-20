package com.shupro.oa.mydemo.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MyZipUtil {

	// 将指定的zip文件解压到targetDirName目录下，其中：zipName：zip包的文件名，targetDirName：需解压到的目录
	public static void upzipFile(String zipName, String targetDirName) {
		if (!targetDirName.endsWith(File.separator)) {
			targetDirName += File.separator;
		}
		try {
			// 根据zip文件创建ZipFile对象，此类的作用是从zip文件读取条目。
			ZipFile zipFile = new ZipFile(zipName);
			ZipEntry zn = null;
			String entryName = null;
			String targetFileName = null;
			byte[] buffer = new byte[4096];
			int bytes_read;
			// 获取ZIP文件里所有的文件条目的名字
			Enumeration entrys = zipFile.entries();
			// 循环遍历所有的文件条目的名字
			while (entrys.hasMoreElements()) {
				zn = (ZipEntry) entrys.nextElement();
				// 获得每一条文件的名字
				entryName = zn.getName();
				targetFileName = targetDirName + entryName;
				if (zn.isDirectory()) {
					// 如果zn是一个目录，则创建目录
					new File(targetFileName).mkdirs();
					continue;
				} else {
					// 如果zn是一个文件，则创建父目录
					new File(targetFileName).getParentFile().mkdirs();
				}
				// 否则创建文件
				File targetFile = new File(targetFileName);
				System.out.println("正在创建文件：" + targetFile.getAbsolutePath());
				// 打开文件输出流
				FileOutputStream os = new FileOutputStream(targetFile);
				// 从ZipFile对象中打开entry的输入流
				InputStream is = zipFile.getInputStream(zn);
				while ((bytes_read = is.read(buffer)) != -1) {
					os.write(buffer, 0, bytes_read);
				}
				// 关闭流
				os.close();
				is.close();
			}
			System.out.println("解压缩"+zipName+"成功！");
		} catch (IOException err) {
			System.err.println("解压缩"+zipName+"失败: " + err);
		}
	}
	
}
