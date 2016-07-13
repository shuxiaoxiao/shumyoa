<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>ComboGrid（数据表格下拉框）</title>
  </head>
  
  <body>
	<input id="sysUserComboGrid" name="dept" style="width:200px;" />
	
<script type="text/javascript">

	var $combogrid = $('#sysUserComboGrid');
	
	$(function(){
		
		$combogrid.combogrid({
			panelWidth:500,
			idField:'id' ,		//只要创建数据表格 就必须要加 ifField
			textField:'loginname',
			//fit:true ,//填充父容器
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
		    ]] 
		    /* toolbar:[{
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
		    }] */
		});
	});
	
</script>

  </body>
</html>
