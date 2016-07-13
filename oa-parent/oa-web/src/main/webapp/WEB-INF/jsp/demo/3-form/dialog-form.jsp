<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>Form Dialog 弹窗</title>
</head>
<body>
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('open')">Open</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('close')">Close</a>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:300px;height:400px;padding:10px"
		data-options="iconCls:'icon-save',title:'Basic Dialog',buttons:'#dlg-buttons' ">
		<%--方法解释
		submit : 表单提交
	  	load ：读取记录填充到表单中。数据参数可以是一个字符串或一个对象类型
	  	clear : 清除表单数据
	  	reset : 重置表单数据
	  	 --%>		
		<form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" id="name" name="name" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Password:</td>
	    			<td><input class="easyui-textbox" type="password" id="password" name="password" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Email:</td>
	    			<td><input class="easyui-textbox" type="text" id="email" name="email" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Message:</td>
	    			<td><input class="easyui-textbox" id="message" name="message" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Language:</td>
					<td>
						<select class="easyui-combobox" id="language" name="language">
							<option value="ar">Arabic</option>
							<option value="bg">Bulgarian</option>
							<option value="ca">Catalan</option>
							<option value="zh-cht">Chinese Traditional</option>
							<option value="cs">Czech</option>
							<option value="da">Danish</option>
							<option value="nl">Dutch</option>
							<option value="en" selected="selected">English</option>
						</select>
					</td>
				</tr>
	    	</table>
	    </form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok' " onclick="getFormVals1()" >取值1</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok' " onclick="getFormVals2()" >取值2</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-clear' " onclick="clearForm()" >清空</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-clear' " onclick="resetForm()" >重置</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel' " onclick="$('#dlg').dialog('close');">取消</a>
	</div>
	
	<script type="text/javascript">
		var $form = $('#ff');
		$(function(){
			/* 表单提交方式(保存)
			$form.form('submit',{
		        url: '${path}/sysUser/' + url,
		        success: function(result){
		        	//var data = JSON.parse(result);//Json对象
		        	var data = $.parseJSON(result);//jq对象
		        	//成功后的操作,此处需要将result先转换一次
		        }
			}); */
		});
		
		/** easyUI方式获取 */
		function getFormVals1(){
			var ss = $('#name').textbox('getValue');
			console.info("name1:"+ss);
			var language = $('#language').combobox('getValue');
			console.info("language1:"+language);
		}
		
		/** jq方式获取(推荐) */
		function getFormVals2(){
			//var $form = $('#ff');
			var ss = $('#name').val();
			console.info("name2:"+ss);
			var language = $('#language').val();
			console.info("language2:"+language);
		}
		
		function clearForm(){
			//清空表单(首选)
			$form.form('clear');
			//如果上面的表单清空不好用,则换成jq的表单清空
			//$form.get(0).reset();
		}
		
		function resetForm(){
			//重置表单(首选)
			$form.form('reset');
			//如果上面的表单清空不好用,则换成jq的表单清空
			//$form.get(0).reset();
		}
		
	</script>
</body>
</html>