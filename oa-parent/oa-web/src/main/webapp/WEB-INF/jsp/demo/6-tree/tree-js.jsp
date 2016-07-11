<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>Basic Tree（树）</title>
</head>
<body>
	<div style="margin:10px;">
		<ul id="sysDeptTree"></ul>
	</div>
	<div style="margin:10px;">
		<ul id="sysDeptTree2"></ul>
		<a href="#" class="easyui-linkbutton" onclick="getChecked()">GetChecked</a> 
	</div>
	
<script type="text/javascript">
	<%--属性解释
		method : 检索数据的HTTP方法。默认为post
		animate : 节点在展开或折叠的时候是否显示动画效果,默认为false
		checkbox : 是否在每一个借点之前都显示复选框,默认为false
		onlyLeafCheck : 是否只在末级节点之前显示复选框,默认为false。与checkbox属性配套用
		lines : 是否显示树控件上的虚线,默认为false
		dnd : 是否启用拖拽功能,默认为false
	--%>
	var $tree = $('#sysDeptTree');
	var $tree2 = $('#sysDeptTree2');
	$(function(){
		var treeURL = '${path}/sysDept/tree';
		$tree.tree({
			url:treeURL , 
			//animate:true ,
			//lines:true,
			//checkbox:true ,
			//cascadeCheck : false ,
			//onlyLeafCheck: true, //是否只在末级节点之前显示复选框,true是。与checkbox属性配套用
			//dnd: true	//是否启用拖拽功能,true是
			onLoadSuccess : function(node, data){
				var rooNode = $tree.tree('getRoot');
				//console.log(rooNode);
				//展开根节点
				$tree.tree('expand',rooNode.target);
				//生效,但是是展开所有
				//$tree.tree('expandAll');
			}
		});
		
		$tree2.tree({
			url:treeURL , 
			//animate:true ,
			//lines:true,
			checkbox:true ,
			//cascadeCheck : false ,
			onlyLeafCheck: true, //是否只在末级节点之前显示复选框,true是。与checkbox属性配套用
			//dnd: true	//是否启用拖拽功能,true是
			onLoadSuccess : function(node, data){
				var rooNode = $tree2.tree('getRoot');
				//console.log(rooNode);
				//展开根节点
				$tree2.tree('expand',rooNode.target);
				//生效,但是是展开所有
				//$tree.tree('expandAll');
			}
		});
	});	
	
	function getChecked(){
		var nodes = $tree2.tree('getChecked');
		var s = '';
		for(var i=0; i<nodes.length; i++){
			if (s != '') s += ',';
			s += nodes[i].text;
		}
		alert(s);
	}
	
</script>

</body>
</html>