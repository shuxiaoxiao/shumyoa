<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>Basic Dialog（对话框窗口）</title>
</head>
<body>
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('open')">Open</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('close')">Close</a>
	</div>
	
	<%--属性解释,由于继承window -- panel,很多用法与window、panel相似
  	iconCls ： 图标
  	collapsible : 定义是否显示可折叠按钮,默认值是false
  	minimizable : 定义是否显示最小化按钮,默认值是false
  	maximizable : 定义是否显示最大化按钮,默认值是false
  	closable : 定义是否显示关闭按钮,默认值是false 【panel的默认值是false】
  	tools : 自定义工具菜单
  	toolbar : 对话框窗口顶部工具栏,注意与tools的区别
  	modal : 是否将窗体显示为模式化窗口,true是，false否
	 --%>
	<div id="dlg" class="easyui-dialog" title="Basic Dialog" style="width:400px;height:200px;padding:10px"
		data-options="iconCls:'icon-save',tools:'#tt',toolbar:'#toolbar',buttons:'#dlg-buttons',left:150,top:20 ">
		The dialog content.
	</div>
	<div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="javascript:alert('add')"></a>
		<a href="javascript:void(0)" class="icon-edit" onclick="javascript:alert('edit')"></a>
		<a href="javascript:void(0)" class="icon-cut" onclick="javascript:alert('cut')"></a>
		<a href="javascript:void(0)" class="icon-help" onclick="javascript:alert('help')"></a>
	</div>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok' " onclick="javascript:alert('add')">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit' " onclick="javascript:alert('edit')">修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cut' " onclick="javascript:alert('cut')">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-help' " onclick="javascript:alert('help')">帮助</a>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok' " onclick="javascript:alert('save')" >保存</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel' " onclick="$('#dlg').dialog('close');">取消</a>
	</div>
	
</body>
</html>