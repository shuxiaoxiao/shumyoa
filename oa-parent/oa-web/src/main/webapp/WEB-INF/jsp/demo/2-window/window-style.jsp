<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>Window-style（窗口）</title>
	<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${staticPath }/resource/easyui/themes/color.css" />
</head>
<body>
	<%--属性解释
	  	iconCls ： 图标
	  	collapsible : 定义是否显示可折叠按钮,默认值是true 【panel的默认值是false】
	  	minimizable : 定义是否显示最小化按钮,默认值是true 【panel的默认值是false】
	  	maximizable : 定义是否显示最大化按钮,默认值是true 【panel的默认值是false】
	  	closable : 定义是否显示关闭按钮,默认值是true 【panel的默认值是false】
	  	tools : 自定义工具菜单
	  	modal : 是否将窗体显示为模式化窗口,true是，false否
	  	cls : 添加一个CSS类ID到面板。
	 --%>
	
	<div style="margin:10px;">
		<div class="easyui-window" title="Window" data-options="width:300,height:150,left:10,top:10,inline:true">
			<p class="w-content">Window content</p>
		</div>
		<div class="easyui-window" title="Window" data-options="width:300,height:150,left:320,top:10,inline:true,cls:'c1'">
			<p class="w-content">Window content</p>
		</div>
		<div class="easyui-window" title="Window" data-options="width:300,height:150,left:630,top:10,inline:true,cls:'c2'">
			<p class="w-content">Window content</p>
		</div>
	</div>
	
		<script type="text/javascript">
		$('.easyui-window').window({
			collapsible: false,
			minimizable: false,
			maximizable: false,
			closable: false
		});
	</script>
</body>
</html>