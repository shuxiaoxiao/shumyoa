package com.shupro.oa.mydemo.collection.map;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * Map<key, value> 的特点：
 * 	key不可以重复，如果后插入相同的key，则覆盖之前的值
 * @author Administrator
 *
 */
public class MapDemo {

	Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * V put(K key,V value):添加元素。
	 * 如果键是第一次存储，就直接存储元素，返回null
	 * 如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
	 */
	@Before
	public void init() {
		map.put("k1", "aaa");
		map.put("k2", "bbb");
		map.put("k3", "eee");
		map.put("k4", "ccc");
		map.put("k5", "ddd");
		map.put("k1", "ddd");
		map.put("k6", "");
		//k1重复了,输出"k1:ddd"
	}
	
	//方式1：键找值
	@Test
	public void show1() {
		//键 对象
		Set<String> set = map.keySet();
		for(String key : set) {
			String value = map.get(key);
			System.out.println(key+"---"+value);
		}
	}
	
	//方式2：键值对对象找键和值
	@Test
	public void show2() {
		//键值对 对象
		Set<Map.Entry<String,String>> set2 = map.entrySet();
		for(Map.Entry<String,String> me : set2) {
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+"---"+value);
		}
	}
	
	/**
	 * 获取map key的最小值(最大值)<br>
	 * 利用Arrays.sort排序(推荐)
	 * Collections.sort(list),不能对进行排序set(通过循环将key放入list，然后排序)
	 */
	@Test
	public void getMinKey() {
		System.out.println(map);
		Set<String> set = map.keySet();
		Object[] obj = set.toArray();
		Arrays.sort(obj);
		System.out.println("最小值："+obj[0]);
		System.out.println("最大值："+obj[obj.length-1]);
		
	}
	
	/**
	 * 获取map value的最小值(最大值)<br>
	 * 利用Arrays.sort排序(推荐)
	 * Collections.sort(list),不能对进行排序set(通过循环将key放入list，然后排序)
	 */
	@Test
	public void getMinValue() {
		System.out.println(map);
		Collection<String> valcoll = map.values();
		Object[] obj = valcoll.toArray();
		Arrays.sort(obj);
		System.out.println("最小值："+obj[0]);
		System.out.println("最大值："+obj[obj.length-1]);
		
	}
	
	/**
	 * map迭代，并条件删除是注意异常,
	 * java.util.ConcurrentModificationException  at java.util.HashMap$HashIterator
	 */
	@Test
	public void remove() {
		System.out.println(map);
		//map迭代删除
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			if (key.equals("k5")) {
				it.remove();
			}
		}
		
//		//错误方式
//		Set<String> keySet = map.keySet();
//		for (String key : keySet) {
//			//java.util.ConcurrentModificationException  at java.util.HashMap$HashIterator
//			if (key.equals("k5")) {
//				map.remove(key);
//			}
//		}
		System.out.println(map);
	}
	
	/**移除空值所在的key*/
	@Test
	public void remove2() {
		System.out.println(map);
		map.remove("k6");
		System.out.println(map);
	}
}
