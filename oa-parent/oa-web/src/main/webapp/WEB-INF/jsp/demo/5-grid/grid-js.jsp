<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>DataGrid（数据表格）</title>
  </head>
  
  <body>
	<div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north',split:true " style="height:40px;padding: 3px;">
			名称：<input type="text" id="query_name" />&nbsp;
			<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search' " onclick="searchData();">查询</a>
		</div>
		<div data-options="region:'center' ">
			<%--属性解释，属性很多对应demo和API查看即可
			rowStyler : 特定行加上样式
			formatter ： 单元格格式化
			styler : 单元格样式
			--%>
			<table id="sysUserGrid"></table>
		</div>
	</div>
	
	<script type="text/javascript">
	
		var $grid = $('#sysUserGrid');
		/**
		 * 查询用户
		 */
		function searchData(){
			$grid.datagrid('load',{
				//'deptid': $('#query_deptid').val(),
				'name': $('#query_name').val()
			});
		}
		
		$(function(){
			
			$grid.datagrid({
				idField:'id' ,		//只要创建数据表格 就必须要加 ifField
				fit:true ,//填充父容器
				fitColumns:true ,  //自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
				striped: true , //隔行变色特性 
				loadMsg: '数据正在加载,请耐心的等待...' ,
				rownumbers:true ,
				pagination: true , //启用分页
				//singleSelect:true , //单选模式 
				url:'${path}/sysUser/list', 
			    columns:[[
			        {field:'ck', width:50, checkbox: true},
					{field:'name',title:'名称'},    
					{field:'loginname',title:'登录名'},    
					{field:'pwd',title:'密码'},    
					{field:'sex',title:'性别'},    
					{field:'icon',title:'图标'},    
					{field:'phonenum',title:'手机号'},    
					{field:'phonenum2',title:'备用号'},    
					{field:'address',title:'地址'},    
					{field:'states',title:'用户状态'},    
					{field:'deptid',title:'部门id'},    
					{field:'createtime',title:'入职时间'},    
					{field:'leavetime',title:'离职时间'},    
					{field:'usertype',title:'用户类型'},    
					{field:'sotid',title:'排序号'},    
			    ]] ,
			    toolbar:[{
		    		text:'新 增' ,
					iconCls:'icon-add' , 
					handler:function(){
						$.messager.alert('提示','新增');
					}
			    },{
			    	text:'修 改' ,
					iconCls:'icon-edit' , 
					handler:function(){
						$.messager.alert('提示','修改');
					}
			     },{
			    	text:'删 除' ,
					iconCls:'icon-new-remove' , 
					handler:function(){
						$.messager.alert('提示','删除');
					}
			    }]
			});
		});
		
	</script>

  </body>
</html>
