<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>DataGrid（数据表格）</title>
  </head>
<body>
	<table class="easyui-datagrid" title="DataGrid（数据表格）" style="width:700px;height:250px"
			data-options="
				pagination: true ,
				singleSelect: true,
				iconCls: 'icon-save',
				url:'${path}/sysUser/list'
			">
		<thead>
			<tr>
				<th data-options="field:'ck', width:50, checkbox: true "></th>
				<th data-options="field:'name' ">名称</th>
				<th data-options="field:'loginname'">登录名</th>
				<th data-options="field:'sex' ">性别</th>
				<th data-options="field:'phonenum' ">手机号</th>
				<th data-options="field:'address',width:250">地址</th>
				<th data-options="field:'createtime',width:60,align:'center'">入职时间</th>
				<th data-options="field:'leavetime',width:60,align:'center'">离职时间</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>