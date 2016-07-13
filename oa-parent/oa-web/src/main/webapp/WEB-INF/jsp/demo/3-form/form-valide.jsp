<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/commons/basejs.jsp" %>
		<title>form-valide（表单验证）</title>
	</head>

	<body>
		<div id="dlg" class="easyui-dialog" style="width:350px;height:400px;padding:10px"
			data-options="iconCls:'icon-save',title:'Basic Dialog',buttons:'#dlg-buttons' ">
	 	<form action="" method="post">
			<table cellpadding="5">
		 		<tr>
				<%--属性解释
				validType:'email' 一种验证规则
				validType:['email','length[0,20]'] 多种验证规则
				--%>
		  			<td>Name:</td>
		  			<td><input class="easyui-textbox" type="text" id="name" name="name" 
		  				data-options="required:true, missingMessage:'不能为空', validType:'length[2,5]', invalidMessage:'请输入2到5个字符！' " />
		  			</td>
		  		</tr>
		  		<tr>
		  			<td>Password:</td>
		  			<td><input class="easyui-textbox" type="password" id="password" name="password" 
		  				data-options="required:true, missingMessage:'不能为空', validType:'length[5,5]', invalidMessage:'请输入5个字符！' " />
		  			</td>
		  		</tr>
		  		<tr>
		  			<td>Confirm pwd:</td>
		  			<td><input class="easyui-textbox" type="password" id="password2" name="password2" 
		  				data-options="required:true, missingMessage:'不能为空', validType:'eqPwd[$(\'#password\')]' " />
		  			</td>
		  		</tr>
		  		<tr>
		  			<td>Email:</td>
		  			<td><input class="easyui-textbox" type="text" id="email" name="email" 
		  				data-options="required:true, validType:'email' " />
		  			</td>
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
	  	
	  	<script type="text/javascript">
			$(function(){
				$.extend($.fn.validatebox.defaults.rules, {
				    //二次密码是否一致
					eqPwd : {
				        validator : function(value, param) {
				            return value == $(param[0]).val();
				        },
				        message : '密码不一致！'
				    },
					//  只允许输入英文字母或数字
					engNum: {
					    validator: function (value, param) {
					        return /^[0-9a-zA-Z]*$/.test(value);
					    },
					    message: '请输入英文字母或数字'
					},
					//  只允许汉字、英文字母或数字
					chsEngNum: {
					    validator: function (value, param) {
					        return /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9])*$/.test(value);
					    },
					    message: '只允许汉字、英文字母或数字。'
					},
					//  指定字符最小长度
		            minLength: {
		                validator: function (value, param) { 
		                	return $.string.trim(value).length >= param[0]; 
		                },
		                message: "最少输入 {0} 个字符."
		            },
		            //  指定字符最大长度
		            maxLength: {
		                validator: function (value, param) { 
		                	return $.string.trim(value).length <= param[0]; 
		                },
		                message: "最多输入 {0} 个字符."
		            },
				    /**
				     * 手机号码: 
				     * 13[0-9], 14[5,7], 15[0, 1, 2, 3, 5, 6, 7, 8, 9], 17[6, 7, 8], 18[0-9], 170[0-9]
				     * 移动号段: 134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
				     * 联通号段: 130,131,132,155,156,185,186,145,176,1709
				     * 电信号段: 133,153,180,181,189,177,1700
				     */
					mobile: {
					    validator: function (value, param) { 
					    	return /^1(3[0-9]|4[57]|5[0-35-9]|7[06-8]|8[0-9])\\d{8}$/.test(value);
					    },
					    message: "不符合手机号码(中国)格式."
					}
					
				});
				
			});
		</script>
	</body>
</html>
