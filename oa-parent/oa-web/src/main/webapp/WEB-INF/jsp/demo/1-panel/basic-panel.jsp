<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>Basic Panel（面板）</title>
  </head>
  
  <body>
  	<div style="margin:20px 0 10px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">Open</a>
		<%-- Close实际上是隐藏,Destroy直接删除--%>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">Close</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#p').panel('destroy')">Destroy</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#p').panel('expand',true)">Expand</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#p').panel('collapse',true)">Collapse</a>
		<br />
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#p').panel('setTitle','new setTitle')">SetTitle</a>
	</div>
	
	<%--属性解释
	title : 标题,如果没有title,这在该栏的属性均不显示
  	iconCls ： 图标
  	collapsible : 定义是否显示可折叠按钮,默认值是false
  	minimizable : 定义是否显示最小化按钮,默认值是false
  	maximizable : 定义是否显示最大化按钮,默认值是false
  	closable : 定义是否显示关闭按钮,默认值是false
  	tools : 自定义工具菜单
  	
  	 --%>
	<div id="p" class="easyui-panel" style="width:700px;height:350px;padding:10px;"
		data-options="title:'Basic Panel',iconCls:'icon-save',collapsible:true,minimizable:true,maximizable:true,closable:true,
		tools:'#tt',footer:'#footer' ">
		<%--这里放需要展示的内容 --%>
		<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
	</div>
	<div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="javascript:$.messager.alert('警告','add')"></a>
		<a href="javascript:void(0)" class="icon-edit" onclick="javascript:alert('edit')"></a>
		<a href="javascript:void(0)" class="icon-cut" onclick="javascript:alert('cut')"></a>
		<a href="javascript:void(0)" class="icon-help" onclick="javascript:alert('help')"></a>
		<%--refresh方法最好跟上URL参数，单独用效果不佳 --%>
		<a href="javascript:void(0)" class="icon-reload" onclick="javascript:$('#p').panel('refresh','${path }/initPanel');"></a>
	</div>
	<div id="footer" style="padding:5px;">
		Footer Content.
	</div>
	
  </body>
</html>
