<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>Basic ComboBox（下拉列表框）</title>
  </head>
  
  <body>
	<%--属性解释
	valueField : 值名称绑定到该下拉列表框
  	textField ：字段名称绑定到该下拉列表框
  	 --%>
  	 <div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert($('#language').combobox('getValue'))">GetValue</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#language').combobox('disable')">Disable</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#language').combobox('enable')">Enable</a>
	</div>
	<select class="easyui-combobox" id="language" name="language">
		<option value="ar">Arabic</option>
		<option value="bg">Bulgarian</option>
		<option value="ca">Catalan</option>
		<option value="zh-cht">Chinese Traditional</option>
		<option value="cs">Czech</option>
		<option value="da">Danish</option>
		<option value="nl">Dutch</option>
		<option value="en" selected="selected">English</option>
	</select>
	
  </body>
</html>
