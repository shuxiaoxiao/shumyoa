package com.shupro.oa.utils.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	/**
	 * 获得service注解对应的类<br>
	 * 规律：@service则对应类名首字母小写，@service("xxx")则名称为xxx
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		//通过classpath载入并使用ClassPathResource
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
		return ac.getBean(beanName);
	}
}
