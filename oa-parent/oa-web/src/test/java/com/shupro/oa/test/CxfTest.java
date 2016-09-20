package com.shupro.oa.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import com.shupro.oa.webservice.TestWS;

public class CxfTest {

	@Test
	public void test1() throws Exception {
		JaxWsProxyFactoryBean  factoryBean=new JaxWsProxyFactoryBean();
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        factoryBean.setServiceClass(TestWS.class);
        factoryBean.setAddress("http://localhost/oa/webservice/testWS");
        TestWS impl=(TestWS) factoryBean.create();
        System.out.println(impl.sayHello("张三"));
//		 JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//	        Client client = dcf.createClient("http://localhost/oa/webservice/testWS?wsdl");
//	        //sayHello 为接口中定义的方法名称   张三为传递的参数   返回一个Object数组
//	        Object[] objects=client.invoke("sayHello", "张三"); 
//	        //输出调用结果
//	        System.out.println(objects[0].toString());
	}
	
	public static void main(String[] args) {
		JaxWsProxyFactoryBean  factoryBean=new JaxWsProxyFactoryBean();
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        factoryBean.setServiceClass(TestWS.class);
        factoryBean.setAddress("http://localhost/oa/webservice/testWS");
        TestWS impl=(TestWS) factoryBean.create();
        System.out.println(impl.sayHello("张三"));
	}
}
