<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>Basic LinkButton（按钮）</title>
    <link id="easyuiTheme" rel="stylesheet" type="text/css" href="${staticPath }/resource/easyui/themes/color.css" />
  </head>
  
  <body>
  	<%--属性解释
  	iconCls ： 图标
  	width : 宽度。【1.4版开始可用】注意几种Fixed Width Buttons的区别,特别是width作为属性，其值需要使用''
  	iconAlign : 按钮图标位置'left','right','top','bottom',默认值是left
  	plain : 为true时显示简洁效果,默认值是false
  	disabled : 为true时禁用按钮,默认值是false
  	 --%>
	<div style="padding:5px;">
	  	<p>Basic Buttons</p>
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add</a>&nbsp;&nbsp;
	  	<p>Fixed Width Buttons</p>
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add' " style="width:80px">Add</a>&nbsp;&nbsp;
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add' " style="width:15%">Add</a>&nbsp;&nbsp;
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',width:'80px' ">Add</a>&nbsp;&nbsp;
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',width:'15%' ">Add</a>&nbsp;&nbsp;
	  	<p>Change the icon align to place</p>
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',iconAlign:'right' ">Add</a>&nbsp;&nbsp;
	  	<p>Plain LinkButton</p>
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:'true' ">Add</a>&nbsp;&nbsp;
	  	<p>disabled或enable LinkButton</p>
	  	<a href="#" id="demoBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add',disabled:'true' ">demo按钮</a>&nbsp;&nbsp;
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add' " onclick="disable()">点击禁用</a>&nbsp;&nbsp;
	  	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add' " onclick="enable()">点击启用</a>&nbsp;&nbsp;
  	</div>
  	<div style="padding:5px;">
  		<p>Style LinkButton, c1的样式来自easyui/themes/color.css文件</p>
	  	<a href="#" class="easyui-linkbutton c1" style="width:120px">Button1</a>
		<a href="#" class="easyui-linkbutton c2" style="width:120px">Button2</a>
		<a href="#" class="easyui-linkbutton c3" style="width:120px">Button3</a>
		<a href="#" class="easyui-linkbutton c4" style="width:120px">Button4</a>
		<a href="#" class="easyui-linkbutton c5" style="width:120px">Button5</a>
		<a href="#" class="easyui-linkbutton c6" style="width:120px">Button6</a>
		<a href="#" class="easyui-linkbutton c7" style="width:120px">Button7</a>
		<a href="#" class="easyui-linkbutton c8" style="width:120px">Button8</a>
  	</div>
  	 
  <script type="text/javascript">
  	function disable(){
  		$('#demoBtn').linkbutton('disable');
  	}
  	function enable(){
  		$('#demoBtn').linkbutton('enable');
  	}
  </script>	 
  </body>
</html>
