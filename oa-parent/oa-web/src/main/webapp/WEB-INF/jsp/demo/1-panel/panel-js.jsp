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
		<a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">Open</a>
		<%-- Close实际上是隐藏,Destroy直接删除--%>
		<a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">Close</a>
		<a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('destroy')">Destroy</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#p').panel('expand',true)">Expand</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#p').panel('collapse',true)">Collapse</a>
	</div>
	<div id="p"></div>
	<%-- <div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="javascript:$.messager.alert('警告','add')"></a>
		<a href="javascript:void(0)" class="icon-edit" onclick="javascript:alert('edit')"></a>
		<a href="javascript:void(0)" class="icon-cut" onclick="javascript:alert('cut')"></a>
		<a href="javascript:void(0)" class="icon-help" onclick="javascript:alert('help')"></a>
		<!--refresh方法最好跟上URL参数，单独用效果不佳 -->
		<a href="javascript:void(0)" class="icon-reload" onclick="javascript:$('#p').panel('refresh','${path }/initPanel');"></a>
	</div>
	<div id="footer">
		Footer Content.
	</div> --%>
	
	<script type="text/javascript">
		<%--属性解释
	  	iconCls ： 图标
	  	collapsible : 定义是否显示可折叠按钮,默认值是false
	  	minimizable : 定义是否显示最小化按钮,默认值是false
	  	maximizable : 定义是否显示最大化按钮,默认值是false
	  	closable : 定义是否显示关闭按钮,默认值是false
	  	tools : 自定义工具菜单
	  	 --%>
		<%--js生成的宽度有bug,用$(function(){});	包裹--%>
		var $panel = $('#p');
		$(function(){
			$panel.panel({
				width:700,
				height:350,
				title:'Basic Panel',
				content:'<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>',
				iconCls:'icon-save',
				collapsible:true,
				minimizable:true,
				maximizable:true,
				closable:true,
				/*tools:'#tt',
				footer:'#footer'*/
				tools: [{
				    iconCls:'icon-add',    
				    handler:function(){
				    	$.messager.alert('警告','add');
				    }    
				  },'-',//空按钮
				  {
				    iconCls:'icon-save',    
				    handler:function(){
				    	alert('save')
				    }    
				}]
	
			});
		});		
	</script>
  </body>
</html>
