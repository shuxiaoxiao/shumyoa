package com.shupro.oa.mydemo.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Properties;
import java.util.Set;

/**
 * Properties:属性集合类。是一个可以和IO流相结合使用的集合类。
 * Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。 
 * 
 * 是Hashtable的子类，说明是一个Map集合。
 */
public class ProperDemo {

	public static void main(String[] args) throws IOException {
		//maven项目下文件路径
		String filePath = "src\\main\\resources\\config.properties";
//		//方式一：load(InputStream input):把文件中的数据读取到集合中
//		InputStream input = new FileInputStream(filePath);
		Properties prop = newInstall(ProperDemo.class, "config.properties");
		
//		//方式二:load(Reader reader):把文件中的数据读取到集合中
//		Reader read = new FileReader(filePath);
//		prop.load(read);
//		read.close();
//		System.out.println(prop.getProperty("jdbc.url"));
		
//		show1(prop);
//		show2(prop);
		
//		/*remove、clear操作如果不执行保存(store)操作，下次加载还会再次出现*/
//		//remove(Object key) 移除
//		prop.remove("jdbc.username");
//		System.out.println(prop);
//		//clear() 清空
//		prop.clear();
//		System.out.println(prop);
		
//		store(filePath, null, prop);
		
		
		
	}

	/**
	 * 存档
	 * @param filePath
	 * @param comments
	 * @param prop
	 * @throws IOException
	 */
	public static void store(String filePath, String comments, Properties prop) throws IOException {
		/*
		 * store(Writer writer,String comments):
		 * 把集合中的数据存储到文件,comments可用作一个标识注释
		 * 可以进行文件的保存(存档)
		 */
		Writer w = new FileWriter(filePath);
//		Writer w = new FileWriter("name.txt");//输出到项目根目录
		prop.store(w, comments);
		w.close();
	}

//	public Properties newInstall(String filePath) throws IOException {
//		InputStream input = this.getClass().getClassLoader().getResourceAsStream(filePath);
//		Properties prop = new Properties();
//		prop.load(input);
//		return prop;
//	}
	
	public static Properties newInstall(Class clazz, String filePath) throws IOException {
		InputStream input = clazz.getClassLoader().getResourceAsStream(filePath);
		Properties prop = new Properties();
		prop.load(input);
		return prop;
	}

	/**
	 * 方式一(Hashtable类的方法),注意用Object类型
	 * @param prop
	 */
	public static void show1(Properties prop) {
		//put(Object, Object)增加
		prop.put("k1", "v1");
		prop.put("k2", "v2");
		prop.put("k3", "v3");
		// 遍历集合
		Set<Object> set = prop.keySet();
		for (Object key : set) {
			Object value = prop.get(key);
			System.out.println(key + "---" + value);
		}
	}

	/**
	 * 方式二(properties类的方法),注意只能用String类型
	 * @param prop
	 */
	public static void show2(Properties prop) {
		//setProperty(String, String)增加,底层还是调用了Hashtable的put方法
		prop.setProperty("k1", "v1");
		prop.setProperty("k2", "v2");
		prop.setProperty("k3", "v3");
		// 遍历集合
		Set<String> set = prop.stringPropertyNames();
		for (String key : set) {
			String value = prop.getProperty(key);
			System.out.println(key + "---" + value);
		}
	}
	
}
