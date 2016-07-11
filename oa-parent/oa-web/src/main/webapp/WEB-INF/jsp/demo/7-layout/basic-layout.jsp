<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>Basic Layout 布局</title>
  </head>
  
  <body>
  	<%--
  		split:true,可缩动
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
