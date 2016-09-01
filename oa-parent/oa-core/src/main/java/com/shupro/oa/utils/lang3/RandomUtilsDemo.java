package com.shupro.oa.utils.lang3;

import org.apache.commons.lang3.RandomUtils;

/**
 * apache.commons.lang3包中的RandomUtils类
 * 随机数
 * @author Administrator
 *
 */
public class RandomUtilsDemo {

	public void nextInt() {
		for (int i = 0; i < 10000; i++) {
			// nextInt(int startInclusive, int endExclusive)  
			int num = RandomUtils.nextInt(100, 102);
			
			System.out.println(num);
			
		}
	}
}
