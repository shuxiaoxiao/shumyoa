<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>Basic Tree（树）</title>
</head>
<body>
	<%--属性解释
	method : 检索数据的HTTP方法。默认为post
	checkbox : 是否在每一个借点之前都显示复选框,默认为false
	onlyLeafCheck : 是否只在末级节点之前显示复选框,true是。与checkbox属性配套用
	dnd : 是否启用拖拽功能,默认为false
	--%>
	<div style="margin:10px;">
		<%--异步请求 --%>
		<ul id="sysDeptTree" class="easyui-tree" data-options="url:'${path}/sysDept/tree' "></ul>
	</div>
	
</body>
</html>