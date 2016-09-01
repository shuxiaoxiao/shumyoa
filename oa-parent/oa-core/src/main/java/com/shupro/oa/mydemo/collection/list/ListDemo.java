package com.shupro.oa.mydemo.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List的特有功能
 * @author Administrator
 *
 */
public class ListDemo {
	List<String> list = new ArrayList<String>() ;
	
	/**
	 * 普通添加 和 在指定位置添加元素
	 */
	public void init() {
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		list.add("555");
		//在指定位置添加元素
		list.add(3,"666");
		//输出结果：111	222	333	666	444	555
	}
	
	/**
	 * 元素展示（方法一，推荐使用）
	 * get(int index)：获取指定位置的元素
	 */
	public void show1() {
		for (int i = 0,max =list.size(); i < max; i++) {
			//Object get(int index)：获取指定位置的元素
			System.out.println(list.get(i));
		}
	}
	/**
	 * 元素展示（方法二）
	 */
	public void show2() {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
