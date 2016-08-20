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
   		<form id="ff" action="" method="post" enctype="multipart/form-data">
		<table cellpadding="5">
    		<tr>
    			<td>file:</td>
    			<td><input class="easyui-filebox" id="file" name="file" data-options="buttonText:'选择文件' " />
    				<!-- data-options="required:true, missingMessage:'不能为空', validType:'length[2,5]', invalidMessage:'请输入2到5个字符！' " /> -->
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<a href="#" id="formSubmit" class="easyui-linkbutton" data-options="iconCls:'icon-ok' ">提交</a>&nbsp;&nbsp;
    			</td>
    		</tr>
    	</table>
		</form>
   	</div>
   	
   	<script type="text/javascript">
	   	var $form = $('#ff');
		$(function(){
			$('#formSubmit').click(function(){
				/* 表单提交方式(保存)*/
				$form.form('submit',{
			        url: '${path}/sysUser/upload',
			        success: function(result){
			        	//var data = JSON.parse(result);//Json对象
			        	var data = $.parseJSON(result);//jq对象
			        	console.log(data);
			        	
			        	//成功后的操作,此处需要将result先转换一次
			        }
				}); 
			});
		});
	</script>
</body>
</html>
