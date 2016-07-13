<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/commons/basejs.jsp" %>
		<title>form-file（文件上传、下载）</title>
	</head>
	
	<body>
	 	<div id="dlg" class="easyui-dialog" style="width:350px;height:400px;padding:10px"
			data-options="iconCls:'icon-save',title:'Basic Dialog',buttons:'#dlg-buttons' ">
	   		<form action="" method="post">
			<table cellpadding="5">
	    		<tr>
	    			<td>file:</td>
	    			<td><input class="easyui-textbox" type="file" id="file" name="file" />
	    				<!-- data-options="required:true, missingMessage:'不能为空', validType:'length[2,5]', invalidMessage:'请输入2到5个字符！' " /> -->
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
	    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>&nbsp;&nbsp;
	    			</td>
	    		</tr>
	    	</table>
			</form> 
	   	</div>
	</body>
</html>
