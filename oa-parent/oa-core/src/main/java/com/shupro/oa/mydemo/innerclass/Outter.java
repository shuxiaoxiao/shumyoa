package com.shupro.oa.mydemo.innerclass;

/**
 * 内部类可以加上全新修饰符，因为内部类可以理解为外部类的成员变量
 * 分类：
 * 	（1）成员式：静态内部类、成员内部类
	（2）局部式：局部内部类、匿名内部类
 * @ClassName: Outter
 * @author	shuheng
 */
public class Outter {
	private String str = "普通变量";
	private static String str2 = "静态变量";
	
	/** 静态内部类
	 * (1)只能访问外部类的静态成员
	 * (2)可以有静态和非静态方法
	 */
	public static class StaticInner {
		//内部类中的变量，可以直接访问
		private String innerStr ="内部类普通变量";
		
		public void show() {
			System.out.println(str2);
			System.out.println(innerStr);
		}
		
		public static void show2() {
			System.out.println(str2);
		}
	}
	
	/** 成员内部类
	 * 
	 */
	class Inner {
		public void show() {
			System.out.println(str);
		}
	}
	
	public void method() {
		
		final String num = "局部内部类变量";
		/** 局部内部类
		 * （1）访问局部变量——局部变量必须被final修饰。
		  	因为局部变量使用完毕就消失，而堆内存的数据并不会立即消失。
		 	所以，堆内存还是用该变量，而改变量已经没有了。
		 	为了让该值还存在，就加final修饰。
		 	通过反编译工具我们看到了，加入final后，堆内存直接存储的是值，而不是变量名。
		 */
		class JubuInner {
			public void show() {
				System.out.println(num);
			}
		}
		
		JubuInner i = new JubuInner();
		i.show();
		
	}
	
	
	public static void main(String[] args) {
		
		/** 调用 静态内部类
		 * 格式：外部类名.内部类名 对象名 = new 外部类名.内部类名();
		 */
		Outter.StaticInner os = new Outter.StaticInner();
		os.show();
		
		/** 调用 成员内部类
		 * 格式：外部类名.内部类名 对象名 = 外部类对象.内部类对象;
		 */
		Outter.Inner oi = new Outter().new Inner();
		oi.show();
		
		/** 调用 局部内部类
		 * 格式：外部类名.内部类名 对象名 = 外部类对象.内部类对象;
		 */
		Outter out = new Outter();
		out.method();
		
	}
}
