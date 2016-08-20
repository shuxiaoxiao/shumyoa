package com.shupro.oa.mydemo.innerclass;

/**
 * 匿名内部类的使用
 *
 * @ClassName: AnonymousInner
 * @author	shuheng
 */
public class AnonymousInner {
	public static void main(String[] args) {
		  Outer.method().show();
	  }
}

interface Inter {
	void show();
}

class Outer { 
	/* 分析从main方法中知道
	1:Outer.method()可以看出method()应该是Outer中的一个静态方法。
	2:Outer.method().show()可以看出method()方法的返回值是一个对象。
		又由于接口Inter中有一个show()方法,所以我认为method()方法的返回值类型是一个接口。
	*/
	public static Inter method() {
		//子类对象 -- 子类匿名对象
		return new Inter() {
				public void show() {
					System.out.println("HelloWorld");
				}
			};
	}

}
