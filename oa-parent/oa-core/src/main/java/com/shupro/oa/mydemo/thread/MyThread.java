package com.shupro.oa.mydemo.thread;

/*
 * 该类要重写run()方法,为什么呢?
 * 不是类中的所有代码都需要被线程执行的。
 * 而这个时候，为了区分哪些代码能够被线程执行，java提供了Thread类中的run()用来包含那些被线程执行的代码。
 */
public class MyThread extends Thread {

	@Override
	public void run() {
		for (int x = 0; x < 200; x++) {
			System.out.println(x);
		}
	}

}
