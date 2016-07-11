<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>Window（窗口）</title>
</head>
<body>
	<div style="margin:10px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('open')">Open</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')">Close</a>
	</div>
	<%--属性解释,由于继承panel,很多用法与panel相似
	  	iconCls ： 图标
	  	collapsible : 定义是否显示可折叠按钮,默认值是true 【panel的默认值是false】
	  	minimizable : 定义是否显示最小化按钮,默认值是true 【panel的默认值是false】
	  	maximizable : 定义是否显示最大化按钮,默认值是true 【panel的默认值是false】
	  	closable : 定义是否显示关闭按钮,默认值是true 【panel的默认值是false】
	  	tools : 自定义工具菜单
	  	modal : 是否将窗体显示为模式化窗口,true是，false否
	 --%>
	<div id="w" class="easyui-window" title="Basic Window" style="width:500px;height:200px;padding:10px;"
		data-options="iconCls:'icon-save',tools:'#tt' ">
		The window content.
	</div>
	<div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="javascript:alert('add')"></a>
		<a href="javascript:void(0)" class="icon-edit" onclick="javascript:alert('edit')"></a>
		<a href="javascript:void(0)" class="icon-cut" onclick="javascript:alert('cut')"></a>
		<a href="javascript:void(0)" class="icon-help" onclick="javascript:alert('help')"></a>
	</div>
	
</body>
</html>