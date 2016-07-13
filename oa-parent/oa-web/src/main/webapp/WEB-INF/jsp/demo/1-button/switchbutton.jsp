<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>SwitchButton（开关按钮）</title>
  </head>
<body>
	<div style="margin:20px 0;">
		<%--属性解释
	  	checked : 按钮是否开启,默认值是false
	  	disabled : 为true时禁用按钮,默认值是false
	  	onText : 左边文本值（反转后是右边）,默认值是ON
	  	offText : 右边文本值（反转后是左边）,默认值是OFF
	  	 --%>
		<input class="easyui-switchbutton" checked />
		<br />
		<%--checked实现的2种方式。一种是input自带的属性，一种是data-options里面的申明属性.
		实质是<input type="checkbox" value="on" />
		--%>
		<input class="easyui-switchbutton" data-options="checked:'true' " />
		<br />
		<input class="easyui-switchbutton" data-options="onText:'Yes',offText:'No' "/>
		<br />
		
	</div>
</body>
</html>