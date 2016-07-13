<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>ComboTree（树形下拉框）</title>
  </head>
  
  <body>
  	<br />
  	<%-- <select id="pid" class="easyui-combotree form-input" name="pid"
		data-options="url:'${path}/sysDept/tree',required:true,missingMessage: '请选择上级部门' ">
	</select> --%>  
	<input class="form-input" id="pidCombotree" name="pid" />
	
	<script type="text/javascript">
	
		var $combotree = $('#pidCombotree');
		
		$(function(){
			var treeURL = '${path}/sysDept/tree';
			
			$combotree.combotree({
				url:treeURL ,  
				required: true ,
				missingMessage: '请选择上级部门',
				onLoadSuccess : function(node, data){
					var treeObj = $combotree.combotree('tree');
					var rooNode = treeObj.tree('getRoot');
					//console.log(rooNode);
					//展开根节点
					treeObj.tree('expand',rooNode.target);
					//生效,但是是展开所有
					//treeObj.tree('expandAll');
				}
			});
			
		});
		
	</script>

  </body>
</html>
