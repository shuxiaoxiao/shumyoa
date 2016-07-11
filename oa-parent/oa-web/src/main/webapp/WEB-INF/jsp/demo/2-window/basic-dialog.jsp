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
	<div id="dlg" class="easyui-dialog" title="Basic Dialog" style="width:400px;height:200px;padding:10px"
		data-options="iconCls:'icon-save',tools:'#tt',buttons:'#dlg-buttons' ">
		The dialog content.
	</div>
	<div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="javascript:alert('add')"></a>
		<a href="javascript:void(0)" class="icon-edit" onclick="javascript:alert('edit')"></a>
		<a href="javascript:void(0)" class="icon-cut" onclick="javascript:alert('cut')"></a>
		<a href="javascript:void(0)" class="icon-help" onclick="javascript:alert('help')"></a>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok' " onclick="javascript:alert('save')" >保存</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel' " onclick="$('#dlg').dialog('close');">取消</a>
	</div>
</body>
</html>