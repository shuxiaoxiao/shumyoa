<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>Basic Layout 布局</title>
  </head>
  
  <body>
  	<%--属性解释
	region : 布局面板位置，可用的值有：north, south, east, west, center
	split : true时用户可以通过分割栏改变面板大小,默认为false
	href : 用于读取远程站点数据的URL链接,如果是某个页面则只加载<body></body>里面的内容
  	 --%>
    <div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north'" style="height:50px">
			logo
		</div>
		<div data-options="region:'south'" style="height:50px;">
			copyright
		</div>
		<div data-options="region:'west',split:true,title:'West'" style="width:15%;">
			菜单
		</div>
		<div data-options="region:'east',split:true,title:'East'" style="width:15%;">
			聊天
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			center
		</div>
	</div>
  </body>
</html>
