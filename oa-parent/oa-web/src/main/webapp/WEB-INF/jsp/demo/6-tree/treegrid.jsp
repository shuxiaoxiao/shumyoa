<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/commons/basejs.jsp" %>
	<title> treeGrid（树形表格）</title>
  </head>
  
  <body>
	<%--treegrid不适合做搜索查询  --%>
	<%--属性解释
	idField : 关键字段来标识树节点
	treeField : 树节点字段
	method : 检索数据的HTTP方法。默认为post
	checkbox : 是否在每一个借点之前都显示复选框,默认为false
	onlyLeafCheck : 是否只在末级节点之前显示复选框,true是。与checkbox属性配套用
	dnd : 是否启用拖拽功能,默认为false
	--%>
	<table id="sysDeptTreeGrid"></table>
	
	<script type="text/javascript">
		var $treeGrid = $('#sysDeptTreeGrid');
		
		$(function(){
			$treeGrid.treegrid({
			    url:'${path}/sysDept/treeGrid',
			    idField:'deptid',
			    treeField:'name',
			    fit:true ,//填充父容器
			    rownumbers:true ,
				//singleSelect:false , //true为单选模式 ,false为多选
			    columns:[[    
					{field:'ck', width:50, checkbox: true},      
					{field:'deptid',title:'部门id'},    
					{field:'name',title:'部门名称'},    
					{field:'pid',title:'父id'},    
					{field:'levels',title:'层级'},    
					{field:'createtime',title:'创建时间'},    
					{field:'description',title:'描述'},    
					{field:'sotid',title:'排序号'}     
			    ]],
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
					iconCls:'icon-remove' , 
					handler:function(){
						$.messager.alert('提示','删除');
					}
			     },{
			    	text:'刷新' ,
					iconCls:'icon-reload' , 
					handler:function(){
						$treeGrid.treegrid('reload');
					}
			    }],
			    onLoadSuccess : function(node, data){
					var rooNode = $treeGrid.treegrid('getRoot');
					//console.log(rooNode);
					//展开根节点
					$treeGrid.treegrid('expand',rooNode.deptid);//指定的是idField对应的值
					//生效,但是是展开所有
					//$treeGrid.treegrid('expandAll');
				}
			});  
			
		});
		
	</script>

  </body>
</html>
