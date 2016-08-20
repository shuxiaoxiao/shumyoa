
com.shupro.oa.core


com.shupro.oa.utils
	excel	excel操作工具类
	http	客户端模拟发http请求
	io		io流操作工具类
	jms		邮件
	json	json工具类
	lang	常用工具类：小数精确计算工具类、日期工具类、随机数、字符串工具类等(如果觉得功能太少可以使用common-lang3)
	md5		MD5加密工具类
	page	分页操作工具类
	xml		xml操作工具类
	

===========版本：1.0.4==============
更新时间：2016-6-14
增加内容：
com.shutools.m2pro.auto
	freemarker模板的使用，实现代码生成


===========版本：1.0.3==============
更新时间：2016-6-1
增加内容：
1.com.shutools.m2pro.json.FastJsonUtil
	增加方法jsonStr2Obj，并将名称统一修改
	
2.com.shutools.m2pro.myapi.collection.map.MapDemo
	增加getMinKey方法	【获取map key的最小值(最大值)】
	增加getMinValue方法 【获取map value的最小值(最大值)】
	增加remove方法 		【map迭代，并条件删除是注意异常,】


===========版本：1.0.2==============
更新时间：2016-4-20
增加内容：
com.shutools.m2pro.jsoup
	爬虫 【思想很简单：就是通过Java访问的链接，然后拿到html字符串，然后就是解析链接等需要的数据。】
	http://blog.csdn.net/lmj623565791/article/details/23272657


===========版本：1.0.1==============
更新时间：2015-12-1
增加内容：
1.com.shutools.m2pro.lang3
	apache.commons.lang API的内容(Apache公司),对java.lang的扩展和封装
	日期处理、IO流、随机数、String工具类、单词工具类

2.com.shutools.m2pro.joda
	处理日期的工具类(Apache 公司)
	
3.com.shutools.m2pro.md5
	MD5加密算法

com.shutools.m2pro.guava 【未开始】	
	google guava API的内容	(Google 公司)
	强大点：集合类 和 缓存


===========版本：1.0.0==============
更新时间：2015-8-1
增加内容：
1.com.shutools.m2pro.myapi 【自己编写的工具，依赖于JavaSE7.0】
	集合、excel操作、异常、内部类、
	IO流
		字节流、字符流
		内存操作流(ByteArrayInputStream、ByteArrayOutputStream;CharArrayReader、CharArrayWriter;
			StringReader、StringWriter)
		properties类 【继承Hashtable】
	常用类封装为工具类
		小数精确计算工具类
		日期工具类
		随机数
		
	网络、反射、socket(网络编程)、线程
	
2.com.shutools.m2pro.xml
	4种方式,推荐使用dom4j
	
3.com.shutools.m2pro.json
	推荐使用fastjson 【如果有性能上面的要求可以使用Gson将bean转换json确保数据的正确，使用FastJson将Json转换Bean】
	
