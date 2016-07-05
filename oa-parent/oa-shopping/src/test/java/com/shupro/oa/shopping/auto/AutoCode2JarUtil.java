package com.shupro.oa.shopping.auto;

import com.shupro.oa.auto.AutoCreateClassUtil;
import com.shupro.oa.auto.AutoModel;

public class AutoCode2JarUtil {
	
	public static void main(String[] args) {
		
		String diver = "com.mysql.jdbc.Driver"; 
		String jdbcUrl = "jdbc:mysql://localhost:3306/myoa?useUnicode=true&characterEncoding=UTF-8"; 
		String username = "root"; 
		String password = "root"; 
		String tableName = "shop_goods"; 
		String appPackagePrefix = "com.shupro.oa"; 
		String appName = "shopping"; 
		String sourceRoot = "src/main/java";
		AutoModel autoModel = new AutoModel(diver, jdbcUrl, username, password, 
				tableName, sourceRoot,"", appPackagePrefix,appName);
		
		
		AutoCreateClassUtil.generate2Jar(autoModel);
		
//		autoModel.setTableName("sys_role");
//		AutoCreateClassUtil.generate2Jar(autoModel);
	}
}