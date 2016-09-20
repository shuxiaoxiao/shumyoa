package com.shupro.oa.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * cxf-webservice测试接口
 * @author shu
 *
 */
@WebService
public interface TestWS {

	 @WebMethod
	 public String sayHello(@WebParam(name = "username") String username);
	 
}
