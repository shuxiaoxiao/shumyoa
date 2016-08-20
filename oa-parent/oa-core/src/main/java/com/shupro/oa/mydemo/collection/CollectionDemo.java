package com.shupro.oa.mydemo.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

/**
 * 集合Collection的示例
 *
 * @ClassName: CollectionDemo
 * @author	shuheng
 * @date 2015-8-3
 */
public class CollectionDemo {
	
	Collection<String> coll = null;
	Collection<String> coll2 = null;
		
	/**添加功能
	 * add(Object obj) 添加一个元素
	 * addAll(Collection c)	添加一个集合的元素
	 */
	@Before
	public void init() {
		coll = new ArrayList<String>();
		
		//添加一个元素
		coll.add("hello");
		coll.add("world");
		coll.add("java");
		
		coll2 = new ArrayList<String>();
		coll2.add("newhello");
		coll2.add("newworld");
		coll2.add("hello");
		//添加一个集合的元素
//		coll.addAll(coll2);
	}
	
	/**移除所有元素*/
	@Test
	public void clear() {
		
		coll.clear();
	}
	
	/**移除一个元素，集合中存在的返回true，不在的返回false*/
	@Test
	public void remove() {

		System.out.println("remove:" + coll.remove("aa"));// false
		System.out.println("remove:" + coll.remove("java"));// true
	}

	/**移除一个集合的元素，只要有一个元素被移除了，就返回true*/
	@Test
	public void removeAll() {
		System.out.println("removeAll 前" + coll);
		System.out.println(coll.removeAll(coll2));// true
		System.out.println("removeAll 后" + coll);
	}
	
	/**移除一个元素，集合中存在的返回true，不在的返回false*/
	@Test
	public void contains() {
		
		System.out.println("contains:" + coll.contains("aa"));// false
		System.out.println("contains:" + coll.contains("java"));// true
	}
	
	/**
	 * 判断集合中是否包含指定的集合元素，只有包含所有的元素，才叫包含
	 * 可以理解为判断2个集合的元素是否一样
	 */
	@Test
	public void containsAll() {
		
		System.out.println("containsAll:" + coll.containsAll(coll2));// false
	}
	
	/**判断是否为空*/
	@Test
	public void isEmpty() {
		
		System.out.println("isEmpty:" + coll.isEmpty());
	}
	
	/**方式一：遍历*/
	@Test
	public void display() {
		
		Iterator<String> it = coll.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**方式二：遍历，较方式一高效，但jdk1.6之后优化了 jvm，方式一会转换成方式二*/
	@Test
	public void display2() {
		
		for (Iterator<String> it = coll.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
	
	/**方式三：遍历*/
	@Test
	public void display3() {
		
		for (String str : coll) {
			System.out.println(str);
		}
	}
	
	/**
	 * 假设有两个集合A，B。
	 * A对B做交集，最终的结果保存在A中，B不变。
	 * 返回值表示的是A是否发生过改变。
	 */
	@Test
	public void retainAll() {
		System.out.println("retainAll 前" + coll);
		System.out.println(coll.retainAll(coll2));
		System.out.println("retainAll 后" + coll);
	}
	
	@Test
	public void toArray() {
		Object[] objs = coll.toArray();
		System.out.println(objs);
	}
	
//	@After
//	public void after() {
//		System.out.println("after:"+coll);
//	}
	
}
